package application.controller;

import application.model.*;
import storage.Storage;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Controller {
    private static Controller uniqueInstance;
    private Storage storage;

    /**
     * Sikrer at man kun kan oprette ét controller-objekt
     * Note: Singleton
     */
    public static Controller getInstance(){
        if (uniqueInstance==null){uniqueInstance = new Controller();}
        return uniqueInstance;
    }

    private Controller(){
        storage=Storage.getInstance();
    }

    /**
     * Opretter en ny produktgruppe og tilføjer det til Storage
     * Hvis produktgruppens navn allerede findes kastes IllegalArgumentException og produktgruppen oprettes ikke
     */
    public ProduktGruppe createProduktGruppe(String navn) {
        for (int i = 0; i < Storage.getInstance().getProduktGrupper().size(); i++){
        if (Storage.getInstance().getProduktGrupper().get(i).getNavn().equals(navn)) {
        throw new IllegalArgumentException("Produktgruppen findes allerede");
        }
        }
            ProduktGruppe pg = new ProduktGruppe(navn);
            Storage.getInstance().addProduktGruppe(pg);
            return pg;
        }

    public ArrayList<ProduktGruppe> getProduktGrupper(){
        return Storage.getInstance().getProduktGrupper();
    }

    public void updateProduktGruppe(ProduktGruppe produktGruppe, String navn){
        produktGruppe.setNavn(navn);
    }

    public void removeProduktGruppe(ProduktGruppe produktGruppe){
        Storage.getInstance().removeProduktGruppe(produktGruppe);
    }
    // -------------------------------------------------------------------------------------------------------------

    /**
     * Opretter en ny salgssituation og tilføjer det til Storage
     * Hvis salgssituationens navn allerede er oprettet afbrydes oprettelsen og en IllegalArgumentException kastes
     */
    public Salgssituation createSalgssituation(String navn, String beskrivelse) {
        for (int i = 0; i < Storage.getInstance().getSalgssituationer().size(); i++) {
            if (Storage.getInstance().getSalgssituationer().get(i).getNavn().equals(navn)) {
                throw new IllegalArgumentException("Salgssituation findes allerede");
            }
        }
            Salgssituation ss = new Salgssituation(navn, beskrivelse);
            Storage.getInstance().addSalgssituation(ss);
            return ss;
        }

    public ArrayList<Salgssituation> getSalgssituationer(){
        return Storage.getInstance().getSalgssituationer();
    }

    public void updateSalgssituation(Salgssituation salgssituation, String navn, String beskrivelse){
        salgssituation.setNavn(navn);
        salgssituation.setBeskrivelse(beskrivelse);
    }
    public void removeSalgssituation(Salgssituation salgssituation) {
        Storage.getInstance().removeSalgssituation(salgssituation);
    }

    // ------------------------------------------------------------------------------------------------------------
    public Betaling createBetaling(Betalingsformer betalingsform){
        for (int i = 0; i < Storage.getInstance().getAlleBetalinger().size(); i++) {
            if (Storage.getInstance().getAlleBetalinger().get(i).getBetalingsform().equals(betalingsform)) {
                throw new IllegalArgumentException("Betalingsformen findes allerede");
            }
        }
        Betaling betaling = new Betaling(betalingsform);
        Storage.getInstance().addBetaling(betaling);
        return betaling;
    }

    public ArrayList<Betaling> getAlleBetalinger() {
        return Storage.getInstance().getAlleBetalinger();
    }

    public void removeBetaling(Betaling betaling){
        Storage.getInstance().removeBetaling(betaling);
    }

    // ------------------------------------------------------------------------------------------------------------
    public Pant createPant(double beloeb) {
        Pant pant = new Pant(beloeb);
        Storage.getInstance().addPant(pant);
        return pant;
    }

    public ArrayList<Pant> getAltPant() {
        return Storage.getInstance().getAltPant();
    }

    public void removePant(Pant pant){
        Storage.getInstance().removePant(pant);
    }

    // ------------------------------------------------------------------------------------------------------------
    public ArrayList<Salg> getSalgsliste(){
        return Storage.getInstance().getSalgsliste();
    }

    public ArrayList<Salg> getSalgsObejkter(){
        ArrayList salgsObejkter = new ArrayList();
        for (Salg s : Storage.getInstance().getSalgsliste()){
            if (s instanceof Salg) {salgsObejkter.add(s);}
        }
        return salgsObejkter;
    }

    public ArrayList<Leje> getLejeObejkter(){
        ArrayList lejeObejkter = new ArrayList();
        for (Salg s : Storage.getInstance().getSalgsliste()){
            if (s instanceof Leje) {lejeObejkter.add(s);}
        }
        return lejeObejkter;
    }

    /**
     * Opretter et nyt salgsobjekt og tilføjer det til Storage
     */
    public Salg createSalg(Salgssituation salgssituation){
        Salg salg = new Salg(salgssituation);
        Storage.getInstance().addSalg(salg);
        return salg;

    }

    public Salg addSalg(Salg salg){
        Storage.getInstance().addSalg(salg);
        return salg;
    }

    /**
     * Opretter et nyt lejeobjekt og tilføjer det til Storage
     */
    public Leje createLeje(Salgssituation salgssituation){
        Leje leje = null;
        leje = new Leje(salgssituation,false,leje.pantBeloebIndbetalt(),LocalDate.now());
        Storage.getInstance().addSalg(leje);
        return leje;
    }

    public Leje tvingSalgTilLeje(Salg salg){
        Leje leje = new Leje(salg.getSalgssituation(),false,0,salg.getTidspunktBetaling().toLocalDate());
        leje.setPantBeloebInbetalt(leje.pantBeloebIndbetalt());
        for (Ordrelinje o : salg.getOrdrelinjer()) {
            leje.createOrdrelinje(o.getAntal(), o.getProdukt());
        }
        leje.beregnSamletBeloebOgKlip();
        Storage.getInstance().addSalg(leje);
        return leje;
    }

    public void updateSalg(Salg salg, LocalDateTime tidspunktBetaling, double samletBeloeb, int samletAntalKlip){
        salg.setTidspunktBetaling(tidspunktBetaling);
        salg.setSamletBeloeb(samletBeloeb);
        salg.setSamletAntalKlip(samletAntalKlip);
    }

    public void removeSalg(Salg salg){
        Storage.getInstance().removeSalg(salg);
    }
    // -------------------------------------------------------------------------------------------------------------

    public double getDagsopgoer(LocalDate date){
        double DagsSum = 0;
        for(Salg s : Controller.getInstance().getSalgsObejkter())
            if (s.getTidspunktBetaling().getDayOfYear()== date.getDayOfYear()){
                DagsSum+=s.getSamletBeloeb();
            }
        return DagsSum;
    }

    //Kan bruges en smartere ift Collections/Maps
    public ArrayList<Salg> getDagsKvitteringer(LocalDate date) {
        ArrayList<Salg> kvitteringer = new ArrayList();
        for (Salg s : Controller.getInstance().getSalgsObejkter()) {
            if (s.getTidspunktBetaling().getDayOfYear() == date.getDayOfYear()) {
                kvitteringer.add(s);
            }
        }
        return kvitteringer;
    }

    public ArrayList<Leje> getIkkeAfleveredeUdlejedeProdukter(){
        ArrayList<Leje> lejeListe = new ArrayList();
        for(Leje l : getLejeObejkter())
            if (l.isBetalt()==false){
                lejeListe.add(l);
            }
        return lejeListe;
    }

    /**
     * samlet antal klip brugt på produkter for en givet periode
     */
    public int getAntalBrugteKlip(LocalDate start, LocalDate slut) {
        int sum = 0;
        for (int i = 0; i < Storage.getInstance().getSalgsliste().size(); i++) {
            Salg salg = Storage.getInstance().getSalgsliste().get(i);
            if (!salg.getTidspunktBetaling().toLocalDate().isBefore(start) &&
                    !salg.getTidspunktBetaling().toLocalDate().isAfter(slut)) {
               sum += salg.getSamletAntalKlip();
            }
        }
        return sum;
    }

    /**
     * samlet antal klip brugt på produkter for en givet periode - her fordelt på de enkelte produkter
     */
    public ArrayList<Ordrelinje> getPrProduktAntalKlipIPeriode(){
        ArrayList<Ordrelinje> sumKlip = new ArrayList<>();
        for (Salg s : Storage.getInstance().getSalgsliste()){
                for (int i = 0; i < s.getOrdrelinjer().size(); i++) {
                    if (s.getOrdrelinjer().get(i).getBetaling().getBetalingsform() == Betalingsformer.KLIPPEKORTBETALING) {
                        sumKlip.add(s.getOrdrelinjer().get(i));
                    }
            }
        }
        return sumKlip;
    }


    // ------------------------------------------------------------------------------------------------------------

    //Serializable

    public void loadStorage() {
        try (FileInputStream fileIn = new FileInputStream("storage.ser")) {
            try (ObjectInputStream in = new ObjectInputStream(fileIn);) {
                storage = (Storage) in.readObject();

                System.out.println("Storage loaded from file storage.ser");
            } catch (ClassNotFoundException ex) {
                System.out.println("Error loading storage object");
                throw new RuntimeException(ex);
            }
        } catch (IOException ex) {
            System.out.println("Error loading storage object");
            throw new RuntimeException(ex);
        }
    }

    public void saveStorage() {
        try (FileOutputStream fileOut = new FileOutputStream("storage.ser")) {
            try (ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
                out.writeObject(storage);
                System.out.println("Storage saved in file storage.ser");
            }
        } catch (IOException ex) {
            System.out.println("Error saving storage object");
            throw new RuntimeException(ex);
        }
        Pris pr13 = s2.createPris(599, p7);
        Pris pr14 = s2.createPris(175, p8);
        Pris pr15 = s2.createPris(350, p9);

        Pris pr16 = s2.createPris(775, p10);
        Pris pr17 = s2.createPris(775, p11);
        Pris pr18 = s2.createPris(775, p12);

        Salg sa1 = controller.createSalg(s1);
        sa1.createOrdrelinje(3, p4);
        sa1.createOrdrelinje(2, p5);
        sa1.createOrdrelinje(4, p1);

        Salg sa2 = createSalg(s1);
        Salg sa3 = createSalg(s1);
        Salg sa4 = createSalg(s1);

        Betaling b1 = createBetaling(Betalingsformer.DANKORT);
        Betaling b2 = createBetaling(Betalingsformer.KLIPPEKORTBETALING);
        Betaling b3 = createBetaling(Betalingsformer.KONTANT);
        Betaling b4 = createBetaling(Betalingsformer.MOBILEPAY);
    }
}

