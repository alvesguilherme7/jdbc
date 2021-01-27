package eti.policarto.controller;

import eti.policarto.dao.ProdutoDAO;

import java.sql.SQLException;

public class TestaDelete {

    public static void main( String[] args ) throws SQLException {
        boolean sucesso = new ProdutoDAO().deleteById(2L);
        if(sucesso)
            System.out.println("Registro excluído.");
        else
            System.err.println("Nenhuma linha afetada.");
    }
}
