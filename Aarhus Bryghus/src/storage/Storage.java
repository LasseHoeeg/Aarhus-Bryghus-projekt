package storage;

import application.model.ProduktGruppe;
import application.model.Salg;
import application.model.Salgssituation;

import java.util.ArrayList;

public class Storage {
    private static Storage uniqueInstance;
    private final ArrayList<Salgssituation> salgssituationer = new ArrayList<>();
    private final ArrayList<ProduktGruppe> produktGrupper = new ArrayList<>();
    private final ArrayList<Salg> salgsliste = new ArrayList<>();

    public static Storage getInstance() {
        if (uniqueInstance == null) {uniqueInstance = new Storage();
        }
        return uniqueInstance;
    }

    //------------------------------------------------------------------------------------------
    public void addSalgssituation(Salgssituation salgssituation) {
        salgssituationer.add(salgssituation);
    }
    public void removeSalgssituation(Salgssituation salgssituation){
        if (salgssituationer.contains(salgssituation)) {
            salgssituationer.remove(salgssituation);
        }
    }
    public ArrayList<Salgssituation> getSalgssituationer() {
        return new ArrayList<>(salgssituationer);
    }

    //-----------------------------------------------------------------------------------------
    public void addProduktGruppe(ProduktGruppe produktGruppe) {
        produktGrupper.add(produktGruppe);
    }
    public void removeProduktGruppe(ProduktGruppe produktGruppe){
        if (produktGrupper.contains(produktGruppe)) {
            produktGrupper.remove(produktGruppe);
        }
    }
    public ArrayList<ProduktGruppe> getProduktGrupper() {
        return new ArrayList<>(produktGrupper);
    }
    // ----------------------------------------------------------------------------------------
    public void addSalg(Salg salg) {
        salgsliste.add(salg);
    }
    public ArrayList<Salg> getSalgsliste() {
        return new ArrayList<>(salgsliste);
    }
    public void removeSalg(Salg salg) {
        if (salgsliste.contains(salg)) {
            salgsliste.remove(salg);
        }
    }
}
