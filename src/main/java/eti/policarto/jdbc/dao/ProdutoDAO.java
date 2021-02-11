package eti.policarto.jdbc.dao;

import eti.policarto.jdbc.commons.ConexaoComPoolFactory;
import eti.policarto.jdbc.model.Categoria;
import eti.policarto.jdbc.model.Produto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    public Produto save(Produto produto) throws SQLException {

        try (Connection conn = ConexaoComPoolFactory.getConnection()) {

            conn.setAutoCommit(false);

            final String sql = "INSERT INTO PRODUTO (nome, descricao, categoria_id) VALUES (?, ?, ?) ";
            try (PreparedStatement pstm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

                pstm.setString(1, produto.getNome());
                pstm.setString(2, produto.getDescricao());
                pstm.setLong(3, produto.getCategoriaId());
                pstm.execute();

                try (ResultSet rsKeys = pstm.getGeneratedKeys()) {
                    while (rsKeys.next())
                        produto.setId(rsKeys.getLong(1));
                }

            } catch (Exception e) {
                conn.rollback();
            }

            conn.commit();

            return produto;

        }
    }

    public List<Produto> findAll() throws SQLException {
        List<Produto> produtos = new ArrayList<>();
        try (Connection conn = ConexaoComPoolFactory.getConnection()) {
            final String sql = "SELECT * FROM PRODUTO";
            try (PreparedStatement pstm = conn.prepareStatement(sql)) {
                pstm.execute();
                try (ResultSet rsProdutos = pstm.getResultSet()) {
                    while (rsProdutos.next()) {
                        produtos.add(new Produto(rsProdutos));
                    }
                }
            }
        }
        return produtos;
    }

    public List<Produto> findByCategoria(Categoria categoria) throws SQLException {
        List<Produto> produtos = new ArrayList<>();
        try (Connection conn = ConexaoComPoolFactory.getConnection()) {
            final String sql = "SELECT * FROM PRODUTO WHERE ID = ? ";
            try (PreparedStatement pstm = conn.prepareStatement(sql)) {
                pstm.setLong(1, categoria.getId());
                pstm.execute();
                try (ResultSet rsProdutos = pstm.getResultSet()) {
                    while (rsProdutos.next()) {
                        produtos.add(new Produto(rsProdutos));
                    }
                }
            }
        }
        return produtos;
    }

    public boolean deleteById(Long id) throws SQLException {
        try( Connection conn = ConexaoComPoolFactory.getConnection() ){
            try( PreparedStatement pstm = conn.prepareStatement(" DELETE FROM PRODUTO WHERE ID = ? ") ){
                pstm.setLong(1, id);
                pstm.execute();
                return pstm.getUpdateCount() > 0;
            }
        }
    }

}
