package com.example.financeiro.model;

import java.util.ArrayList;
import java.util.List;

public class Transacao {

    private Integer id;
    private String cliente;
    private double valor;
    private String moeda;
    private String tipo;

    public List<Transacao> todasTransacoes = new ArrayList<>();

    public Transacao(String cliente, double valor, String moeda, String tipo, List<Transacao> todasTransacoes) {
        this.cliente = cliente;
        this.valor = valor;
        this.moeda = moeda;
        this.tipo = tipo;
        this.todasTransacoes = todasTransacoes;
    }

    public Integer getId() {
        return id;
    }

    public String getCliente() {
        return cliente;
    }

    public double getValor() {
        return valor;
    }

    public String getMoeda() {
        return moeda;
    }

    public String getTipo() {
        return tipo;
    }

    public List<Transacao> getTodasTransacoes() {
        return todasTransacoes;
    }

    public void adicionarTransacao(Transacao t) {
        todasTransacoes.add(t);
    }

    public double getSaldo(String cliente) {
        double saldo = 0.0;
        for (Transacao t : todasTransacoes) {
            saldo += t.valor;
        }
        return saldo;
    }

}
