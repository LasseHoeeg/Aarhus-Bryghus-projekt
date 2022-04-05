package storage;

import application.model.Salg;
import application.model.Salgssituation;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class PersistStorage {

    public static void main(String[] args) {
        Storage storage = Storage.getInstance();
        //storage.add...
        try {
            FileOutputStream f_out = new FileOutputStream("storage.ser");
            ObjectOutputStream obj_out = new ObjectOutputStream(f_out);
            //salg
            for (int i = 0; i < storage.getSalgsliste().size(); i++) {
                obj_out.writeObject(storage.getSalgsliste().get(i));
                System.out.println("Salget er gemt: " + storage.getSalgsliste().get(i));
            }
            //salgssituation
            for (int i = 0; i < storage.getSalgssituationer().size(); i++) {
                obj_out.writeObject(storage.getSalgssituationer().get(i));
                System.out.println("Salssituationen er gemt: " + storage.getSalgssituationer().get(i));
            }
            //produktgruppe
            for (int i = 0; i < storage.getProduktGrupper().size(); i++) {
                obj_out.writeObject(storage.getProduktGrupper().get(i));
                System.out.println("Produktgruppen er gemt: " + storage.getProduktGrupper().get(i));
            }
            //betaling
            for (int i = 0; i < storage.getAlleBetalinger().size(); i++) {
                obj_out.writeObject(storage.getAlleBetalinger().get(i));
                System.out.println("Betalingen er gemt: " + storage.getAlleBetalinger().get(i));
            }
            //pant
            for (int i = 0; i < storage.getAltPant().size(); i++) {
                obj_out.writeObject(storage.getAltPant().get(i));
                System.out.println("Panten er gemt: " + storage.getAltPant().get(i));

                obj_out.close();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
