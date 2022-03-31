package application.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Salg {
    private LocalDateTime tidspunktBetaling;
    private double samletBeloeb;
    private int samletAntalKlip;
    private static int salgsID = 0;
    private ArrayList<Ordrelinje> ordrelinjer;
    private Rabat rabat;
    private Salgssituation salgssituation;
    //private ArrayList<Betaling> betalinger;
    private static int ordrelinjeAntal;

    public Salg(Salgssituation salgssituation){
       tidspunktBetaling = LocalDateTime.now();
       salgsID++;
       this.salgssituation = salgssituation;
       ordrelinjeAntal = 0;
    }

    public void beregnSamletBeloebOgKlip() {
        for (Ordrelinje o: ordrelinjer) {
            samletBeloeb += o.getOrdrelinjePris();
            samletAntalKlip += o.getOrdrelinjeKlip();
        }
        if (rabat != null){
            samletBeloeb = samletBeloeb - rabat.getRabat(samletBeloeb);
        }
    }

    public Ordrelinje createOrdrelinje(int antal, Produkt produkt){
        ordrelinjeAntal++;
        Ordrelinje ordrelinje = new Ordrelinje(ordrelinjeAntal, antal, produkt, this);
        return ordrelinje;
    }

    public Rabat createRabatPct(double procent){
        Rabat rabatPct = new RabatProcent(procent);
        this.rabat = rabatPct;
        return rabatPct;
    }

    public Rabat createRabatBeloeb(double beloeb){
        Rabat rabatBeloeb = new RabatBeloeb(beloeb);
        this.rabat = rabatBeloeb;
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

    public void setSamletAntalKlip(int samletAntalKlip){
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

//    public ArrayList<Betaling> getBetalinger() {
//        return betalinger;
//    }

    //add remove betaling?

    public static int getOrdrelinjeAntal() {
        return ordrelinjeAntal;
    }


    @Override
    public String toString() {
        return tidspunktBetaling +
                " "+ samletBeloeb +
                " "+ salgsID;
    }


}
