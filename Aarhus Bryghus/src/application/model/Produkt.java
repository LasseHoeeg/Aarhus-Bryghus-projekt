package application.model;

import java.util.ArrayList;

public class Produkt {
    private String navn;
    private String beskrivelse;
    private ProduktGruppe produktGruppe;
    private ArrayList<Pris> priser = new ArrayList<>();


    public Produkt(String navn, String beskrivelse, ProduktGruppe produktGruppe) {
        this.navn = navn;
        this.beskrivelse = beskrivelse;
        this.produktGruppe = produktGruppe;
    }

    public ProduktGruppe getProduktGruppe() {
        return produktGruppe;
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

    public ArrayList<Pris> getPriser() {
        return priser;
    }

    public void addPris(Pris pris) {
        if (!priser.contains(pris))
            for (Pris p : priser){
                if (priser) //slagssit
            }
        priser.add(pris);
    }

    public void removePris(Pris pris) {
        if (priser.contains(pris))
        priser.remove(pris);
    }
}
