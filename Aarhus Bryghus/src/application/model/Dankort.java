package application.model;

public class Dankort extends Betalingsform {
    private static Dankort uniqueInstance;

    public Dankort(String navn){
        super(navn);
    }

    public static Dankort getInstance(String navn) {
        if (uniqueInstance == null) {
            uniqueInstance = new Dankort(navn);
        }
        return uniqueInstance;
    }
}
