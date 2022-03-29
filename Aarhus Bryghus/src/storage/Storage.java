package storage;

import application.model.ProduktGruppe;
import application.model.Salgssituation;

import java.util.ArrayList;

public class Storage {
    private static Storage uniqueInstance;
    private final ArrayList<Salgssituation> salgssituationer = new ArrayList<>();
    private final ArrayList<ProduktGruppe> produktGrupper = new ArrayList<>();

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
        salgssituationer.remove(salgssituation);
    }
    public ArrayList<Salgssituation> getSalgssituationer() {
        return new ArrayList<>(salgssituationer);
    }

    //-----------------------------------------------------------------------------------------
    public void addProduktGruppe(ProduktGruppe produktGruppe) {
        produktGrupper.add(produktGruppe);
    }
    public void removeProduktGruppe(ProduktGruppe produktGruppe){
        produktGrupper.remove(produktGruppe);
    }
    public ArrayList<ProduktGruppe> getProduktGrupper() {
        return new ArrayList<>(produktGrupper);
    }
}
