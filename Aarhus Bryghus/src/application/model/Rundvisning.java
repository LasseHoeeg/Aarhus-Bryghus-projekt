package application.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Rundvisning extends Produkt {
    private LocalDateTime datoTidspunkt;
    private boolean paabegyndt;
    private boolean betalt;

    Rundvisning(String navn, String beskrivelse, ProduktGruppe produktGruppe, LocalDateTime datoTidspunkt){
       super(navn, beskrivelse, produktGruppe);
       this.datoTidspunkt=datoTidspunkt;
       this.betalt=false;
    }

    public LocalDateTime getDatoTidspunkt() {
        return datoTidspunkt;
    }

    public void setDatoTidspunkt(LocalDateTime datoTidspunkt) {
        this.datoTidspunkt = datoTidspunkt;
    }

    public boolean isPaabegyndt() {
        return paabegyndt;
    }

    public void setPaabegyndt(boolean paabegyndt) {
        this.paabegyndt = paabegyndt;
    }

    public boolean isBetalt() {
        return betalt;
    }

    public void setBetalt(boolean betalt) {
        this.betalt = betalt;
    }
}
