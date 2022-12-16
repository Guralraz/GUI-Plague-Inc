package com.model.singletons.regions;

public class CentralEurope {
    private static volatile CentralEurope INSTANCE;
    private volatile Integer pointsCentralEurope;

    public CentralEurope() {
        this.pointsCentralEurope = 0;
    }

    public Integer getPointsCentralEurope() {
        return pointsCentralEurope;
    }

    public synchronized void addOnePoint() {
        this.pointsCentralEurope += 1;
    }

    public static CentralEurope getInstance() {
        if (INSTANCE == null) {
            synchronized (CentralEurope.class) {
                if (INSTANCE == null) {
                    INSTANCE = new CentralEurope();
                }
            }
        }
        return INSTANCE;
    }
}
