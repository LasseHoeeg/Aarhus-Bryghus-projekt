package application.model;

public class Ordrelinje {
    private int nr;
    private int antal;
    private Produkt produkt;
    private Rabat rabat;

Ordrelinje(int nr, int antal, Produkt produkt){
    this.nr=nr;
    this.antal=antal;
}

}
