package com.model.singletons.regions;

public class Turkiye {
    private static volatile Turkiye INSTANCE;
    private volatile Integer pointsTurkiye;

    public Turkiye() {
        this.pointsTurkiye = 0;
    }

    public Integer getPointsTurkiye() {
        return pointsTurkiye;
    }

    public synchronized void addOnePoint() {
        this.pointsTurkiye += 1;
    }

    public static Turkiye getInstance() {
        if (INSTANCE == null) {
            synchronized (Turkiye.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Turkiye();
                }
            }
        }
        return INSTANCE;
    }
}
