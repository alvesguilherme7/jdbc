package eti.policarto;

import java.sql.*;

public class TestaSelect {

    public static void main( String[] args ) throws Exception {

        try(  Connection conn = ConexaoComPoolFactory.getConnection()  ){

            try( PreparedStatement pstm = conn.prepareStatement(" SELECT * FROM PRODUTO ") ){
                pstm.execute();
                try(ResultSet rsProdutos = pstm.getResultSet()){
                    while (rsProdutos.next())
                        System.out.println(rsProdutos.getString("DESCRICAO"));
                }
            }

        }

    }
}
