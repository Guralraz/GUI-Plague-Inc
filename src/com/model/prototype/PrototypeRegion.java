package com.model.prototype;

import com.model.abstractclasses.AbstractRegion;
import com.model.enums.Climate;
import com.model.enums.HealthCareLevel;
import com.model.enums.UrbanizationLevel;
import com.model.enums.WealthLevel;
import com.model.services.Country;

public class PrototypeRegion extends AbstractRegion {

    public PrototypeRegion() {
        super();
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
    public void setHealthCareLevel(HealthCareLevel healthCareLevel) {
        super.setHealthCareLevel(healthCareLevel);
    }

    @Override
    public void setClimate(Climate climate) {
        super.setClimate(climate);
    }

    @Override
    public void setUrbanizationLevel(UrbanizationLevel urbanizationLevel) {
        super.setUrbanizationLevel(urbanizationLevel);
    }

    @Override
    public void setWealthLevel(WealthLevel wealthLevel) {
        super.setWealthLevel(wealthLevel);
    }

    @Override
    public void setInfections(Integer infections) {
        super.setInfections(infections);
    }

    @Override
    public void setPopulation(Integer population) {
        super.setPopulation(population);
    }

    @Override
    public void setCountry(Country country) {
        super.setCountry(country);
    }

    @Override
    public void startInfection() {
        super.startInfection();
    }
}
