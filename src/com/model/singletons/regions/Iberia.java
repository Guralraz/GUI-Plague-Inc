package com.model.singletons.regions;

public class Iberia {
    private static volatile Iberia INSTANCE;
    private volatile Integer pointsIberia;

    public Iberia() {
        this.pointsIberia = 0;
    }

    public Integer getPointsIberia() {
        return pointsIberia;
    }

    public synchronized void addOnePoint() {
        this.pointsIberia += 1;
    }

    public static Iberia getInstance() {
        if (INSTANCE == null) {
            synchronized (Iberia.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Iberia();
                }
            }
        }
        return INSTANCE;
    }
}
