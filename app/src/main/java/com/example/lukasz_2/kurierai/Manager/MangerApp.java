package com.example.lukasz_2.kurierai.Manager;

public class MangerApp {
    private int Fragment_position;
    private ManagerData mnagerData;
    private static MangerApp ourInstance = null;

    public static MangerApp getInstance() {
        if(ourInstance==null){
            ourInstance = new MangerApp();
        }
        return ourInstance;
    }

    private MangerApp() {
    }

    public int getFragment_position() {
        return Fragment_position;
    }

    public void setFragment_position(int fragment_position) {
        Fragment_position = fragment_position;
    }

    public ManagerData getMnagerData() {
        return mnagerData;
    }

    public void setMnagerData(ManagerData managerData) {
        this.mnagerData = managerData;
    }
}
