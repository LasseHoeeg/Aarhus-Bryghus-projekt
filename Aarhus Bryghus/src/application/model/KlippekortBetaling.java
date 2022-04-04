package application.model;

public class KlippekortBetaling extends Betalingsform {
    private int antalKlipBrugtPeriode;
    private static KlippekortBetaling uniqueInstance;

    public KlippekortBetaling(String navn){
        super(navn);
    }

    public static KlippekortBetaling getInstance(String navn) {
        if (uniqueInstance == null) {
            uniqueInstance = new KlippekortBetaling(navn);
        }
        return uniqueInstance;
    }

    public int antalKlipForPeriode(){
        int sum;
        //for ()
        return 0;
    }

}
