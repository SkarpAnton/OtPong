package pong.rating.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pong.rating.PlayerAndRating;

/**
 *
 * @author skarp
 */
public abstract class SqlStatement {

    protected Connection connection;
    private final String url;
    protected String name;
    protected int rating = -1;
    protected List<PlayerAndRating> ratings = new ArrayList<>();

    /**
     * Abstract method that is intended to run some SQL statement.
     *
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    protected abstract void execute()
            throws SQLException, ClassNotFoundException;

    public SqlStatement(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public List<PlayerAndRating> getRatings() {
        return ratings;
    }

    /**
     * Creates a connection to a database
     *
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    protected void connect() throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        connection = null;
        connection = DriverManager.getConnection(url);
    }

    /**
     * Runs the abstract execute method. At the moment method does nothing with
     * the exception
     */
    public void executeAndHandle() {
        try {
            execute();
        } catch (SQLException | ClassNotFoundException ex) {
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
            }
        }
    }

}
