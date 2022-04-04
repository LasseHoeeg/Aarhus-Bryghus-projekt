package application.model;

import java.time.LocalDate;

public class Beloeb {
    private double tilBetaling;
    private LocalDate startDato;
    private LocalDate slutDato;
    private int kundeid;
    private int firmaid;
    private Salg salg;
    private Betalingsform betalingsform;

    Beloeb(double tilBetaling, Betalingsform betalingsform, Salg salg){
        this.tilBetaling = tilBetaling;
    }

    Beloeb(double tilBetaling, LocalDate startDato, LocalDate slutDato, int kundeid, Betalingsform betalingsform, Salg salg){
      this.tilBetaling=tilBetaling;
      this.startDato=startDato;
      this.slutDato=slutDato;
      this.kundeid=kundeid;
    }

    public Betalingsform getBetalingsform() {
        return betalingsform;
    }

    public void setBetalingsform(Betalingsform betalingsform){
        if (this.betalingsform != betalingsform){
            Betalingsform oldBetalingsform = this.betalingsform;
            if (oldBetalingsform != null){
                oldBetalingsform.removeBeloeb(this);
            }
            this.betalingsform = betalingsform;
            if (betalingsform != null){
                betalingsform.addBeloeb(this);
            }
        }
    }

    public double getTilBetaling() {
        return tilBetaling;
    }

    public void setTilBetaling(double tilBetaling) {
        this.tilBetaling = tilBetaling;
    }

    public LocalDate getStartDato() {
        return startDato;
    }

    public void setStartDato(LocalDate startDato) {
        this.startDato = startDato;
    }

    public LocalDate getSlutDato() {
        return slutDato;
    }

    public void setSlutDato(LocalDate slutDato) {
        this.slutDato = slutDato;
    }

    public int getKundeid() {
        return kundeid;
    }

    public void setKundeid(int kundeid) {
        this.kundeid = kundeid;
    }

    public Salg getSalg() {
        return salg;
    }


}
