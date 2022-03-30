package application.model;

import java.util.ArrayList;

public class Salgssituation {
    private String navn;
    private String beskrivelse;
    private ArrayList<Pris> priser = new ArrayList<>();

    public Salgssituation(String navn, String beskrivelse) {
        this.navn = navn;
        this.beskrivelse = beskrivelse;
    }

    public ArrayList<Pris> getPriser(){
        return new ArrayList<>(priser);
    }
    public Pris createPris(double beloeb, Produkt produkt){
        Pris pris = new Pris(beloeb, produkt, this);
        priser.add(pris);
        produkt.addPris(pris);
        return pris;
    }

    public Pris createPris(double beloeb, int antalKlip, Produkt produkt){
        Pris pris = new Pris(beloeb, antalKlip, produkt, this);
        priser.add(pris);
        produkt.addPris(pris);
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

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }

    @Override
    public String toString() {
        return navn;
    }
}
