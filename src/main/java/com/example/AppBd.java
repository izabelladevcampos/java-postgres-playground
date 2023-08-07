package com.example;

import java.sql.DriverManager;
import java.sql.SQLException;

public class AppBd {
    
    public static void main(String[] args){

        String url = "jdbc:posgresql://localhost/postgres";
        String user = "gitpod";
        String password = "";

        try {
            /*Class.forName("org.postgresql.Driver");
            var conn = DriverManager.getConnection(url, user, password);
            System.out.println("Conexão com o banco realizada com sucesso");   */
            
            Class.forName("org.postgresql.Driver");
            var conn = DriverManager.getConnection("jdbc:postgresql://localhost/postgres", "gitpod", "");
            System.out.println("Conexão realizada com sucesso!");

        } catch (ClassNotFoundException e) {
            System.err.println("Não foi possível encontrar a classe: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Não foi possível conectar ao banco de dados: " + e.getMessage());
        };
    }
}
