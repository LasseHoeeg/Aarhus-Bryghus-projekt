package application.controller;

import application.model.*;
import storage.Storage;

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
     * Opretter et nyt objekt / en ny produktgruppe og tilføjer det til Storage
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
     * Opretter et nyt objekt / en ny salgssituation og tilføjer det til Storage
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
     * Opretter et nyt objekt / et nyt salg og tilføjer det til Storage
     */
    public Salg createSalg(Salgssituation salgssituation){
        Salg salg = new Salg(salgssituation);
        Storage.getInstance().addSalg(salg);
        return salg;

    }
    public Leje createLeje(Salgssituation salgssituation){
        Leje leje = null;
        leje = new Leje(salgssituation,false,leje.pantBeloebIndbetalt(),LocalDate.now());
        Storage.getInstance().addSalg(leje);
        return leje;
    }

    public Leje tivngSalgTilLeje(Salg salg){
        Leje leje = new Leje(salg.getSalgssituation(),false,0,salg.getTidspunktBetaling().toLocalDate());
        leje.setPantBeloebInbetalt(leje.pantBeloebIndbetalt());
        for (Ordrelinje o : salg.getOrdrelinjer()) {
            leje.getOrdrelinjer().add(o);
        }
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

    //TODO metoede returner map/collection af leje salg

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


    // ------------------------------------------------------------------------------------------------------------



    public void initStorage() {
        Controller controller = Controller.getInstance();

        ProduktGruppe pg1 = controller.createProduktGruppe("Flaske");
        ProduktGruppe pg2 = controller.createProduktGruppe("Fadøl, 40 cl");
        ProduktGruppe pg3 = controller.createProduktGruppe("Spiritus");
        ProduktGruppe pg4 = controller.createProduktGruppe("Fustage");

        Produkt p1 = pg1.createProdukt("Klosterbryg", "Flaskeøl");
        Produkt p2 = pg1.createProdukt("Sweet Geogia Brown", "Flaskeøl");
        Produkt p3 = pg1.createProdukt("Extra Pilsner", "Flaskeøl");

        Produkt p4 = pg2.createProdukt("Jazz Classic", "Fadøl");
        Produkt p5 = pg2.createProdukt("Celebration", "Fadøl");
        Produkt p6 = pg2.createProdukt("Blondie", "Fadøl");

        Produkt p7 = pg3.createProdukt("Whisky", "45%");
        Produkt p8 = pg3.createProdukt("Liquor of Aarhus", "Spiritus");
        Produkt p9 = pg3.createProdukt("Lyng Gin", "50 cl");

        Produkt p10 = pg4.createProdukt("Forårsbryg", "20 liter");
        Produkt p11 = pg4.createProdukt("India Pale Ale", "20 liter");
        Produkt p12 = pg4.createProdukt("Julebryg", "20 liter");

        Salgssituation s1 = Controller.getInstance().createSalgssituation("Fredagsbar", "Flaskeøl og fadøl");
        Salgssituation s2 = Controller.getInstance().createSalgssituation("Butik", "Salg af alle produkter");

        Pris pr1 = s1.createPris(70, 2, p1);
        Pris pr2 = s1.createPris(70, 2, p2);
        Pris pr3 = s1.createPris(70, 2, p3);

        Pris pr4 = s2.createPris(36, p1);
        Pris pr5 = s2.createPris(36, p2);
        Pris pr6 = s2.createPris(36, p3);

        Pris pr7 = s1.createPris(38, 1, p4);
        Pris pr8 = s1.createPris(38, 1, p5);
        Pris pr9 = s1.createPris(38, 1, p6);

        Pris pr10 = s1.createPris(599, p7);
        Pris pr11 = s1.createPris(175, p8);
        Pris pr12 = s1.createPris(350, p9);

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

