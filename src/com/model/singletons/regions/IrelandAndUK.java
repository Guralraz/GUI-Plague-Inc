package com.model.singletons.regions;

public class IrelandAndUK {
    private static volatile IrelandAndUK INSTANCE;
    private volatile Integer pointsIrelandUK;

    public IrelandAndUK() {
        this.pointsIrelandUK = 0;
    }

    public Integer getPointsIrelandUK() {
        return pointsIrelandUK;
    }

    public synchronized void addOnePoint() {
        this.pointsIrelandUK += 1;
    }

    public static IrelandAndUK getInstance() {
        if (INSTANCE == null) {
            synchronized (IrelandAndUK.class) {
                if (INSTANCE == null) {
                    INSTANCE = new IrelandAndUK();
                }
            }
        }
        return INSTANCE;
    }
}
