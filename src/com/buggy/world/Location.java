package com.buggy.world;

import java.util.ArrayList;
import java.util.List;

public class Location {
    public String name;
    public String description;
    public List<Location> adjacentLocations = new ArrayList<>();

    public Location(String name) {
        this.name = name;
    }

    public Location(String name, String description) {
        this(name);
        this.description = description;
    }
}
