package application.model;

import java.io.Serializable;
import java.time.LocalDate;

public class Leje extends Salg implements Serializable {
    private boolean betalt;
    private double pantBeloebInbetalt;
    private LocalDate TidspunktUdlejeStart;

    public Leje(Salgssituation salgssituation, boolean betalt, double pantBeloebInbetalt, LocalDate tidspunktUdlejeStart) {
        super(salgssituation);
        this.betalt = betalt;
        this.pantBeloebInbetalt = pantBeloebInbetalt;
        TidspunktUdlejeStart = tidspunktUdlejeStart;
    }

    public boolean isBetalt() {
        return betalt;
    }

    public void setBetalt(boolean betalt) {
        this.betalt = betalt;
    }

    public double getPantBeloebInbetalt() {
        return pantBeloebInbetalt;
    }

    public void setPantBeloebInbetalt(double pantBeloebInbetalt) {
        this.pantBeloebInbetalt = pantBeloebInbetalt;
    }

    public LocalDate getTidspunktUdlejeStart() {
        return TidspunktUdlejeStart;
    }

    public void setTidspunktUdlejeStart(LocalDate tidspunktUdlejeStart) {
        TidspunktUdlejeStart = tidspunktUdlejeStart;
    }

    public int pantBeloebIndbetalt(){
        int samletPantbeloeb=0;
        for (Ordrelinje o : this.getOrdrelinjer()){
            if (o.getProdukt().getPant()!=null)
                samletPantbeloeb+=o.getProdukt().getPant().getBeloeb();
        }
        return samletPantbeloeb;
    }
}
