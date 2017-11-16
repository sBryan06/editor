package org.ulco;

public class ID {
    private int ID = 0;

    private static ID instance = new ID();

    private ID() {
        // prevent external instantiation of a singleton.
    }

    public static ID getInstance() {
        if (instance == null) {
            instance = new ID();
        }
        return instance;
    }

    public synchronized int generateNextId() {
        return ++ID;
    }

    public int getID() {
        return ID;
    }
}