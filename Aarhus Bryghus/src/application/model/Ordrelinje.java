package application.model;

public class Ordrelinje {
    private int nr;
    private int antal;
    private double ordrelinjePris;
    private int ordrelinjeKlip;
    private Produkt produkt;
    private Rabat rabat;
    private Salg salg;
    private Betalingsform betalingsform;

/**
 * Da constructoren ikke er public oprettes ordrelinje-objekter kun igennem Salg-klassen
 * Ved oprettetlse af ny ordrelinje beregnes den samlede pris i hhv. ordrelinjePris og ordrelinjeKlip
 * Pre: antal <= 0
 */
    Ordrelinje(int nr, int antal, Produkt produkt, Salg salg){
    this.nr = nr;
    this.antal = antal;
    this.produkt = produkt;
    this.salg = salg;
    beregnOrdrelinjePrisOgKlip();
}

    public Salg getSalg() {
        return salg;
    }


    public Rabat getRabat() {
        return rabat;
    }

     /**
     * Opretter rabatBeløb og opdaterer ordrelinjePris og ordrelinjeKlip
     * Rabatten sættes til ordrelinjen
     */
    public Rabat createRabatBeloeb(double beloeb) {
        if (beloeb <= 0){
            throw new IllegalArgumentException("beløb skal være større end 0");
        }
            Rabat rabat = new RabatBeloeb(beloeb);
            this.rabat = rabat;
            beregnOrdrelinjePrisOgKlip();
            return rabat;
        }

    /**
     * Opretter rabatProcent og opdaterer ordrelinjePris og ordrelinjeKlip
     * Rabatten sættes til ordrelinjen
     */
    public Rabat createRabatProcent(double procent) {
        if (procent <= 0){
            throw new IllegalArgumentException("procent skal være større end 0");
        }
        Rabat rabat = new RabatProcent(procent);
        this.rabat = rabat;
        beregnOrdrelinjePrisOgKlip();
        return rabat;
    }

    public int getNr() {
        return nr;
    }

    public void setNr(int nr) {
        this.nr = nr;
    }

    public int getAntal() {
        return antal;
    }

    public void setAntal(int antal) {
        this.antal = antal;
    }

    public Produkt getProdukt() {
        return produkt;
    }

    public void setOrdrelinjeKlip(int ordrelinjeKlip) {
        this.ordrelinjeKlip = ordrelinjeKlip;
    }

    public int getOrdrelinjeKlip() {
        return ordrelinjeKlip;
    }

    public void setOrdrelinjePris(double ordrelinjePris) {
        this.ordrelinjePris = ordrelinjePris;
    }

    public double getOrdrelinjePris() {
        return ordrelinjePris;
    }

    /**
     * Beregner den samlede pris pr. ordrelinje i et salg i hhv. beløb og klip
     */
    public void beregnOrdrelinjePrisOgKlip() {
        int i = 0;
        boolean found = false;
        while (i < salg.getSalgssituation().getPriser().size()&&!found) {
            if (this.produkt == salg.getSalgssituation().getPriser().get(i).getProdukt()) {
                if (getRabat()!=null){
                    setOrdrelinjePris((salg.getSalgssituation().getPriser().get(i).getBeloeb() * antal)
                            - getRabat().getRabat(getOrdrelinjePris()));
                }
                else {
                    setOrdrelinjePris(salg.getSalgssituation().getPriser().get(i).getBeloeb() * antal);
                }
                setOrdrelinjeKlip(salg.getSalgssituation().getPriser().get(i).getAntalKlip() * antal);
                found = true;
            } else i++;
        }
    }

    public Betalingsform getBetalingsform() {
        return betalingsform;
    }

    public void setBetalingsform(Betalingsform betalingsform) {
        if (this.betalingsform != betalingsform){
            Betalingsform oldBetalingsform = this.betalingsform;
            if (oldBetalingsform != null){
                oldBetalingsform.removeOrdrelinje(this);
            }
            this.betalingsform = betalingsform;
            if (betalingsform != null){
                betalingsform.addOrdrelinje(this);
            }
        }
    }

    @Override
    public String toString() {
        return produkt.getNavn() + ", " +
                +antal +
                ", " + getOrdrelinjePris() +
                "0 kr."+ "\t";
    }
}



