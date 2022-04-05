package application.model;

import java.util.ArrayList;

public class Betaling {
    private String navn;
    private final ArrayList<Ordrelinje> ordrelinjer = new ArrayList<>();
    private final ArrayList<Beloeb> alleBeloeb = new ArrayList<>();
    private Betalingsformer betalingsform;


    public Betaling(String navn, Betalingsformer betalingsform){
        this.navn = navn;
        this.betalingsform = betalingsform;
    }

    public String getNavn() {
        return navn;
    }

    public ArrayList<Ordrelinje> getOrdrelinjer() {
        return new ArrayList<>(ordrelinjer);
    }

    //(betalingsform) 0..1-0..* (ordrelinje)
    public void addOrdrelinje(Ordrelinje ordrelinje){
        if (!ordrelinjer.contains(ordrelinje)){
            ordrelinjer.add(ordrelinje);
            ordrelinje.setBetaling(this);
        }
    }
    //(betalingsform) 0..1-0..* (ordrelinje)
    public void removeOrdrelinje(Ordrelinje ordrelinje){
        if (ordrelinjer.contains(ordrelinje)){
            ordrelinjer.remove(ordrelinje);
            ordrelinje.setBetaling(null);
        }
    }

    public ArrayList<Beloeb> getAlleBeloeb(){
        return new ArrayList<>(alleBeloeb);
    }

    public void addBeloeb(Beloeb beloeb){
        if (!alleBeloeb.contains(beloeb)){
            alleBeloeb.add(beloeb);
            beloeb.setBetaling(this);
        }
    }

    public void removeBeloeb(Beloeb beloeb){
        if (alleBeloeb.contains(beloeb)){
            alleBeloeb.remove(beloeb);
            beloeb.setBetaling(null);
        }
    }

    @Override
    public String toString() {
        return navn;
    }
}
