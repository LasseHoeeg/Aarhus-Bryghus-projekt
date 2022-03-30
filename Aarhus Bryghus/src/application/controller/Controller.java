package application.controller;

import application.model.ProduktGruppe;
import application.model.Salgssituation;
import storage.Storage;

public class Controller {
    private static Controller uniqueInstance;
    private Storage storage;

    public static Controller getInstance(){
        if (uniqueInstance==null){uniqueInstance = new Controller();}
        return uniqueInstance;
    }

    private Controller()
    {storage=Storage.getInstance();}

    public ProduktGruppe createProduktGruppe(String navn){
        ProduktGruppe pg = new ProduktGruppe(navn);
        //ikke færdig
        return null;
    }

    public Salgssituation createSalgssituation(String navn, String deltagerinfo){
        Salgssituation ss = new Salgssituation(navn, deltagerinfo);
        //ikke færdig
        return null;

    }

    }
