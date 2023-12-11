package com.buggy.entity;

public abstract class Entity {
   private String name;
   private String description;
   private String filename;

    public Entity() {
    }

    public Entity(String name, String description, String filename) {
        this.name = name;
        this.description = description;
        this.filename = filename;
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
