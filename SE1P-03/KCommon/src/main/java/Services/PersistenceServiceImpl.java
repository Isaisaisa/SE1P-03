package Services;

import java.sql.*;

/**
 * Created by Louisa on 03.11.2014.
 */
public class PersistenceServiceImpl implements PersistenceService{

    private Connection connection;
    private boolean			 	isDriverInitialized;

    private String				dbURL = "jdbc:oracle:thin:@oracle.informatik.haw-hamburg.de:1521:inf09";
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
