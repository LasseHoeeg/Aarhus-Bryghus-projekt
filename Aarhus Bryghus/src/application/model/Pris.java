package application.model;

public class Pris {
    private double beloeb;
    private int antalKlip;

    public Pris(double beloeb, int antalKlip) {
        this.beloeb = beloeb;
        this.antalKlip = antalKlip;
    }

    public double getBeloeb() {
        return beloeb;
    }

    public void setBeloeb(double beloeb) {
        this.beloeb = beloeb;
    }

    public int getAntalKlip() {
        return antalKlip;
    }

    public void setAntalKlip(int antalKlip) {
        this.antalKlip = antalKlip;
    }
}
