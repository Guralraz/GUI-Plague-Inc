package com.model.abstractclasses;

import com.model.enums.Climate;
import com.model.enums.HealthCareLevel;
import com.model.enums.UrbanizationLevel;
import com.model.enums.WealthLevel;
import com.model.interfaces.Region;
import com.model.services.Country;

public abstract class AbstractRegion implements Region {
    private HealthCareLevel healthCareLevel;
    private Climate climate;
    private UrbanizationLevel urbanizationLevel;
    private WealthLevel wealthLevel;
    private Integer infections;
    private Integer population;
    private Country country;
    private Boolean infected;

    public AbstractRegion() {
        this.healthCareLevel = null;
        this.climate = null;
        this.urbanizationLevel = null;
        this.wealthLevel = null;
        this.infections = 0;
        this.population = 0;
        this.country = null;
        this.infected = false;
    }

    public HealthCareLevel getHealthCareLevel() {
        return healthCareLevel;
    }

    public Climate getClimate() {
        return climate;
    }

    public UrbanizationLevel getUrbanizationLevel() {
        return urbanizationLevel;
    }

    public WealthLevel getWealthLevel() {
        return wealthLevel;
    }

    public Integer getInfections() {
        return infections;
    }

    public Integer getPopulation() {
        return population;
    }

    public Country getCountry() {
        return country;
    }

    public void setHealthCareLevel(HealthCareLevel healthCareLevel) {
        this.healthCareLevel = healthCareLevel;
    }

    public void setClimate(Climate climate) {
        this.climate = climate;
    }

    public void setUrbanizationLevel(UrbanizationLevel urbanizationLevel) {
        this.urbanizationLevel = urbanizationLevel;
    }

    public void setWealthLevel(WealthLevel wealthLevel) {
        this.wealthLevel = wealthLevel;
    }

    public void setInfections(Integer infections) {
        this.infections += infections;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public void startInfection() {
        if (!infected) {
            this.infected = true;
        }
    }
}
