package com.example.educacao.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.example.dao.ConnectionManager;
import com.example.educacao.model.Aluno;

public class AlunoDAO {

    private Connection conn;

    public AlunoDAO(Connection conn) {
        this.conn = conn;
    }

    public void inserirNome(Aluno aluno) throws SQLException {

        conn = ConnectionManager.getConnection();
        var sql = "INSERT INTO aluno (nome) VALUES (?)";
        var statement = conn.prepareStatement(sql);
        statement.setString(1, aluno.getNome());
        statement.executeUpdate();

    }

}
