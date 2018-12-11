package pong.ui.menu.leaderboard;

import java.util.List;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import pong.database.DatabaseRatingDao;
import pong.database.PlayerAndRating;
import pong.database.RatingDao;

import pong.ui.menu.MenuElements;

public class LeaderboardElements extends MenuElements {

    private final String url = "jdbc:sqlite:databases/ratings.db";
    private final RatingDao dao = new DatabaseRatingDao(url);
    private HBox leaderboard;
    private Text instruction;
    private Text title;

    public LeaderboardElements() {
        initializeInstruction();
        initializeLeaderboard();
        initializeTitle();
    }

    private void initializeLeaderboard() {

        VBox rankings = new VBox(createTableHeader("Rank"));
        VBox names = new VBox(createTableHeader("Name"));
        VBox elo = new VBox(createTableHeader("Elo"));
        leaderboard = new HBox(rankings, names, elo);
        leaderboard.setSpacing(50);
        List<PlayerAndRating> playerRatings = dao.getTopTen();
        for (int i = 1; i <= 10; i++) {
            PlayerAndRating playerRating = playerRatings.get(i - 1);
            rankings.getChildren().add(createTableElement(i + ""));
            elo.getChildren().add(createTableElement(playerRating.getRating() + ""));
            names.getChildren().add(createTableElement(playerRating.getName()));
        }
        leaderboard.setTranslateX(270);
        leaderboard.setTranslateY(150);
    }

    private Text createTableElement(String text) {
        Text textElement = new Text(text);
        textElement.setFill(Color.WHITE);
        textElement.setFont(Font.font("Verdana", 30));
        return textElement;
    }

    private void initializeTitle() {
        title = new Text("Top 10");
        title.setFill(Color.WHITE);
        title.setFont(Font.font("Verdana", 70));
        title.setX(430);
        title.setY(100);
    }

    private void initializeInstruction() {
        instruction = new Text("Press enter to go to menu");
        instruction.setFill(Color.WHITE);
        instruction.setFont(Font.font("Verdana", 40));
        instruction.setX(270);
        instruction.setY(700);
    }

    private Text createTableHeader(String header) {
        Text headerElement = new Text(header);
        headerElement.setFill(Color.WHITE);
        headerElement.setFont(Font.font("Verdana", 40));
        return headerElement;
    }

    public HBox getLeaderboard() {
        return leaderboard;
    }

    public Text getInstruction() {
        return instruction;
    }

    public Text getTitle() {
        return title;
    }

}
