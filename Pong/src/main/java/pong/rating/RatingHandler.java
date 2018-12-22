package pong.rating;

import pong.rating.database.DatabaseRatingDao;

/**
 * Calculates the ELO ratings for the players and updates them through RatingDao
 */
public class RatingHandler {

    private final String playerOneName;
    private final String playerTwoName;
    private final RatingDao ratingDao;
    
    /**
     *
     * @param playerOneName Name of the player one
     * @param playerTwoName Name of the player two
     * @param url path to the database
     */
    public RatingHandler(String playerOneName, String playerTwoName, String url) {
        this.playerOneName = playerOneName;
        this.playerTwoName = playerTwoName;
        ratingDao = new DatabaseRatingDao(url);
    }

    /**
     * Calculates the ELO ratings for the players and updates them through RatingDao
     * @param p1Won true if player one won otherwise false
     */
    public void updateRatings(Boolean p1Won) {
        int playerOneRating = ratingDao.getRating(playerOneName);
        int playerTwoRating = ratingDao.getRating(playerTwoName);
        int updatedPlayerOneRating;
        int updatedPlayerTworating;

        if (p1Won) {
            updatedPlayerOneRating = calculateUpdatedRating(playerOneRating, playerTwoRating, 1);
            updatedPlayerTworating = calculateUpdatedRating(playerTwoRating, playerOneRating, 0);
        } else {
            updatedPlayerOneRating = calculateUpdatedRating(playerOneRating, playerTwoRating, 0);
            updatedPlayerTworating = calculateUpdatedRating(playerTwoRating, playerOneRating, 1);
        }
        ratingDao.updateRating(playerOneName, updatedPlayerOneRating);
        ratingDao.updateRating(playerTwoName, updatedPlayerTworating);
    }

    private int calculateUpdatedRating(int beingChanged, int opponent, double whoWon) {
        int kFactor = 40;
        double expectedScore = expectedScore(beingChanged, opponent);
        return beingChanged + (int) (kFactor * (whoWon - expectedScore));
    }

    private double expectedScore(double beingChanged, double opponent) {
        beingChanged = transformRating(beingChanged);
        opponent = transformRating(opponent);
        return beingChanged / (beingChanged + opponent);
    }

    private double transformRating(double rating) {
        return Math.pow(10, rating / 400);
    }
}
