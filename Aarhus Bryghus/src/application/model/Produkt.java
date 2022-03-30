package application.model;

import java.util.ArrayList;

public class Produkt {
    private String navn;
    private String beskrivelse;
    private ProduktGruppe produktGruppe;
    private ArrayList<Pris> priser = new ArrayList<>();


    Produkt(String navn, String beskrivelse, ProduktGruppe produktGruppe) {
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
        return new ArrayList<Pris>(priser);
    }

    public void addPris(Pris pris) {
        boolean found = false;
        if (!priser.contains(pris)) {
            for (Pris p : priser) {
                if (pris.getSalgssituation() == p.getSalgssituation()) {
                    found = true;
                }
            }
            if (found) {
                priser.add(pris);
                pris.setProdukt(this);
            }
            //Todo Runtime exception
        }
    }

    public void removePris(Pris pris) {
        if (priser.contains(pris))
        priser.remove(pris);
        pris.getSalgssituation().removePris(pris);
    }
}
