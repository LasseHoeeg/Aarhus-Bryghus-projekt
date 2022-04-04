package application.model;

import java.util.ArrayList;

public class Betaling {
    private String betalingsform;
    private String betaler;
    private double beloeb;
    private final ArrayList<Salg> alleSalg = new ArrayList<>();

    public Betaling(String betalingsform, String betaler, double beloeb){
        this.betalingsform=betalingsform;
        this.betaler=betaler;
        this.beloeb=beloeb;
    }

    public String getBetalingsform() {
        return betalingsform;
    }

    public void setBetalingsform(String betalingsform) {
        this.betalingsform = betalingsform;
    }

    public String getBetaler() {
        return betaler;
    }

    public void setBetaler(String betaler) {
        this.betaler = betaler;
    }

    public double getBeloeb() {
        return beloeb;
    }

    public ArrayList<Salg> getAlleSalg(){
        return new ArrayList<Salg>(alleSalg);
    }

    public void addSalg(Salg salg){
        if (!alleSalg.contains(salg)){
            alleSalg.add(salg);
            salg.addBetaling(this);
        }
    }

    public void removeSalg(Salg salg){
        if (alleSalg.contains(salg)){
            alleSalg.remove(salg);
            salg.removeBetaling(this);
        }
    }
}
