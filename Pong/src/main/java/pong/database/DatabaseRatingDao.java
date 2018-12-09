package pong.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseRatingDao implements RatingDao {

    
    private Connection connection;
    private String url;

    public DatabaseRatingDao(String url) {
        this.url = url;
    }

    private void connect() throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        connection = null;
        connection = DriverManager.getConnection(url);
    }

    @Override
    public List<PlayerAndRating> getRatings() {
        List<PlayerAndRating> ratings = new ArrayList<>();
        try {
            connect();
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM ratings";
            ResultSet results = statement.executeQuery(query);
            while (results.next()) {
                ratings.add(new PlayerAndRating(results.getString("name"), results.getInt("rating")));
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseRatingDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return ratings;
    }

    @Override
    public void updateRating(String name, int rating) {
        try {
            connect();
            deleteOldRating(name);
            insertNewRating(name, rating);
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
    
    private void deleteOldRating(String name) throws SQLException {
        String delete = "DELETE FROM ratings WHERE name = ? ";
        PreparedStatement statement = connection.prepareStatement(delete);
        statement.setString(1, name);
        statement.executeUpdate();
    }

    private void insertNewRating(String name, int rating) throws SQLException {
        String insert = "INSERT INTO ratings(name, rating) VALUES(?, ?)";
        PreparedStatement statement = connection.prepareStatement(insert);
        statement.setString(1, name);
        statement.setInt(2, rating);
        statement.executeUpdate();
    }

    @Override
    public int getRating(String name) {
        int rating = 1000;
        try {
            connect();
            String query = "SELECT rating FROM ratings WHERE name = ? ";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, name);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                rating = result.getInt("rating");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseRatingDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return rating;
    }

}
