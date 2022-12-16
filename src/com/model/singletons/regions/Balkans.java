package com.model.singletons.regions;

import com.model.abstractclasses.AbstractRegion;
import com.model.enums.Climate;
import com.model.enums.HealthCareLevel;
import com.model.enums.UrbanizationLevel;
import com.model.enums.WealthLevel;
import com.model.prototype.PrototypeRegion;
import com.model.services.Country;

public class Balkans extends PrototypeRegion {
    private static volatile Balkans INSTANCE;

    private Balkans() {
        super();
        super.setClimate(Climate.WET);
        super.setHealthCareLevel(HealthCareLevel.LOW);
        super.setUrbanizationLevel(UrbanizationLevel.RURAL);
        super.setWealthLevel(WealthLevel.POOR);
        super.setPopulation(20074496);
    }

    @Override
    public HealthCareLevel getHealthCareLevel() {
        return super.getHealthCareLevel();
    }

    @Override
    public Climate getClimate() {
        return super.getClimate();
    }

    @Override
    public UrbanizationLevel getUrbanizationLevel() {
        return super.getUrbanizationLevel();
    }

    @Override
    public WealthLevel getWealthLevel() {
        return super.getWealthLevel();
    }

    public Integer getInfections() {
        return super.getInfections();
    }

    public void setCountry(Country country) {
        super.setCountry(country);
    }

    @Override
    public synchronized void setInfections(Integer infections) {
        super.setInfections(infections);
    }

    @Override
    public void startInfection() {
        super.startInfection();
    }

    public static Balkans getInstance() {
        if (INSTANCE == null) {
            synchronized (Balkans.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Balkans();
                }
            }
        }
        return INSTANCE;
    }
}
