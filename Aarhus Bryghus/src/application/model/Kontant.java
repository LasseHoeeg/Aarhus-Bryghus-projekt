package application.model;

public class Kontant extends Betalingsform {
    private static Kontant uniqueInstance;

    public Kontant(String navn){
        super(navn);
    }

    public static Betalingsform getInstance(String navn) {
        if (uniqueInstance == null) {
            uniqueInstance = new Kontant(navn);
        }
        return uniqueInstance;
    }
}
