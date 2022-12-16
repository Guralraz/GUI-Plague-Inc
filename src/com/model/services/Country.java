package com.model.services;

import java.awt.*;

public class Country {
    private Integer number;
    private Shape shape;

    public Country(Integer number, Shape shape) {
        this.number = number;
        this.shape = shape;
    }

    public Integer getNumber() {
        return number;
    }

    public Shape getShape() {
        return shape;
    }
}