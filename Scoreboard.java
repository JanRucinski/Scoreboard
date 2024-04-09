import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Scoreboard {
    private List<Match> matches;

    public Scoreboard() {
        matches = new ArrayList<>();
    }

    public void startMatch(String homeTeam, String awayTeam) {
        Match match = new Match(homeTeam, awayTeam);
        matches.add(match);
    }

    public void updateScore(int matchIndex, int homeScore, int awayScore) {
        validateMatchIndex(matchIndex);
        Match match = matches.get(matchIndex);
        match.updateScore(homeScore, awayScore);
    }

    public void finishMatch(int matchIndex) {
        validateMatchIndex(matchIndex);
        matches.remove(matchIndex);
    }

    public List<String> getSummary() {
        List<Match> summaryMatches = new ArrayList<>(matches);
        Comparator<Match> matchComparator = Comparator.comparingInt(Match::getTotalScore).thenComparingInt(matches::indexOf);
        summaryMatches.sort(matchComparator);

        List<String> summary = new ArrayList<>();
        for (Match match : summaryMatches) {
            summary.add(match.getSummary());
        }
        return summary;
    }

    private void validateMatchIndex(int matchIndex) {
        if (matchIndex < 0 || matchIndex >= matches.size()) {
            throw new IllegalArgumentException("Invalid match index");
        }
    }

    public List<Match> getMatches() {
        return matches;
    }

}