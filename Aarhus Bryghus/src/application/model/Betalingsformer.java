package application.model;

import java.io.Serializable;

public enum Betalingsformer implements Serializable {DANKORT, KLIPPEKORTBETALING, KONTANT, MOBILEPAY{
    @Override
    public String toString() {
        return super.toString();
    }
}
}


