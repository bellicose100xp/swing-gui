package com.buggy.entity;

import java.util.HashMap;
import java.util.Map;

public class Item extends Entity {
    public static Map<String, Item> itemsMap = new HashMap<>();

    public Item(String name, String description, String filename) {
        super(name, description, filename);
        itemsMap.put(name, this);
    }

}
