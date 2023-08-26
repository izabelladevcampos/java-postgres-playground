package com.example.financeiro.dao;

import java.sql.Connection;

public class TansacaoDAO {
    
    private Connection conn;

    public TansacaoDAO(Connection conn) {
        this.conn = conn;
    }

    
}
