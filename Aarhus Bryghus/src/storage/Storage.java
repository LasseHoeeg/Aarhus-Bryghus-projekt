package storage;

public class Storage {
    private static Storage uniqueInstance;

    public static Storage getInstance() {
        if (uniqueInstance == null) {uniqueInstance = new Storage();
        }
        return uniqueInstance;
    }
}
