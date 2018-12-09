
package pong.database;

import java.util.List;


public interface RatingDao {
    List<PlayerAndRating> getRatings();
    void updateRating(String name, int rating);
    int getRating(String name);
}
