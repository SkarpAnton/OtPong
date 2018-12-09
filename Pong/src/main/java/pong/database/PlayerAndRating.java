package pong.database;

public class PlayerAndRating implements Comparable<PlayerAndRating> {

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

    @Override
    public int compareTo(PlayerAndRating comparedTo) {
        return comparedTo.getRating() - rating;
    }

}
