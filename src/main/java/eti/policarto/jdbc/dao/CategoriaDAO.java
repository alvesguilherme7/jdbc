package eti.policarto.jdbc.dao;

import eti.policarto.jdbc.commons.ConexaoComPoolFactory;
import eti.policarto.jdbc.model.Categoria;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {

    public Categoria save(Categoria categoria) throws SQLException {

        try (Connection conn = ConexaoComPoolFactory.getConnection()) {

            conn.setAutoCommit(false);

            final String sql = "INSERT INTO CATEGORIA (descricao) VALUES (?) ";
            try (PreparedStatement pstm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

                pstm.setString(1, categoria.getDescricao());
                pstm.execute();

                try (ResultSet rsKeys = pstm.getGeneratedKeys()) {
                    while (rsKeys.next())
                        categoria.setId(rsKeys.getLong(1));
                }

            } catch (Exception e) {
                conn.rollback();
            }

            conn.commit();

            return categoria;

        }
    }

    public Categoria findById(Long id) throws SQLException {
        try (Connection conn = ConexaoComPoolFactory.getConnection()) {
            final String sql = " SELECT * FROM CATEGORIA WHERE ID = ? ";
            try (PreparedStatement pstm = conn.prepareStatement(sql)) {
                pstm.setLong(1, id);
                pstm.execute();
                try (ResultSet rsCategorias = pstm.getResultSet()) {
                    if (rsCategorias.next())
                        return new Categoria(rsCategorias);
                }
            }
        }
        return null;
    }

    public List<Categoria> findAll() throws SQLException {
        List<Categoria> categorias = new ArrayList<>();
        try (Connection conn = ConexaoComPoolFactory.getConnection()) {
            final String sql = "SELECT * FROM CATEGORIA";
            try (PreparedStatement pstm = conn.prepareStatement(sql)) {
                pstm.execute();
                try (ResultSet rsCategorias = pstm.getResultSet()) {
                    while (rsCategorias.next()) {
                        categorias.add(new Categoria(rsCategorias));
                    }
                }
            }
        }
        return categorias;
    }

    public boolean deleteById(Long id) throws SQLException {
        try( Connection conn = ConexaoComPoolFactory.getConnection() ){
            try( PreparedStatement pstm = conn.prepareStatement(" DELETE FROM CATEGORIA WHERE ID = ? ") ){
                pstm.setLong(1, id);
                pstm.execute();
                return pstm.getUpdateCount() > 0;
            }
        }
    }

}
