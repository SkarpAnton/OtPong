
package pong.rating;

import java.util.List;

/**
 * DAO interface for updating and getting name and rating of a player.
 */
public interface RatingDao {

    /**
     * Gets top ten players by rating
     * @return List of ten PlayeRating object which are sorted by rating  
     */
    List<PlayerAndRating> getTopTen();

    /**
     * Updates a given players rating
     * @param name name of the player whose rating is being updated
     * @param rating rating that replaces old rating
     */
    void updateRating(String name, int rating);
    
    int getRating(String name);
}
