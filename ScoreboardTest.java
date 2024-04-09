import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ScoreboardTest {
    private Scoreboard scoreboard;

    @Before
    public void setUp() {
        scoreboard = new Scoreboard();
    }

    @After
    public void tearDown() {
        scoreboard = null;
    }

    @Test
    public void testStartMatchAddsMatchToList() {
        scoreboard.startMatch("Team A", "Team B");
        assertEquals(1, scoreboard.getMatches().size());
    }

    @Test
    public void testUpdateScoreUpdatesMatchScore() {
        scoreboard.startMatch("Team A", "Team B");
        scoreboard.updateScore(0, 2, 1);
        assertEquals(2, scoreboard.getMatches().get(0).getHomeScore());
        assertEquals(1, scoreboard.getMatches().get(0).getAwayScore());
    }

    @Test
    public void testFinishMatchRemovesMatchFromList() {
        scoreboard.startMatch("Team A", "Team B");
        scoreboard.finishMatch(0);
        assertEquals(0, scoreboard.getMatches().size());
    }

    @Test
    public void testGetSummaryReturnsCorrectSummary() {
        scoreboard.startMatch("Team A", "Team B");
        scoreboard.startMatch("Team C", "Team D");
        scoreboard.updateScore(0, 2, 1);
        scoreboard.updateScore(1, 1, 1);
        scoreboard.finishMatch(1);

        List<String> summary = scoreboard.getSummary();
        assertEquals(1, summary.size());
        assertEquals("Team A 2 - Team B 1", summary.get(0));
    }
}