package application.model;

enum Betalingsformer {DANKORT, KLIPPEKORTBETALING, KONTANT, MOBILEPAY{
    @Override
    public String toString() {
        return super.toString();
    }
}
}


