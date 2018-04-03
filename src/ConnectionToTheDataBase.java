import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionToTheDataBase {
    public Connection getConnection(){
        InputStream stream = getClass().getResourceAsStream("../Properties/DataBase.properties");
        Properties properties = new Properties();
        Connection conn = null;
        try {
            properties.load(stream);
            getClass().forName(properties.getProperty("drivers"));
            conn = DriverManager.getConnection(properties.getProperty("url"),properties.getProperty("username"),
                    properties.getProperty("password"));
        } catch (Exception e) {
            System.out.println(e);
        }
        return conn;
    }
}
