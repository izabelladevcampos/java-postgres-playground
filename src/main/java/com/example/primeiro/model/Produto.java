package com.example.primeiro.model;

public class Produto {

    private Long id;
    private String nome;
    private Marca marca;
    private Double valor;

    public Produto(Long id, String nome, Marca marca, Double valor) {
        this.id = id;
        this.nome = nome;
        this.marca = marca;
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
