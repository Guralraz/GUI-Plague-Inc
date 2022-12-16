package com.model.singletons.regions;

import com.model.enums.Climate;
import com.model.enums.HealthCareLevel;
import com.model.enums.UrbanizationLevel;
import com.model.enums.WealthLevel;
import com.model.prototype.PrototypeRegion;
import com.model.services.Country;

public class NorthernEurope extends PrototypeRegion {
    private static volatile NorthernEurope INSTANCE;

    private NorthernEurope() {
        super();
        super.setClimate(Climate.ARID);
        super.setHealthCareLevel(HealthCareLevel.HIGH);
        super.setUrbanizationLevel(UrbanizationLevel.RURAL);
        super.setWealthLevel(WealthLevel.RICH);
        super.setPopulation(21061226);
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

    @Override
    public Integer getInfections() {
        return super.getInfections();
    }

    @Override
    public Integer getPopulation() {
        return super.getPopulation();
    }

    @Override
    public Country getCountry() {
        return super.getCountry();
    }

    @Override
    public synchronized void setInfections(Integer infections) {
        super.setInfections(infections);
    }

    @Override
    public void setCountry(Country country) {
        super.setCountry(country);
    }

    @Override
    public void startInfection() {
        super.startInfection();
    }

    public static NorthernEurope getInstance() {
        if (INSTANCE == null) {
            synchronized (NorthernEurope.class) {
                if (INSTANCE == null) {
                    INSTANCE = new NorthernEurope();
                }
            }
        }
        return INSTANCE;
    }
}
