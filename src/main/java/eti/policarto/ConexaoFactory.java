package eti.policarto;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {

    public static Connection getConnection(String url, String user, String pass) throws SQLException, ClassNotFoundException {
        return DriverManager.getConnection(url, user, pass);
    }

    public static Connection getConnection() throws ConfigurationException, SQLException, ClassNotFoundException {
        PropertiesConfiguration configuration = new PropertiesConfiguration();
        configuration.load("application.properties");
        String url = configuration.getString("bd.url");
        String user = configuration.getString("bd.username");
        String pass = configuration.getString("bd.pass");
        return getConnection(url, user, pass);
    }
}
