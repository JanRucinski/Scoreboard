import java.util.List;
import org.junit.Test;

public class ScoreboardTest {
    public static void main(String[] args) {
        testStartMatch();
        testUpdateScore();
        testFinishMatch();
        testGetSummary();
    }

    @Test
    public static void testStartMatch() {
        Scoreboard scoreboard = new Scoreboard();
        scoreboard.startMatch("Team A", "Team B");
        assert scoreboard.matches.size() == 1 : "Failed to start match";
    }

    @Test
    public static void testUpdateScore() {
        Scoreboard scoreboard = new Scoreboard();
        scoreboard.startMatch("Team A", "Team B");
        scoreboard.updateScore(0, 2, 1);
        assert scoreboard.matches.get(0).homeScore == 2 && scoreboard.matches.get(0).awayScore == 1 :
                "Failed to update score";
    }

    @Test
    public static void testFinishMatch() {
        Scoreboard scoreboard = new Scoreboard();
        scoreboard.startMatch("Team A", "Team B");
        scoreboard.finishMatch(0);
        assert scoreboard.matches.size() == 0 : "Failed to finish match";
    }

    @Test
    public static void testGetSummary() {
        Scoreboard scoreboard = new Scoreboard();
        scoreboard.startMatch("Team A", "Team B");
        scoreboard.startMatch("Team C", "Team D");
        scoreboard.updateScore(0, 2, 1);
        scoreboard.updateScore(1, 1, 1);
        scoreboard.finishMatch(1);

        List<String> summary = scoreboard.getSummary();
        assert summary.size() == 1 : "Incorrect number of matches in summary";
        assert summary.get(0).equals("Team A 2 - Team B 1") : "Incorrect summary content";
    }
}
