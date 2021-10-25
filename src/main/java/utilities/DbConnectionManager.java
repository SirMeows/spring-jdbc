package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbConnectionManager {
    private static String url;
    private static String username;
    private static String password;
    private static Connection conn = null;

    public Connection getConnection() {
        if(conn!=null) {
            return conn;
        }
        try {

            var stream = new FileInputStream("application.properties");
            var properties = new Properties();
            properties.load(stream);
            url = properties.getProperty("db.url");
            username = properties.getProperty("db.username");
            password = properties.getProperty("db.password");
            conn = DriverManager.getConnection(url, username, password);

        } catch(IOException | SQLException e) {
            System.out.println("Something went wrong SQL connection");
        }

        return conn;
    }
}
