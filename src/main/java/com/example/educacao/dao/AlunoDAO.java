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
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível inserir o aluno!", e);
        }

    }

    public void inserirNota(int idDisciplina, double nota, int matricula) {

        if (idDisciplina <= 0 || idDisciplina > 3) {
            throw new IllegalArgumentException("Id da disciplinas é entre  1 e 3");
        }

        try {
            var sql = "UPDATE aluno SET nota" + idDisciplina + " = ? WHERE matricula = ?";
            conn = ConnectionManager.getConnection();
            var statement = conn.prepareStatement(sql);
            statement.setDouble(1, nota);
            statement.setInt(2, matricula);
            var result = statement.executeUpdate();
            System.out.println(result);
            if (result == 1) {
                System.out.println("Nota inserida com sucesso!");
            } else {
                System.out.println("Nota não inserida!");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível inserir a nota!", e);
        }
    }

}
