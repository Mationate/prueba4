package com.mationate.prueba4.models;

import java.io.Serializable;
import java.util.List;

public class PokeType implements Serializable {

    private List<Pokemon> forms;
    private PokeSprites sprites;
    private String name;
    private int id;

    public PokeType() {
    }

    public List<Pokemon> getForms() {
        return forms;
    }

    public void setForms(List<Pokemon> forms) {
        this.forms = forms;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PokeSprites getSprites() {
        return sprites;
    }

    public void setSprites(PokeSprites sprites) {
        this.sprites = sprites;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
