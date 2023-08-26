package com.example.educacao.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.example.educacao.model.Aluno;
import com.example.primeiro.dao.ConnectionManager;

public class AlunoDAO {

    private Connection conn;

    public AlunoDAO(Connection conn) {
        this.conn = conn;
    }

    public void inserirNome(Aluno aluno) {

        try {
            conn = ConnectionManager.getConnection();
            var sql = "INSERT INTO aluno (nome) VALUES (?)";
            var statement = conn.prepareStatement(sql);
            statement.setString(1, aluno.getNome());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void inserirNota(int idDisciplina, double nota){
        
        try {
            var sql = "UPDATE aluno SET nota" + "?";
            conn = ConnectionManager.getConnection();
            var statement = conn.prepareStatement(sql);
            statement.setString(1, String.valueOf(idDisciplina));
        } catch (SQLException e) {
           throw new RuntimeException();
        }
    } 

}
