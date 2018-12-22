package tests.rating;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pong.game.AI;
import pong.rating.database.DatabaseRatingDao;
import pong.rating.PlayerAndRating;
import pong.rating.RatingDao;

public class DatabaseRatingDaoTest {

    private static final String URL = "jdbc:sqlite::resource:"
            + AI.class.getClassLoader().getResource("databases/test.db");
    private static Connection connection;
    private final RatingDao dao = new DatabaseRatingDao(URL);

    public DatabaseRatingDaoTest() {
    }

    @BeforeClass
    public static void setUpClass() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = null;
            connection = DriverManager.getConnection(URL);
        } catch (ClassNotFoundException | SQLException ex) {
        }
    }

    @Before
    public void setUp() {
        try {
            Statement statement = connection.createStatement();
            String delete = "DELETE FROM ratings";
            statement.executeUpdate(delete);
            String insert = "INSERT INTO ratings(name, rating) VALUES('TestName1', 10)";
            statement.executeUpdate(insert);
            insert = "INSERT INTO ratings(name, rating) VALUES('TestName2', 20)";
            statement.executeUpdate(insert);
        } catch (SQLException ex) {
        }

    }

    @Test
    public void testGet() {
        assertEquals(10, dao.getRating("TestName1"));
    }

    @Test
    public void testGetNameDoesNotExist() {
        assertEquals(1000, dao.getRating("NoName"));
    }

    @Test
    public void testAdd() {
        dao.updateRating("testi", 5);
        assertEquals(5, dao.getRating("testi"));
    }

    @Test
    public void testTopTen() {
        List<PlayerAndRating> ratings = dao.getTopTen();
        assertTrue(20 == ratings.get(0).getRating() && 10 == ratings.get(1).getRating());
    }

}
