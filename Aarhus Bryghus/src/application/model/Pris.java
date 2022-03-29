package application.model;

public class Pris {
    private double beloeb;
    private int antalKlip;
    private Produkt produkt;
    private Salgssituation salgssituation;

    Pris(double beloeb, int antalKlip, Produkt produkt, Salgssituation salgssituation) {
        this.beloeb = beloeb;
        this.antalKlip = antalKlip;
        this.produkt = produkt;
        this.salgssituation = salgssituation;
    }

    public Pris(double beloeb, Produkt produkt){
        this.beloeb = beloeb;
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

    public Salgssituation getSalgssituation() {
        return salgssituation;
    }

    public void setSalgssituation(Salgssituation salgssituation) {
        this.salgssituation = salgssituation;
    }

    public Produkt getProdukt() {
        return produkt;
    }

    public void setProdukt(Produkt produkt) {
        this.produkt = produkt;
    }

}
