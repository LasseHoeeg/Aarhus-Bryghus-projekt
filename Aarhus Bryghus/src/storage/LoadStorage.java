package storage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LoadStorage {

    public static void main(String[] args) {

        try {
            FileInputStream f_in = new FileInputStream("storage.ser");
            ObjectInputStream obj_in = new ObjectInputStream(f_in);
            Object obj = obj_in.readObject();
            if (obj instanceof Storage) {
                Storage s = (Storage) obj;
                System.out.println(s);
            }
            obj_in.close();
            f_in.close();
        }
        catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
