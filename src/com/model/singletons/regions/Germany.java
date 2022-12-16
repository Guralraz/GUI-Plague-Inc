package com.model.singletons.regions;

public class Germany {
    private static volatile Germany INSTANCE;
    private volatile Integer pointsGermany;

    public Germany() {
        this.pointsGermany = 0;
    }

    public Integer getPointsGermany() {
        return pointsGermany;
    }

    public synchronized void addOnePoint() {
        this.pointsGermany += 1;
    }

    public static Germany getInstance() {
        if (INSTANCE == null) {
            synchronized (Germany.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Germany();
                }
            }
        }
        return INSTANCE;
    }
}
