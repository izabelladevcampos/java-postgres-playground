package com.example;

public class Produto {

    private Long id;
    private String name;
    private Marca marca;

    public Produto(Long id, String name, Marca marca) {
        this.id = id;
        this.name = name;
        this.marca = marca;
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

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

}
