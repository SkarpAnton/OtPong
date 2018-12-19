package pong.rating.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import pong.rating.PlayerAndRating;

/**
 * Implements the SQlStatements. Class is responsible of getting the top rated 
 * players names and their ratings
 */
public class GetTopTenStatement extends SqlStatement {

    public GetTopTenStatement(String url) {
        super(url);
    }

    @Override
    protected void execute() throws SQLException, ClassNotFoundException {
        connect();
        Statement statement = connection.createStatement();
        String query = "SELECT * FROM ratings ORDER BY rating DESC LIMIT 10 ";
        ResultSet results = statement.executeQuery(query);
        while (results.next()) {
            ratings.add(new PlayerAndRating(results.getString("name"), results.getInt("rating")));
        }
    }

}
