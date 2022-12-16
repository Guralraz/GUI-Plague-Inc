package com.model.singletons;

import java.time.LocalDate;

public class GlobalTime {

    private static volatile  GlobalTime INSTANCE;
    private volatile LocalDate actualTime;

    private GlobalTime() {
        this.actualTime = LocalDate.now();
    }

    public LocalDate getActualTime() {
        return actualTime;
    }

    public synchronized void addOneDay() {
        this.actualTime = actualTime.plusDays(1);
    }

    public static GlobalTime getInstance() {
        if (INSTANCE == null) {
            synchronized (GlobalTime.class) {
                if (INSTANCE == null) {
                    INSTANCE = new GlobalTime();
                }
            }
        }
        return INSTANCE;
    }

}
