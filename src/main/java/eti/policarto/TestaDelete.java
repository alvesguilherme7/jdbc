package eti.policarto;

import org.apache.commons.configuration.ConfigurationException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestaDelete {

    public static void main( String[] args ) throws SQLException {

        try( Connection conn = ConexaoComPoolFactory.getConnection() ){

            try( PreparedStatement pstm = conn.prepareStatement(" DELETE FROM PRODUTO WHERE ID > 2 ") ){
                pstm.execute();
                int updateCount = pstm.getUpdateCount();
                System.out.printf("%s row(s) affected(s).", updateCount);
            }

        }

    }
}
