package application.model;

import java.util.ArrayList;

public class Betalingsform {    //fixme abstract ?
    private String navn;
    private final ArrayList<Ordrelinje> ordrelinjer = new ArrayList<>();
    private final ArrayList<Beloeb> alleBeloeb = new ArrayList<>();
    private static Betalingsform uniqueInstance;


    public Betalingsform(String navn){
        this.navn=navn;
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
            ordrelinje.setBetalingsform(this);
        }
    }
    //(betalingsform) 0..1-0..* (ordrelinje)
    public void removeOrdrelinje(Ordrelinje ordrelinje){
        if (ordrelinjer.contains(ordrelinje)){
            ordrelinjer.remove(ordrelinje);
            ordrelinje.setBetalingsform(null);
        }
    }

    public ArrayList<Beloeb> getAlleBeloeb(){
        return new ArrayList<>(alleBeloeb);
    }

    public void addBeloeb(Beloeb beloeb){
        if (!alleBeloeb.contains(beloeb)){
            alleBeloeb.add(beloeb);
            beloeb.setBetalingsform(this);
        }
    }

    public void removeBeloeb(Beloeb beloeb){
        if (alleBeloeb.contains(beloeb)){
            alleBeloeb.remove(beloeb);
            beloeb.setBetalingsform(null);
        }
    }

    @Override
    public String toString() {
        return navn;
    }
}
