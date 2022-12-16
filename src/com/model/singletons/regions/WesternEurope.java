package com.model.singletons.regions;

public class WesternEurope {
    private static volatile WesternEurope INSTANCE;
    private volatile Integer pointsWesternEurope;

    public WesternEurope() {
        this.pointsWesternEurope = 0;
    }

    public Integer getPointsWesternEurope() {
        return pointsWesternEurope;
    }

    public synchronized void addOnePoint() {
        this.pointsWesternEurope += 1;
    }

    public static WesternEurope getInstance() {
        if (INSTANCE == null) {
            synchronized (WesternEurope.class) {
                if (INSTANCE == null) {
                    INSTANCE = new WesternEurope();
                }
            }
        }
        return INSTANCE;
    }
}
