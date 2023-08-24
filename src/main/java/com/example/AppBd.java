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
            var marca = new Marca(1L);
            var produto = new Produto(1L, "produto teste", marca, 100.0);
            inserirProduto(conn, produto);
            deletarProduto(conn, 201L);
            atualizarProduto(conn, produto);
            listarDadosTabela(conn, "produto");

        } catch (Exception e) {
            System.out.println("Não foi possível conectar ao banco de dados");
        }

    }

    private void atualizarProduto(Connection conn, Produto produto) {

        var sql = "UPDATE produto SET marca_id = ?, nome = ?, valor = ? WHERE id = ?";
        try {

            var statement = conn.prepareStatement(sql);
            statement.setLong(1, 2L);
            statement.setString(2, "produto.getName()");
            statement.setDouble(3, 200.0);
            statement.setLong(4, 202L);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void deletarProduto(Connection conn, Long id) {
        var sql = "DELETE FROM produto WHERE id = ?";
        try {
            var statement = conn.prepareStatement(sql);
            statement.setLong(1, id);
            if(statement.executeUpdate() == 1){
                System.out.println("Produto deletado com sucesso!");
            }else{
                System.out.println("Houve problema na deleção");
            }
        
        } catch (SQLException e) {
            e.printStackTrace();
        }
        

    }

    private void inserirProduto(Connection conn, Produto produto) {
        var sql = "INSERT INTO produto (marca_id, nome, valor) VALUES (?, ?, ?)";
        try {
            var statement = conn.prepareStatement(sql);
            statement.setLong(1, produto.getMarca().getId());
            statement.setString(2, produto.getName());
            statement.setDouble(3, produto.getValor());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
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
