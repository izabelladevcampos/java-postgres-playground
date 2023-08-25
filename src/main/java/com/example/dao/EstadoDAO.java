package com.example.dao;

import java.sql.Connection;
import java.sql.SQLException;

public class EstadoDAO {

    private Connection conn;

    public EstadoDAO(Connection conn) {
        this.conn = conn;
    }

    public void listar() {

        try {

            conn = ConnectionManager.getConnection();
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


    public void localizar(String uf) {

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
}
