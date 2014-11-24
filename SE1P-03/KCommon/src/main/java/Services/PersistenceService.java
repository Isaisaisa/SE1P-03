package Services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

    /**
     *
     * @param prepStatement
     * @return ResultSet of the query
     * @throws SQLException
     */
    public ResultSet sendQuery(PreparedStatement prepStatement) throws SQLException;

}
