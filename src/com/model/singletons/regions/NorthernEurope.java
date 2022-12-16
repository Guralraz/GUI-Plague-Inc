package com.model.singletons.regions;

public class NorthernEurope {
    private static volatile NorthernEurope INSTANCE;
    private volatile Integer pointsNorthernEurope;

    public NorthernEurope() {
        this.pointsNorthernEurope = 0;
    }

    public Integer getPointsNorthernEurope() {
        return pointsNorthernEurope;
    }

    public synchronized void addOnePoint() {
        this.pointsNorthernEurope += 1;
    }

    public static NorthernEurope getInstance() {
        if (INSTANCE == null) {
            synchronized (NorthernEurope.class) {
                if (INSTANCE == null) {
                    INSTANCE = new NorthernEurope();
                }
            }
        }
        return INSTANCE;
    }
}
