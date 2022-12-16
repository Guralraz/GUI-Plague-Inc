package com.model.threads;

import com.model.singletons.GlobalTime;

public class GlobalTimeThread implements Runnable {

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                GlobalTime globalTime = GlobalTime.getInstance();
                globalTime.addOneDay();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
