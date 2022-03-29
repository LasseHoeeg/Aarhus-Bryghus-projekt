package application.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class KlippekortNy extends Produkt{
    private static int nr = 0;
    private int antalKlip;

    public KlippekortNy(String navn, String beskrivelse, int antalKlip, ProduktGruppe produktGruppe) {
        super(navn, beskrivelse, produktGruppe);
        this.nr = nr++;
        this.antalKlip = antalKlip;
    }


}
