package application.model;

public class RabatBeloeb extends Rabat {
    private double beloeb;

    public RabatBeloeb(double beloeb) {
        this.beloeb = beloeb;
    }

    public double getRabat(double pris) {
      pris = beloeb;
        return pris;
    }

    public double getBeloeb() {
        return beloeb;
    }

    public void setBeloeb(double beloeb) {
        this.beloeb = beloeb;
    }







}
