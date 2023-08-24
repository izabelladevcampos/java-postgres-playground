package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AppBd {

    private static final String PASSWORD = "";
    private static final String USER = "gitpod";
    private static final String JDBC_URL = "jdbc:postgresql://localhost/postgres";

    public static void main(String[] args) {
        new AppBd();
    }

    public AppBd() {
        try (var conn = getConnection();) {
            listarEstados(conn);
            localizarEstados(conn, "TO");
            listarDadosTabela(conn, "cliente");
            var produto = new Produto();
            inserirProduto(produto);

        } catch (Exception e) {
            System.out.println("Não foi possível conectar ao banco de dados");
        }

    }

    private void listarDadosTabela(Connection conn, String tabela) {
        var sql = "SELECT * FROM " + tabela;
        try {
            var statement = conn.createStatement();
            var result = statement.executeQuery(sql);

            var metadata = result.getMetaData();
            int cols = metadata.getColumnCount();

            for (int i = 1; i <= cols; i++) {
                System.out.printf("%-25s |", metadata.getColumnName(i));
            }
            System.out.println();
            while (result.next()) {
                for (int i = 1; i <= cols; i++) {
                    System.out.printf("%-25s |", result.getString(i));
                }
                System.out.println();
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void localizarEstados(Connection conn, String uf) {

        try {
            var sql = "SELECT * FROM estado WHERE uf = ?";
            var statement = conn.prepareStatement(sql);
            statement.setString(1, uf);
            var result = statement.executeQuery();
            if (result.next()) {
                System.out.printf("-----Pesquisa-----Id: %d Nome: %s UF: %s\n", result.getInt("id"),
                        result.getString("nome"),
                        result.getString("uf"));
            } else {
                System.out.println("Não foi possível realizar consulta!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void listarEstados(Connection conn) {

        try {

            conn = getConnection();
            System.out.println("Conexão realizada com sucesso!");
            var statement = conn.createStatement();
            var result = statement.executeQuery("select * from estado");
            while (result.next()) {
                System.out.printf("Id: %d Nome: %s UF: %s\n", result.getInt("id"), result.getString("nome"),
                        result.getString("uf"));
            }
            ;

        } catch (SQLException e) {
            System.err.println("Não foi possível realizar a consulta no banco de dados: " + e.getMessage());
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
    }

}
