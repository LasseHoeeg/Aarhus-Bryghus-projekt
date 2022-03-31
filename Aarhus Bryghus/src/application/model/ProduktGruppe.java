package application.model;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class ProduktGruppe {
    private String navn;

    private final Set<Produkt> produkter = new TreeSet<>();

    public ProduktGruppe(String navn) {
        this.navn = navn;
    }

    public TreeSet<Produkt> getProdukter() {
        return new TreeSet<>(produkter);
    }

    public Produkt createProdukt(String navn, String beskrivelse) {
        Produkt produkt = new Produkt(navn, beskrivelse, this);
        produkter.add(produkt);
        return produkt;
    }

    public void removeProdukt(Produkt produkt) {
        if (produkter.contains(produkt)) {
            produkter.remove(produkt);
        }
    }



    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn){
        this.navn = navn;
    }

    @Override
    public String toString() {
        return navn;
    }
}
