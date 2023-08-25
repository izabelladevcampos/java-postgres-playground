package com.example.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.example.model.Produto;

public class ProdutoDAO {

    private Connection conn;

    public ProdutoDAO(Connection conn) {
        this.conn = conn;
    }

    public void listar() {

        try {
            conn = ConnectionManager.getConnection();
            var statement = conn.createStatement();
            var result = statement.executeQuery("SELECT * FROM produto");

            while (result.next()) {
                System.out.printf("Id: %d Nome: %s marca: %d valor: %f \n",
                        result.getInt("id"),
                        result.getString("nome"),
                        result.getLong("marca_id"),
                        result.getDouble("valor"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void inserir(Produto produto) {
        var sql = "INSERT INTO produto (marca_id, nome, valor) VALUES (?, ?, ?)";
        try {
            var statement = conn.prepareStatement(sql);
            statement.setLong(1, produto.getMarca().getId());
            statement.setString(2, produto.getNome());
            statement.setDouble(3, produto.getValor());

            if (statement.executeUpdate() == 1) {
                System.out.println("Produto Inserido com sucesso!");
            } else {
                System.out.println("Erro ao inserir!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void atualizar(Produto produto) {

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

    public void deletar(Long id) {
        var sql = "DELETE FROM produto WHERE id = ?";
        try {
            var statement = conn.prepareStatement(sql);
            statement.setLong(1, id);
            if (statement.executeUpdate() == 1) {
                System.out.println("Produto deletado com sucesso!");
            } else {
                System.out.println("Houve problema na deleção");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
