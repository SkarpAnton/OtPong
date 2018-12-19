package pong.rating;

/**
 *
 * Contains the name and rating of the player
 */
public class PlayerAndRating {

    private final String name;
    private final int rating;

    public PlayerAndRating(String name, int rating) {
        this.name = name;
        this.rating = rating;
    }


    public String getName() {
        return name;
    }


    public int getRating() {
        return rating;
    }
}
