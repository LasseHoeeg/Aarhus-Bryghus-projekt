package application.controller;

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
    }
