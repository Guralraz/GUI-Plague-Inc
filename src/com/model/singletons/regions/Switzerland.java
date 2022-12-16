package com.model.singletons.regions;

public class Switzerland {
    private static volatile Switzerland INSTANCE;
    private volatile Integer pointsSwitzerland;

    public Switzerland() {
        this.pointsSwitzerland = 0;
    }

    public Integer getPointsSwitzerland() {
        return pointsSwitzerland;
    }

    public synchronized void addOnePoint() {
        this.pointsSwitzerland += 1;
    }

    public static Switzerland getInstance() {
        if (INSTANCE == null) {
            synchronized (Switzerland.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Switzerland();
                }
            }
        }
        return INSTANCE;
    }
}
