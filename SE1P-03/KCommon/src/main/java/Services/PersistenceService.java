package Services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

/**
 * Created by Louisa on 03.11.2014.
 */
public interface PersistenceService {

    /**
     * read the config file and writes the data
     * in parameter dbURL, user and pass
     */
    public void readFile();

    /**
     * connects to Database.
     * Oracle Database is required.
     * @throws Exception
     */
    public void connect() throws Exception;

    /**
     *
     * @param query
     * @return ResultSet of the query
     * @throws SQLException
     */
    public ResultSet sendQuery(String query) throws SQLException;
    public boolean hasResults(Vector<?> resultVector) throws SQLException;

    public String getSingleValue(ResultSet rs) throws SQLException;
    public String getSingleValue(PreparedStatement ps) throws SQLException;
    public String getSingleValue(String query) throws SQLException;

    public Vector<Vector<String>> getResultVector(ResultSet resultSet) throws SQLException;

    public List<String> getListOfQuery(String query) throws Exception;

    /**
     *
     * @param prepStatement
     * @return ResultSet of the query
     * @throws SQLException
     */
    public ResultSet sendQuery(PreparedStatement prepStatement) throws SQLException;

    public void sendUpdate(String query) throws SQLException;
    public void sendUpdate(PreparedStatement prepStatement) throws SQLException;

    /**
     *
     * @param resultSet
     * @return
     */
    public List<String> getList(ResultSet resultSet);

    public List<String> getList(ResultSet resultSet, int column);

    public void close() throws SQLException;

}
