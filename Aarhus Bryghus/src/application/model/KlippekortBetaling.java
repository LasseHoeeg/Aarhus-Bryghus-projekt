package application.model;

import java.time.LocalDate;

public class KlippekortBetaling {

    private int samletAntalKlip = 0;
    private int samletAntalKlipForPeriode;
    private static KlippekortBetaling uniqueInstance;

    public KlippekortBetaling() {
        super();
    }

        public static KlippekortBetaling getInstance() {
            if (uniqueInstance == null) {uniqueInstance = new KlippekortBetaling();
            }
            return uniqueInstance;
    }

    public int klip(int antalKlip) {
     setSamletAntalKlip(antalKlip);
     return antalKlip;
    }

    private void setSamletAntalKlip(int antalKlip){
        samletAntalKlip = samletAntalKlip+antalKlip;
    }

    public int getSamletAntalKlip() {
        return samletAntalKlip;
    }

    public int getSamletAntalKlipForPeriode(LocalDate start, LocalDate slut) {

        return samletAntalKlipForPeriode;
    }
}





