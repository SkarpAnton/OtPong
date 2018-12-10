package pong.database.sqlstatements;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pong.database.DatabaseRatingDao;
import pong.database.PlayerAndRating;

public abstract class SqlStatement {

    protected Connection connection;
    private final String url;
    protected String name;
    protected int rating = -1;
    protected List<PlayerAndRating> ratings = new ArrayList<>();

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

    protected void connect() throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        connection = null;
        connection = DriverManager.getConnection(url);
    }

    public void executeAndHandle() {
        try {
            execute();
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseRatingDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    

    
    
}
