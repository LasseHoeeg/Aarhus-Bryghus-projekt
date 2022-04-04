package application.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Salg {
    private LocalDateTime tidspunktBetaling;
    private double samletBeloeb;
    private int samletAntalKlip;
    private static int salgsID = 0;
    private ArrayList<Ordrelinje> ordrelinjer = new ArrayList<>();
    private Rabat rabat;
    private Salgssituation salgssituation;
    private final ArrayList<Beloeb> alleBeloeb = new ArrayList<>();
    private static int ordrelinjeAntal;

    /**
     * Opretter et salgs-objekt som pr. default er dato for salgsoprettelsen og har seneste salgsnr +1
     * og ordrelinejAntal = 0 så første oprettelse af en ordrelinje starter fra 1.
     */
    public Salg(Salgssituation salgssituation) {
        tidspunktBetaling = LocalDateTime.now();
        salgsID++;
        this.salgssituation = salgssituation;
        ordrelinjeAntal = 0;
    }

    /**
     * Beregner samlet pris for hele salget i hhv. samletBeloeb og samletAntalKlip.
     * Tager forbehold for evt. rabat.
     */
    public void beregnSamletBeloebOgKlip() {
      if (ordrelinjer.size() == 0){
          throw new IllegalArgumentException("Salget skal minimum have en ordrelinje");
      }
        double sumBeloeb = 0.0;
        int sumKlip = 0;

        for (Ordrelinje o : ordrelinjer) {
            sumBeloeb += o.getOrdrelinjePris();
            sumKlip += o.getOrdrelinjeKlip();
        }
        if (rabat != null) {
            sumBeloeb = sumBeloeb - rabat.getRabat(sumBeloeb);
        }
        samletBeloeb = sumBeloeb;
        samletAntalKlip = sumKlip;
    }
    /**
     * Opretter en ordrelinje og tilføjer det til salgets arraylist af ordrelinjer.
     * Beregner den opdaterede samlede pris for salget.
     */
    public Ordrelinje createOrdrelinje(int antal, Produkt produkt) {
        if (antal <= 0){
            throw new IllegalArgumentException("Antal skal være større end 0");
        }
        int contains = this.containsProduct(produkt);
        Ordrelinje ordrelinje = null;
        if (contains != -1){
            this.getOrdrelinjer().get(contains).setAntal(this.getOrdrelinjer().get(contains).getAntal()+antal);
        }
        else{
            ordrelinjeAntal++;
            ordrelinje = new Ordrelinje(ordrelinjeAntal, antal, produkt, this);
            ordrelinjer.add(ordrelinje);
            beregnSamletBeloebOgKlip();
        }
        return ordrelinje;
    }

    public int containsProduct(Produkt produkt) {
        int i = 0;
        int foundIndex = -1;
        while (i < this.getOrdrelinjer().size() && foundIndex == -1) {
            if (this.getOrdrelinjer().get(i).getProdukt() == produkt) {
                foundIndex = i;
            } else {
                i++;
            }
        }
        return foundIndex;
    }

    public void removeOrdrelinje(Ordrelinje ordrelinje) {
        if (ordrelinjer.contains(ordrelinje)) {
            ordrelinjer.remove(ordrelinje);
            beregnSamletBeloebOgKlip();
        }
    }

    /**
     * Opretter rabatProcent og opdaterer ordrelinjePris
     * Rabatten sættes til ordrelinjen
     */
    public Rabat createRabatPct(double procent) {
        if (procent <= 0){
            throw new IllegalArgumentException("procent skal være større end 0");
        }
        Rabat rabatPct = new RabatProcent(procent);
        this.rabat = rabatPct;
        beregnSamletBeloebOgKlip();
        return rabatPct;
    }

    /**
     * Opretter rabatBeloeb og opdaterer ordrelinjePris
     * Rabatten sættes til ordrelinjen
     */
    public Rabat createRabatBeloeb(double beloeb){
        if (beloeb <= 0){
            throw new IllegalArgumentException("beløb skal være større end 0");
        }
        Rabat rabatBeloeb = new RabatBeloeb(beloeb);
        this.rabat = rabatBeloeb;
        beregnSamletBeloebOgKlip();
        return rabatBeloeb;
    }

    public LocalDateTime getTidspunktBetaling() {
        return tidspunktBetaling;
    }

    public void setTidspunktBetaling(LocalDateTime tidspunktBetaling) {
        this.tidspunktBetaling = tidspunktBetaling;
    }

    public double getSamletBeloeb() {
        return samletBeloeb;
    }

    public void setSamletBeloeb(double samletBeloeb) {
        this.samletBeloeb = samletBeloeb;
    }

    public int getSamletAntalKlip() {
        return samletAntalKlip;
    }

    public void setSamletAntalKlip(int samletAntalKlip) {
        this.samletAntalKlip = samletAntalKlip;
    }

    public int getSalgsID() {
        return salgsID;
    }

    public ArrayList<Ordrelinje> getOrdrelinjer() {
        return new ArrayList<>(ordrelinjer);
    }

    public Rabat getRabat() {
        return rabat;
    }

    public Salgssituation getSalgssituation() {
        return salgssituation;
    }

    public ArrayList<Beloeb> getAlleBeloeb() {
        return new ArrayList<>(alleBeloeb);
    }

    public Beloeb createBeloeb(double tilBetaling, Betalingsform betalingsform){
        Beloeb b = new Beloeb(tilBetaling, betalingsform, this);
        alleBeloeb.add(b);
        return b;
    }

    public Beloeb createBeloeb(double tilBetaling, LocalDate startDato, LocalDate slutDato, int kundeid, Betalingsform betalingsform){
        Beloeb b = new Beloeb(tilBetaling, startDato, slutDato, kundeid, betalingsform, this);
        alleBeloeb.add(b);
        return b;
    }

    public static int getOrdrelinjeAntal() {
        return ordrelinjeAntal;
    }

    @Override
    public String toString() {
        return tidspunktBetaling +
                ", " + samletBeloeb +
                "0, " + salgsID;
    }
 }
