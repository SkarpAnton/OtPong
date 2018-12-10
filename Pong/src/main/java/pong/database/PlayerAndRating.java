package pong.database;

public class PlayerAndRating {

    private final String name;
    private final int rating;

    public PlayerAndRating(String name, int ranking) {
        this.name = name;
        this.rating = ranking;
    }

    public String getName() {
        return name;
    }

    public int getRating() {
        return rating;
    }
}
