package application.model;

public class RabatProcent extends Rabat {
    private double procent;

    public RabatProcent(double procent) {
        this.procent = procent;
    }

    public double getRabat(double pris) {
        return pris * procent / 100;
    }

    public double getProcent() {
        return procent;
    }

    public void setProcent(double procent) {
        this.procent = procent;
    }
}
