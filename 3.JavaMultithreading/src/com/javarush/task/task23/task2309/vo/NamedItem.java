package com.javarush.task.task23.task2309.vo;

import java.util.Objects;

public class NamedItem {
    private int id;
    private String name;
    private String description;

    public NamedItem() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NamedItem)) return false;
        NamedItem namedItem = (NamedItem) o;
        return id == namedItem.id &&
                Objects.equals(name, namedItem.name) &&
                Objects.equals(description, namedItem.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description);
    }
}
