package eti.policarto;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConexaoComPoolFactory {

    private static DataSource dataSource;

    static {
        try {
            dataSource = ConexaoComPoolFactory.initPoolDs();
        } catch (SQLException | ConfigurationException e) {
            System.err.println("Não foi possível abrir o pool de conexões.");
            e.printStackTrace();
            System.exit(0);
        }
    }

    public static DataSource initPoolDs() throws ConfigurationException, SQLException {
        ComboPooledDataSource poolDs = new ComboPooledDataSource();
        setCredenciais(poolDs);
        poolDs.setAutoCommitOnClose(false);
        poolDs.setMinPoolSize(3);
        poolDs.setMaxPoolSize(100);
        return poolDs;
    }

    public static void setCredenciais(ComboPooledDataSource poolDs) throws ConfigurationException {
        PropertiesConfiguration configuration = new PropertiesConfiguration();
        configuration.load("application.properties");
        poolDs.setJdbcUrl(configuration.getString("bd.url"));
        poolDs.setUser(configuration.getString("bd.username"));
        poolDs.setPassword(configuration.getString("bd.pass"));
    }

    public static Connection getConnection() throws SQLException {
        return ConexaoComPoolFactory.dataSource.getConnection();
    }
}
