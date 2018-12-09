
package pong.database;

import pong.database.Rating;
import java.util.List;


public interface RatingDao {
    List<Rating> getRankings();
    Rating updateRanking();
    Rating getRanking(String name);
}
