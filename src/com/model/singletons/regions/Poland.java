package com.model.singletons.regions;

public class Poland {
    private static volatile Poland INSTANCE;
    private volatile Integer pointsPoland;

    public Poland() {
        this.pointsPoland = 0;
    }

    public Integer getPointsPoland() {
        return pointsPoland;
    }

    public synchronized void addOnePoint() {
        this.pointsPoland += 1;
    }

    public static Poland getInstance() {
        if (INSTANCE == null) {
            synchronized (Poland.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Poland();
                }
            }
        }
        return INSTANCE;
    }
}
