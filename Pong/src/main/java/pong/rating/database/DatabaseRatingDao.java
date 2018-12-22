package pong.rating.database;

import java.util.List;
import pong.rating.PlayerAndRating;
import pong.rating.RatingDao;


/**
 * Database implementation of the RatingDao
 */
public class DatabaseRatingDao implements RatingDao {

    private final String url;

    /**
     * 
     * @param url path to the database
     */
    public DatabaseRatingDao(String url) {
        this.url = url;
    }

    /**
     * Gets top ten players by rating
     * @return List of ten PlayeRating object which are sorted by rating  
     */
    @Override
    public List<PlayerAndRating> getTopTen() {
        GetTopTenStatement statement = new GetTopTenStatement(url);
        statement.executeAndHandle();
        return statement.getRatings();
    }

    /**
     * Updates a given players rating
     * @param name name of the player whose rating is being updated
     * @param rating rating that replaces old rating
     */
    @Override
    public void updateRating(String name, int rating) {
        UpdateRatingStatement statement = new UpdateRatingStatement(url);
        statement.setName(name);
        statement.setRating(rating);
        statement.executeAndHandle();
    }
    
    /**
     * Gets rating of a player
     * @param name name of the player whose rating is being retrieved
     * @return rating of the player
     */
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
