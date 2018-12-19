
package tests.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pong.rating.database.DatabaseRatingDao;
import pong.rating.RatingDao;
import pong.rating.RatingHandler;


public class RatingHandlerTest {
    
    private final String playerOneName = "TestName1";
    private final String playerTwoName = "TestName2";
    private static final String URL = "jdbc:sqlite:databases/test.db";
    private static Connection connection;
    private final RatingHandler ratingHandler = new RatingHandler(playerOneName, playerTwoName, URL);
    private final RatingDao dao = new DatabaseRatingDao(URL);
    
    public RatingHandlerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
              try {
            Class.forName("org.sqlite.JDBC");
            connection = null;
            connection = DriverManager.getConnection(URL);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DatabaseRatingDaoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Before
    public void setUp() {
        try {
            Statement statement = connection.createStatement();
            String delete = "DELETE FROM ratings";
            statement.executeUpdate(delete);
            String insert = "INSERT INTO ratings(name, rating) VALUES('TestName1', 1000)";
            statement.executeUpdate(insert);
            insert = "INSERT INTO ratings(name, rating) VALUES('TestName2', 2000)";
            statement.executeUpdate(insert);
        } catch (SQLException ex) {
            
        }
    }
    
    @Test
    public void eloCalculatedProperlyOnWinPlayerOne() {
        ratingHandler.updateRatings(true);
        assertEquals(1039, dao.getRating(playerOneName));
    }
    
    @Test
    public void eloCalculatedProperlyOnLossPlayerTwo() {
        ratingHandler.updateRatings(true);
        assertEquals(1961, dao.getRating(playerTwoName));
    }
    
    @Test
    public void eloCalculatedProperlyOnLossPlayerOne() {
        ratingHandler.updateRatings(false);
        assertEquals(1000, dao.getRating(playerOneName));
    }
    
    @Test
    public void eloCalculatedProperlyOnWinPlayerTwo() {
        ratingHandler.updateRatings(false);
        assertEquals(2000, dao.getRating(playerTwoName));
    }
    
}
