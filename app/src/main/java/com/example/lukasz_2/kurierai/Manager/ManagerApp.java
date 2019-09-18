package com.example.lukasz_2.kurierai.Manager;

public class ManagerApp {
    private int Fragment_position;
    private ManagerData mnagerData;
    private static ManagerApp ourInstance = null;

    public static ManagerApp getInstance() {
        if(ourInstance==null){
            ourInstance = new ManagerApp();
        }
        return ourInstance;
    }

    private ManagerApp() {
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
