package application.controller;

import application.model.Produkt;
import application.model.ProduktGruppe;
import application.model.Salgssituation;
import storage.Storage;

import java.util.ArrayList;
import java.util.TreeSet;

public class Controller {
    private static Controller uniqueInstance;
    private Storage storage;

    public static Controller getInstance(){
        if (uniqueInstance==null){uniqueInstance = new Controller();}
        return uniqueInstance;
    }

    private Controller(){
        storage=Storage.getInstance();
    }

    public ProduktGruppe createProduktGruppe(String navn){
        ProduktGruppe pg = new ProduktGruppe(navn);
        Storage.getInstance().addProduktGruppe(pg);
        return pg;
    }

    public Salgssituation createSalgssituation(String navn, String beskrivelse){
        Salgssituation ss = new Salgssituation(navn, beskrivelse);
        Storage.getInstance().addSalgssituation(ss);
        return ss;
    }

    public ArrayList<ProduktGruppe> getProduktGrupper(){
        return Storage.getInstance().getProduktGrupper();
    }

    public void updateProduktGruppe(ProduktGruppe produktGruppe, String navn){
        produktGruppe.setNavn(navn);
    }

    public void removeProduktGruppe(ProduktGruppe produktGruppe){
        Storage.getInstance().removeProduktGruppe(produktGruppe);
    }



    public ArrayList<Salgssituation> getSalgssituationer(){
        return Storage.getInstance().getSalgssituationer();
    }

    public void updateSalgssituation(Salgssituation salgssituation, String navn, String beskrivelse){
        salgssituation.setNavn(navn);
        salgssituation.setBeskrivelse(beskrivelse);
    }

    public void removeSalgssituation(Salgssituation salgssituation) {
        Storage.getInstance().removeSalgssituation(salgssituation);
    }

}

