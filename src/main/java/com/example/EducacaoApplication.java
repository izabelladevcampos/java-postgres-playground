package com.example;

import java.sql.SQLException;

import com.example.educacao.dao.AlunoDAO;
import com.example.educacao.model.Aluno;
import com.example.primeiro.dao.ConnectionManager;

public class EducacaoApplication {

    public static void main(String[] args) {
        new EducacaoApplication();
    }

    public EducacaoApplication() {

        try (var conn = ConnectionManager.getConnection()) {
            Aluno aluno = new Aluno(null, "Izabella Maria de Oliveira Campos", null, null, null);
            var alunoDAO = new AlunoDAO(conn);
            alunoDAO.inserirNome(aluno);
            System.out.println("Aluno inserido com sucesso!");
            
            alunoDAO.inserirNota(1, 9, 15);

        } catch (SQLException e) {
            System.err.println("Erro ao tentar conectar ao banco de dados!");

        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }

    }

}
