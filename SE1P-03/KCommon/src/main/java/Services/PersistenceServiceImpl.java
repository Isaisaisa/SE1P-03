package Services;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * Created by Louisa on 03.11.2014.
 */
public class PersistenceServiceImpl implements PersistenceService{

    private Connection connection;
    private boolean			 	isDriverInitialized;

    private String				dbURL;
    private String  			user;
    private String 				pass;


    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getDbURL() {
        return dbURL;
    }

    public void setDbURL(String dbURL) {
        this.dbURL = dbURL;
    }

    /**
     * read the config file
     */
    public void readFile(){
        Properties props = new Properties();
        FileInputStream in;
        try {
            in =  new FileInputStream("config.properties");
            props.load(in);
            in.close();
            System.out.print("jap es klappt");
        } catch (IOException e) {
            e.printStackTrace();
        }

       setUser(props.getProperty("User"));
       setPass(props.getProperty("Pwd"));
       setDbURL(props.getProperty("dbURL"));

    }


    private void connection(Connection connection) {
        this.connection = connection;
        System.out.println("Connection to database");
    }


    private void initDriver() throws ClassNotFoundException {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            isDriverInitialized = true;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            isDriverInitialized = false;
        }
    }

    public void connect() throws Exception {
        // Sicherstellen, dass Datenbanktreiber initialisiert wurde
        // (falls nicht => nachträglich initialisieren)
        if (!isDriverInitialized) {
            try {
                initDriver();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        // Datenkonsistenz prüfen
        try {
            System.out.println(getDbURL());
            System.out.println(getUser());
            connection = (DriverManager.getConnection(dbURL, user, pass));
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }

    }

    public void close() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }
}
