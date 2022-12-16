package com.model.singletons.regions;

public class Greece {
    private static volatile Greece INSTANCE;
    private volatile Integer pointsGreece;

    public Greece() {
        this.pointsGreece = 0;
    }

    public Integer getPointsGreece() {
        return pointsGreece;
    }

    public synchronized void addOnePoint() {
        this.pointsGreece += 1;
    }

    public static Greece getInstance() {
        if (INSTANCE == null) {
            synchronized (Greece.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Greece();
                }
            }
        }
        return INSTANCE;
    }
}
