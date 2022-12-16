package com.model.singletons.regions;

public class SouthEasternEurope {
    private static volatile SouthEasternEurope INSTANCE;
    private volatile Integer pointsSouthEasternEurope;

    public SouthEasternEurope() {
        this.pointsSouthEasternEurope = 0;
    }

    public Integer getPointsSouthEasternEurope() {
        return pointsSouthEasternEurope;
    }

    public synchronized void addOnePoint() {
        this.pointsSouthEasternEurope += 1;
    }

    public static SouthEasternEurope getInstance() {
        if (INSTANCE == null) {
            synchronized (SouthEasternEurope.class) {
                if (INSTANCE == null) {
                    INSTANCE = new SouthEasternEurope();
                }
            }
        }
        return INSTANCE;
    }
}
