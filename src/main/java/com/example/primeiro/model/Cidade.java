package com.example.primeiro.model;

public class Cidade {

    private Long id;
    private String nome;
    private Estado estado;
    private Boolean capital;

    public Cidade(Long id, String nome, Estado estado, Boolean capital) {
        this.id = id;
        this.nome = nome;
        this.estado = estado;
        this.capital = capital;
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

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Boolean getCapital() {
        return capital;
    }

    public void setCapital(Boolean capital) {
        this.capital = capital;
    }

}
