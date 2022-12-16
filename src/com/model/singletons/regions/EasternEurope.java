package com.model.singletons.regions;

public class EasternEurope {
    private static volatile EasternEurope INSTANCE;
    private volatile Integer pointsEasternEurope;

    public EasternEurope() {
        this.pointsEasternEurope = 0;
    }

    public Integer getPointsEasternEurope() {
        return pointsEasternEurope;
    }

    public synchronized void addOnePoint() {
        this.pointsEasternEurope += 1;
    }

    public static EasternEurope getInstance() {
        if (INSTANCE == null) {
            synchronized (EasternEurope.class) {
                if (INSTANCE == null) {
                    INSTANCE = new EasternEurope();
                }
            }
        }
        return INSTANCE;
    }
}
