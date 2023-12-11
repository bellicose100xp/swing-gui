package com.buggy.entity;

import java.util.HashMap;
import java.util.Map;

public class Item {
    public static Map<String, Item> itemsMap = new HashMap<>();

    private String name;
    private String description;
    private String filename;

    public Item(String name, String description, String filename) {
        this.name = name;
        this.description = description;
        this.filename = filename;
        itemsMap.put(name, this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}
