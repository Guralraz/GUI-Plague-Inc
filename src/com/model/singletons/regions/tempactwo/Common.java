package com.model.singletons.regions.tempactwo;

import java.util.HashMap;
import java.util.Map;

public class Common {
    private Map<Integer, CountryRepr> maps = new HashMap<>();

    private Map<Integer, String> mapping = Map.of(1, "France",
            230, "ruslandia",
            431, "Ukrainlandia",
            132, "Faszytolandia");

    public void init() {
        Integer id = 0;
        for(Map.Entry<Integer, String> entry : mapping.entrySet()) {
            maps.put(entry.getKey(), new CountryRepr(id, entry.getValue(), null));
        }
    }
}
