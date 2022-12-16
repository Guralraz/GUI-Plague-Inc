package com.model.singletons.regions.tempactwo;

import java.util.List;

public class CountryRepr {
    private Integer internalId;
    private String name;
    private List<CountryRepr> neighbours;

    public CountryRepr(Integer internalId, String name, List<CountryRepr> neighbours) {
        this.internalId = internalId;
        this.name = name;
        this.neighbours = neighbours;
    }

    public Integer getInternalId() {
        return internalId;
    }

    public void setInternalId(Integer internalId) {
        this.internalId = internalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CountryRepr> getNeighbours() {
        return neighbours;
    }

    public void setNeighbours(List<CountryRepr> neighbours) {
        this.neighbours = neighbours;
    }
}
