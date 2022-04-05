package storage;

import application.model.Salgssituation;

import java.io.*;

public class LoadAndPersistStorage {
    public static void main(String[] args) {
        //getinstance?      Storage storage = null;

        try (FileInputStream f_in = new FileInputStream("storage.ser")) {
            try (ObjectInputStream obj_in = new ObjectInputStream(f_in)) {
                Object obj = obj_in.readObject();
                if (obj instanceof  Storage) {
                    storage = (Storage) obj;
                    System.out.println(storage);
                }
            }
        }
        catch (IOException e) {
            //todo
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            //todo
            e.printStackTrace();
    }
        // fixme ??
        storage.addSalgssituation(salgssituation);
        storage.addSalg(salg);
        storage.addProduktGruppe(produktGruppe);
        storage.addBetaling(betaling);
        storage.addPant(pant);


//        try (FileOutputStream f_out = new FileOutputStream("person.ser")) {
//            try (ObjectOutputStream obj_out = new ObjectOutputStream(f_out)) {
//                obj_out.writeObject(person);
//                System.out.println("Person er gemt: " + person);
//            }
//
//        }
//        catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//
//    }
}
