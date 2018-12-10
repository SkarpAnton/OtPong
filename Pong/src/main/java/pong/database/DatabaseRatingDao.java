package pong.database;

import java.util.List;
import pong.database.sqlstatements.GetRatingStatement;
import pong.database.sqlstatements.GetTopTenStatement;
import pong.database.sqlstatements.UpdateRatingStatement;

public class DatabaseRatingDao implements RatingDao {

    private String url;

    public DatabaseRatingDao(String url) {
        this.url = url;
    }

    @Override
    public List<PlayerAndRating> getTopTen() {
        GetTopTenStatement statement = new GetTopTenStatement(url);
        statement.executeAndHandle();
        return statement.getRatings();
    }

    @Override
    public void updateRating(String name, int rating) {
        UpdateRatingStatement statement = new UpdateRatingStatement(url);
        statement.setName(name);
        statement.setRating(rating);
        statement.executeAndHandle();
    }
    

    @Override
    public int getRating(String name) {
        GetRatingStatement statement = new GetRatingStatement(url);
        statement.setName(name);
        statement.executeAndHandle();
        int rating = statement.getRating();
        if (rating == -1) {
            return 1000;
        }
        return rating;
    }
}
