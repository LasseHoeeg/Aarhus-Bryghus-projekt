package application.model;

public class Salgssituation {
    private String navn;
    private String deltagerInfo;

    public Salgssituation(String navn, String deltagerInfo) {
        this.navn = navn;
        this.deltagerInfo = deltagerInfo;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getDeltagerInfo() {
        return deltagerInfo;
    }

    public void setDeltagerInfo(String deltagerInfo) {
        this.deltagerInfo = deltagerInfo;
    }
}
