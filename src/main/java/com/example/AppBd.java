package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AppBd {

    private static final String PASSWORD = "";
    private static final String USER = "gitpod";
    private static final String JDBC_URL = "jdbc:postgresql://localhost/postgres";

    public static void main(String[] args) {
        new AppBd();
    }

    public AppBd() {
        carregarDriverJdbc();
        listarEstados();
        localizarEstados("TO");
    }

    private void localizarEstados(String string) {

    }

    private void listarEstados() {

        Statement statement = null;

        try (var conn = getConnection()) {
            System.out.println("Conexão realizada com sucesso!");
            statement = conn.createStatement();
            var result = statement.executeQuery("select * from estado");
            while (result.next()) {
                System.out.printf("Id: %d Nome: %s UF: %s\n", result.getInt("id"), result.getString("nome"),
                        result.getString("uf"));
            }
            ;

        } catch (SQLException e) {
            if (statement == null)
                System.err.println("Não foi possível conectar ao banco de dados: " + e.getMessage());
            else
                System.err.println("Não foi possível realizar a consulta no banco de dados: " + e.getMessage());
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
    }

    private void carregarDriverJdbc() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("Não foi possível encontrar a classe: " + e.getMessage());
        }
    }
}
