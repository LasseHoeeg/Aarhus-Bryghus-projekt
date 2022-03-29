package application.model;

public class ProduktGruppe {
    private String navn;

    public ProduktGruppe(String navn) {
        this.navn = navn;
    }

    public String getNavn() {
        return navn;
    }
    public void setNavn(String navn){
        this.navn = navn;
    }

}
