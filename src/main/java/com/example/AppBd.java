package com.example;

import com.example.dao.ConnectionManager;
import com.example.dao.DAO;
import com.example.dao.EstadoDAO;
import com.example.dao.ProdutoDAO;
import com.example.model.Marca;
import com.example.model.Produto;

public class AppBd {

    public static void main(String[] args) {
        new AppBd();
    }

    public AppBd() {
        try (var conn = ConnectionManager.getConnection();) {

            var estadoDAO = new EstadoDAO(conn);
            estadoDAO.listar();
            estadoDAO.localizar("TO");

            var marca = new Marca(1L);
            var produto = new Produto(1L, "produto teste", marca, 100.0);

            var produtoDAO = new ProdutoDAO(conn);
            produtoDAO.inserir(produto);
            produtoDAO.deletar(216L);
            produtoDAO.atualizar(produto);
            produtoDAO.listar();

            var dao = new DAO(conn);
            dao.listar("estado");

        } catch (Exception e) {
            System.out.println("Não foi possível conectar ao banco de dados");
        }

    }

}
