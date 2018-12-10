
package pong.database;

import java.util.List;


public interface RatingDao {
    List<PlayerAndRating> getTopTen();
    void updateRating(String name, int rating);
    int getRating(String name);
}
