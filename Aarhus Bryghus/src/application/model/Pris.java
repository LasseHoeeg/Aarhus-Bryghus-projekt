package application.model;

public class Pris {
    private double beloeb;
    private int antalKlip;
    private Produkt produkt;
    private Salgssituation salgssituation;

    /**
     * Constructor med beløb og antalKlip
     * Da constructoren ikke er public oprettes pris-objekter kun igennem Salgssituation-klassen
     * Pre: En Salgssituation skal være oprettet før man kan oprette ordrelinjer
     * Note: Hvis beloeb og/eller antalKlip <= 0 oprettes objektet ikke
     */
    Pris(double beloeb, int antalKlip, Produkt produkt, Salgssituation salgssituation) {
        if (beloeb <= 0)
        {
            throw new IllegalArgumentException("Pris skal være større end 0");
        }
        this.beloeb = beloeb;
        if (antalKlip <= 0)
        {
            throw new IllegalArgumentException("AntalKlip skal være større end 0");
        }
        this.antalKlip = antalKlip;
        this.produkt = produkt;
        this.salgssituation = salgssituation;
    }

    /**
     * Constructor med beløb uden antalKlip
     * Da constructoren ikke er public oprettes pris-objekter kun igennem Salgssituation-klassen
     * Pre: En Salgssituation skal være oprettet før man kan oprette ordrelinjer
     * Note: Hvis beloeb <= 0 oprettes objektet ikke
     */
    Pris(double beloeb, Produkt produkt, Salgssituation salgssituation){
        if (beloeb <= 0)
        {
            throw new IllegalArgumentException("Pris skal være større end 0");
        }
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

    @Override
    public String toString() {
        return  produkt + ", " + beloeb;
        //return  produkt + ", " + beloeb + ", " + antalKlip;       //til når klippekort oprettes
    }
}
