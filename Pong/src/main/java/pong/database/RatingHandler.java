package pong.database;

public class RatingHandler {

    private final String url = "jdbc:sqlite:databases/ratings.db";
    private final RatingDao dao = new DatabaseRatingDao(url);
    private final String playerOneName;
    private final String playerTwoName;

    public RatingHandler(String playerOneName, String playerTwoName) {
        this.playerOneName = playerOneName;
        this.playerTwoName = playerTwoName;
    }

    public void updateRatings(Boolean p1Won) {
        int playerOneRating = dao.getRating(playerOneName);
        int playerTwoRating = dao.getRating(playerTwoName);
        int updatedPlayerOneRating;
        int updatedPlayerTworating;

        if (p1Won) {
            updatedPlayerOneRating = calculateUpdatedRating(playerOneRating, playerTwoRating, 1);
            updatedPlayerTworating = calculateUpdatedRating(playerTwoRating, playerOneRating, 0);
        } else {
            updatedPlayerOneRating = calculateUpdatedRating(playerOneRating, playerTwoRating, 0);
            updatedPlayerTworating = calculateUpdatedRating(playerTwoRating, playerOneRating, 1);
        }
        dao.updateRating(playerOneName, updatedPlayerOneRating);
        dao.updateRating(playerTwoName, updatedPlayerTworating);
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

    public RatingDao getDao() {
        return dao;
    }
}
