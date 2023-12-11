package com.buggy.entity;

import java.util.HashMap;
import java.util.Map;

public class Character extends Entity {
    public static Map<String, Character> characterMap = new HashMap<>();

    private String dialogue;

    public Character(String name, String description, String filename) {
        super(name, description, filename);
        characterMap.put(name, this);
    }

    public String getDialogue() {
        return dialogue;
    }

    public void setDialogue(String dialogue) {
        this.dialogue = dialogue;
    }
}
