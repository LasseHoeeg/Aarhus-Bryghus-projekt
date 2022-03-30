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
    //this.rabat = rabat;
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


    //Til når rabat kodes:

//    public Rabat getRabat() {
//        return rabat;
//    }


}
