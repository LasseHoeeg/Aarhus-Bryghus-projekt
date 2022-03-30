package application.model;

import java.sql.SQLOutput;
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
            for (Pris p : priser) {
                if (pris.getSalgssituation() == p.getSalgssituation()) {
                    throw new RuntimeException("Produktet har allerede en pris for den pågældende salgssituation");
                    }
                }
            priser.add(pris);
            pris.setProdukt(this);
    }

    public void removePris(Pris pris) {
        if (priser.contains(pris))
        priser.remove(pris);
        pris.getSalgssituation().removePris(pris);
    }

    @Override
    public String toString() { 
        return navn;
    }
}
