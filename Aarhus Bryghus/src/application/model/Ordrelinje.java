package application.model;

public class Ordrelinje {
    private int nr;
    private int antal;
    private Produkt produkt;
    private Rabat rabat;

Ordrelinje(int nr, int antal, Produkt produkt){  //når rabat tilføj: , Rabat rabat){
    this.nr = nr;
    this.antal = antal;
    this.produkt = produkt;
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

}
