package application.model;

public class Regning extends Betalingsform {
    private static Regning uniqueInstance;

    public Regning(String navn){
        super(navn);
    }

    public static Regning getInstance(String navn) {
        if (uniqueInstance == null) {
            uniqueInstance = new Regning(navn);
        }
        return uniqueInstance;
    }
}
