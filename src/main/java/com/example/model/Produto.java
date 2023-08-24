package com.example.model;

public class Produto {

    private Long id;
    private String name;
    private Marca marca;
    private Double valor;

    public Produto(Long id, String name, Marca marca, Double valor) {
        this.id = id;
        this.name = name;
        this.marca = marca;
        this.valor = valor;
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

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    
}
