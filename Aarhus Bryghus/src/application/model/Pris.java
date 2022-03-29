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

    Pris(double beloeb, Produkt produkt, Salgssituation salgssituation){
        this.beloeb = beloeb;
        this.produkt = produkt;
        this.salgssituation = salgssituation;
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
        if (this.produkt != produkt) {
            Produkt oldProdukt = this.produkt;
            if (oldProdukt != null) {
                oldProdukt.removePris(this);
            }
            this.produkt = produkt;
            if (produkt != null) {
                produkt.addPris(this);
            }
        }
    }


}
