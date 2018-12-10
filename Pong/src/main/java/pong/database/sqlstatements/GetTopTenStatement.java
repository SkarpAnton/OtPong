package pong.database.sqlstatements;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import pong.database.PlayerAndRating;

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
            System.out.println(results.getInt("rating"));
            ratings.add(new PlayerAndRating(results.getString("name"), results.getInt("rating")));
        }
    }

}
