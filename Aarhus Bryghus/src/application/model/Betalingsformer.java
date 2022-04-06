package application.model;

public enum Betalingsformer {DANKORT("Dankort"), KLIPPEKORTBETALING("Klippekort"), KONTANT("Kontant"), MOBILEPAY("Mobilpay");
    private String navn;
    Betalingsformer(String navn) {
        this.navn = navn;
    }
    @Override
    public String toString() {
        return navn;
    }
}



