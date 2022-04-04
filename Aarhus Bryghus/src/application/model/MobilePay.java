package application.model;

public class MobilePay extends Betalingsform {
    private static MobilePay uniqueInstance;

    public MobilePay(String navn){
        super(navn);
    }

    public static MobilePay getInstance(String navn) {
        if (uniqueInstance == null) {
            uniqueInstance = new MobilePay(navn);
        }
        return uniqueInstance;
    }
}
