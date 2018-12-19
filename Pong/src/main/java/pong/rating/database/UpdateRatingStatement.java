package pong.rating.database;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Implements the SQlStatements. Class is responsible for updating a given 
 * players rating
 */
public class UpdateRatingStatement extends SqlStatement {

    public UpdateRatingStatement(String url) {
        super(url);
    }

    @Override
    protected void execute()
            throws SQLException, ClassNotFoundException {
        connect();
        deleteOldRating();
        insertNewRating();
    }

    private void deleteOldRating() throws SQLException {
        String delete = "DELETE FROM ratings WHERE name = ? ";
        PreparedStatement statement = connection.prepareStatement(delete);
        statement.setString(1, name);
        statement.executeUpdate();
    }

    private void insertNewRating() throws SQLException {
        String insert = "INSERT INTO ratings(name, rating) VALUES(?, ?)";
        PreparedStatement statement = connection.prepareStatement(insert);
        statement.setString(1, name);
        statement.setInt(2, rating);
        statement.executeUpdate();
    }
}
