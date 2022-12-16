package com.model.singletons.regions;

public class Baltics {
    private static volatile Baltics INSTANCE;
    private volatile Integer points;

    public Baltics() {
        this.points = 0;
    }

    public Integer getPoints() {
        return this.points;
    }

    public synchronized void addOnePoint() {
        this.points += 1;
    }

    public static Baltics getInstance() {
        if (INSTANCE == null) {
            synchronized (Baltics.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Baltics();
                }
            }
        }
        return INSTANCE;
    }
}
