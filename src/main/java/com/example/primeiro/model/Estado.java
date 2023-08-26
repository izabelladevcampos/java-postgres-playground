package com.example.primeiro.model;

public class Estado {

    private Long id;
    private String name;
    private String uf;
    private RegiaoGeografica região;
    private Long areaKm2;
    private Long populacao;

    public Estado(Long id, String name, String uf, RegiaoGeografica região, Long areaKm2, Long populacao) {
        this.id = id;
        this.name = name;
        this.uf = uf;
        this.região = região;
        this.areaKm2 = areaKm2;
        this.populacao = populacao;
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

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public RegiaoGeografica getRegião() {
        return região;
    }

    public void setRegião(RegiaoGeografica região) {
        this.região = região;
    }

    public Long getAreaKm2() {
        return areaKm2;
    }

    public void setAreaKm2(Long areaKm2) {
        this.areaKm2 = areaKm2;
    }

    public Long getPopulacao() {
        return populacao;
    }

    public void setPopulacao(Long populacao) {
        this.populacao = populacao;
    }

}
