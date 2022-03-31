package application.model;

import application.controller.Controller;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Salg {
    private LocalDateTime tidspunktBetaling;
    private double samletPris;
    private static int salgsID = 0;
    private ArrayList<Ordrelinje> ordrelinjer;
    private Rabat rabat;
    private Salgssituation salgssituation;
    private ArrayList<Betaling> betalinger;
    private static int ordrelinjeAntal;

    public Salg(Salgssituation salgssituation){
       tidspunktBetaling = LocalDateTime.now();
       salgsID++;
       this.salgssituation = salgssituation;
       ordrelinjeAntal = 0;

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
        return rabatBeloeb;
    }

    public LocalDateTime getTidspunktBetaling() {
        return tidspunktBetaling;
    }

    public void setTidspunktBetaling(LocalDateTime tidspunktBetaling) {
        this.tidspunktBetaling = tidspunktBetaling;
    }

    public double getSamletPris() {
        return samletPris;
    }

    public void setSamletPris(double samletPris) {
        this.samletPris = samletPris;
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

    public ArrayList<Betaling> getBetalinger() {
        return betalinger;
    }

    //add remove betaling?

    public static int getOrdrelinjeAntal() {
        return ordrelinjeAntal;
    }


    @Override
    public String toString() {
        return tidspunktBetaling +
                " "+ samletPris +
                " "+ salgsID;
    }


}
