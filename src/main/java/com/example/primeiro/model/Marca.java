package com.example.primeiro.model;

public class Marca {

    private Long id;
    private String name;

    public Marca(Long id) {
        this.id = id;
    }

    public Marca(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
