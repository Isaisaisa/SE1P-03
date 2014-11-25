package Services;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Vector;

/**
 * Created by Louisa on 03.11.2014.
 */
public class PersistenceServiceImpl implements PersistenceService{

    //private PersistenceServiceImpl database;
    private Connection connection;
    private boolean isDriverInitialized;
    private static PersistenceServiceImpl instance;

    private String	dbURL;
    private String  user;
    private String 	pass;

    //Constructor
    private PersistenceServiceImpl(){}

    //public PersistenceService database(){
    //    return this;
    //}

    public static PersistenceServiceImpl getInstance() throws Exception {
        if (instance == null) {
            instance = new PersistenceServiceImpl();
        }
        return instance;
    }

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
     * read the config file and writes the data
     * in parameter dbURL, user and pass
     */
    public void readFile(){
        Properties props = new Properties();
        FileInputStream in;
        try {
            in =  new FileInputStream("config.properties");
            props.load(in);
            in.close();
            System.out.print("\njap es klappt\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

       setUser(props.getProperty("User"));
       setPass(props.getProperty("Pwd"));
       setDbURL(props.getProperty("dbURL"));

    }

    private Connection connection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            return connection;
        } else {
            try {
                connect();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return connection;
        }
    }

    private void connection(Connection connection) {
        this.connection = connection;
        System.out.println("Connection to database");
    }

    private void initDriver() throws ClassNotFoundException {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
//            Class.forName ("com.mysql.jdbc.Driver");
            isDriverInitialized = true;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            isDriverInitialized = false;
        }
    }

    public void connect() throws Exception {
        if (!isDriverInitialized) {
            try {
                initDriver();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        this.readFile();

        try {
            System.out.println(getDbURL());
            System.out.println(getUser());
            //Connection mit Oracle
            connection = (DriverManager.getConnection(getDbURL(), getUser(), getPass()));
            //Connection mit MySql
            //connection = (DriverManager.getConnection("jdbc:mysql://localhost/bla?"
            //        + "user=" + getUser() + "&password=" + getPass()));
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



//---------Database sendQuery--------------------------------------------------------

    public String getSingleValue(ResultSet rs) throws SQLException {
        String result = getList(rs).get(0);
        try {
            rs.getStatement().close(); // Automatisches Schließen des Statements nach Verarbeitung des ResultSets erwirken
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("DbWrapper#getSingleValue(ResultSet rs): Statement konnte nicht geschlossen werden.");
            throw e;
        }
        return result;
    }

    public String getSingleValue(PreparedStatement ps) throws SQLException {
        return getSingleValue( sendQuery(ps) );
    }

    public String getSingleValue(String query) throws SQLException {
        return getSingleValue( sendQuery(query) );
    }

    public Vector<Vector<String>> getResultVector(ResultSet resultSet) throws SQLException {
        Vector<Vector<String>> result = new Vector<Vector<String>>();

        ResultSetMetaData metaData = resultSet.getMetaData();
        int columns = metaData.getColumnCount();

        // Zeileninhalt ermitteln
        while (resultSet.next()) {
            Vector<String> row = new Vector<String>(columns);
            for (int i = 1; i <= columns; i++) {
                row.addElement(resultSet.getString(i));
            }
            result.addElement(row);
        }

        return result;
    }

    public List<String> getListOfQuery(String query) throws Exception {
        ResultSet resultSet = sendQuery(query);
        List<String> resultList = getList(resultSet);
        resultSet.getStatement().close();
        return resultList;
    }


    // kompakter Accessor, der sich der ersten Spalte bedient
    public List<String> getList(ResultSet resultSet) {
        return getList(resultSet, 1);
    }

    // bedient sich der <column>. Spalte des Resultsets und fügt sie der resultList hinzu
    public List<String> getList(ResultSet resultSet, int column) {
        List<String> resultList = new ArrayList<String>();

        try {
            while (resultSet.next()) {
                try {
                    resultList.add(resultSet.getString(column));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultList;
    }


//---------Database operations--------------------------------------------------------

    @Override
    public boolean hasResults(Vector<?> resultVector) throws SQLException {
        return resultVector.size() > 0;
    }

    public ResultSet sendQuery(String query) throws SQLException {
        try {
            if (connection() == null) {
                throw new SQLException("Keine Verbindung zur Datenbank vorhanden");
            }
            Statement statement = connection().createStatement();
            //connection().close();
            return statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public ResultSet sendQuery(PreparedStatement prepStatement) throws SQLException {
        try {
            return prepStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public void sendUpdate(String query) throws SQLException {
        try {
            connection().createStatement().executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public void sendUpdate(PreparedStatement prepStatement) throws SQLException {
        try {
            prepStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }







}
