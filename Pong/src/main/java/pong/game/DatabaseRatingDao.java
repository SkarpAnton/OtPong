package pong.game;

import pong.database.RatingDao;
import pong.database.Rating;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DatabaseRatingDao implements RatingDao {

    private Connection connection;

    private void connect() throws SQLException {
        connection = null;

        String url = "jdbc:sqlite:db/ratings.db";
        connection = DriverManager.getConnection(url);
    }

    @Override
    public List<Rating> getRankings() {
        return null;
    }

    @Override
    public Rating updateRanking() {
        return null;
    }

    @Override
    public Rating getRanking(String name) {
        int ranking = 1000;
        try {
            String query = "SELECT rating FROM ratings WHERE name = ? ";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, name);
            ResultSet result = statement.executeQuery();
            if (result != null) {
                ranking = result.getInt("rating");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return new Rating(name, ranking);
    }

}
