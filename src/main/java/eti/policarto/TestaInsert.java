package eti.policarto;

import java.sql.*;

public class TestaInsert {

    public static void main( String[] args ) throws Exception {

        try( Connection conn = ConexaoComPoolFactory.getConnection() ){

            conn.setAutoCommit(false);

            try(
                PreparedStatement pstm = conn.prepareStatement(
                        " INSERT INTO PRODUTO (nome, descricao) VALUES (?, ?) ",
                        Statement.RETURN_GENERATED_KEYS
                )
            ){

                pstm.setString(1,"Smartphone H1");
                pstm.setString(2,"Television Smartphone H1");
                pstm.execute();

                try(ResultSet rsKeys = pstm.getGeneratedKeys()){
                    while (rsKeys.next())
                        System.out.println(rsKeys.getLong(1));
                }

            }catch (Exception e){
                conn.rollback();
            }

            conn.commit();

        }

    }
}
