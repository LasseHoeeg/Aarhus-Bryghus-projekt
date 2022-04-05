package application.model;

import java.io.Serializable;
import java.sql.SQLOutput;
import java.util.ArrayList;

public class Produkt implements Serializable {
    private String navn;
    private String beskrivelse;
    private ProduktGruppe produktGruppe;
    private Pant pant;
    private ArrayList<Pris> priser = new ArrayList<>();


     /**
      *  Da constructoren ikke er public oprettes produkt-objekter kun igennem ProduktGruppe-klassen
      *  Pre: En ProduktGruppe skal være oprettet før man kan oprette produkter
      */
    Produkt(String navn, String beskrivelse, ProduktGruppe produktGruppe) {
        this.navn = navn;
        this.beskrivelse = beskrivelse;
        this.produktGruppe = produktGruppe;
    }

    public Pant getPant() {
        return pant;
    }

    public void setPant(Pant pant) {
        if (this.pant!=pant){
            this.pant = pant;
        }
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


    /** Tilføjer pris til en salgssituations arraylist af priser
     * Note: Et produkt kan for en salgssituation kun have én pris.
     * Ellers kastes exception og objektet oprettes ikke.
     */
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
