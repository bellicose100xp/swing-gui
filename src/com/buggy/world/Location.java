package com.buggy.world;

import java.util.ArrayList;
import java.util.List;

public class Location {
    public String name;
    public List<Location> adjacentLocations = new ArrayList<>();

    public Location(String name) {
        this.name = name;
    }
}
