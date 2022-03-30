package application.controller;

import application.model.Produkt;
import application.model.ProduktGruppe;
import application.model.Salgssituation;
import storage.Storage;

import java.util.ArrayList;

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

    public Salgssituation createSalgssituation(String navn, String deltagerinfo){
        Salgssituation ss = new Salgssituation(navn, deltagerinfo);
        Storage.getInstance().addSalgssituation(ss);
        return ss;
    }

    public ArrayList<ProduktGruppe> getProduktgrupper(){
        return Storage.getInstance().getProduktGrupper();
    }

    public void removeSalgssituation(Salgssituation salgssituation) {
        Storage.getInstance().removeSalgssituation(salgssituation);
    }

    public ArrayList<Salgssituation> getSalgssituationer(){
        return Storage.getInstance().getSalgssituationer();
    }

    public void removeProduktgruppe(ProduktGruppe produktGruppe){
            Storage.getInstance().removeProduktGruppe(produktGruppe);
        }
    }

