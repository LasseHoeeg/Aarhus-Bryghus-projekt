package application.model;

public class Ordrelinje {
    private int nr;
    private int antal;
    private double ordrelinjePris;
    private Produkt produkt;
    private Rabat rabat;
    private Salg salg;


    Ordrelinje(int nr, int antal, Produkt produkt, Salg salg){  //når rabat tilføj: , Rabat rabat){
    this.nr = nr;
    this.antal = antal;
    this.produkt = produkt;
    this.salg = salg;
    beregnOrdrelinjePris();
}

    public Salg getSalg() {
        return salg;
    }


    public Rabat getRabat() {
        return rabat;
    }

//    public double getRabatPris() {
//    int sum=0;
//        if (rabat instanceof RabatProcent) {
//            rabat.getRabat()}
//    }

    public Rabat createRabatBeloeb(double beloeb) {
            Rabat rabat = new RabatBeloeb(beloeb);
            this.rabat = rabat;
            return getRabat();
        }

    public Rabat createRabatProcent(double procent) {
        Rabat rabat = new RabatProcent(procent);
        this.rabat = rabat;
        return getRabat();
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

    public void setOrdrelinjePris(double ordrelinjePris) {
        this.ordrelinjePris = ordrelinjePris;
    }

    public double getOrdrelinjePris() {
        return ordrelinjePris;
    }

    public void beregnOrdrelinjePris() {
        int i = 0;
        boolean found = false;
        while (i < salg.getSalgssituation().getPriser().size()&&found==false) {
            if (this.produkt == salg.getSalgssituation().getPriser().get(i).getProdukt()) {
                if (getRabat()!=null){
                    setOrdrelinjePris(getRabat().getRabat(getOrdrelinjePris())-(salg.getSalgssituation().getPriser().get(i).getBeloeb() * antal));
                }
                else {
                    setOrdrelinjePris(salg.getSalgssituation().getPriser().get(i).getBeloeb() * antal);
                }
                found = true;
            } else i++;
        }
    }

    @Override
    public String toString() {
        return produkt.getNavn() + ", " +
                +antal +
                ", " + getOrdrelinjePris() +
                "kr.";
    }
}



