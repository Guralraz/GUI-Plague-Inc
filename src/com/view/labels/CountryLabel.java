package com.view.labels;

import com.model.prototype.PrototypeRegion;
import com.model.services.Country;

import javax.swing.*;

public class CountryLabel extends JLabel {
    PrototypeRegion prototypeRegion;
    Country country;

    public PrototypeRegion getPrototypeRegion() {
        return prototypeRegion;
    }

    public Country getCountry() {
        return country;
    }

    public void setPrototypeRegion(PrototypeRegion prototypeRegion) {
        this.prototypeRegion = prototypeRegion;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
