package com.model.singletons.regions;

public class France {
    private static volatile France INSTANCE;
    private volatile Integer pointsFrance;

    public France() {
        this.pointsFrance = 0;
    }

    public Integer getPointsFrance() {
        return pointsFrance;
    }

    public synchronized void addOnePoint() {
        this.pointsFrance += 1;
    }

    public static France getInstance() {
        if (INSTANCE == null) {
            synchronized (France.class) {
                if (INSTANCE == null) {
                    INSTANCE = new France();
                }
            }
        }
        return INSTANCE;
    }
}
