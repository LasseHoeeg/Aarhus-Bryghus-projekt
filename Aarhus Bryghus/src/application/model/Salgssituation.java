package application.model;

import java.util.ArrayList;

public class Salgssituation {
    private String navn;
    private String deltagerInfo;
    private ArrayList<Pris> priser = new ArrayList<>();

    public Salgssituation(String navn, String deltagerInfo) {
        this.navn = navn;
        this.deltagerInfo = deltagerInfo;
    }

    public ArrayList<Pris> getPriser(){
        return new ArrayList<>(priser);
    }
    public Pris createPris(double beloeb, Produkt produkt, Salgssituation salgssituation){
        Pris pris = new Pris(beloeb, produkt, salgssituation);
        priser.add(pris);
        return pris;
    }

    public Pris createPris(double beloeb, int antalKlip, Produkt produkt, Salgssituation salgssituation){
        Pris pris = new Pris(beloeb, antalKlip, produkt, salgssituation);
        priser.add(pris);
        return pris;
    }

    public void removePris(Pris pris) {
        if (priser.contains(pris)){
            priser.remove(pris);
        }
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getDeltagerInfo() {
        return deltagerInfo;
    }

    public void setDeltagerInfo(String deltagerInfo) {
        this.deltagerInfo = deltagerInfo;
    }
}
