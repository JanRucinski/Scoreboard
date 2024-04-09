import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Scoreboard {
    class Match {
        String homeTeam;
        String awayTeam;
        int homeScore;
        int awayScore;
        
        public Match(String homeTeam, String awayTeam) {
            this.homeTeam = homeTeam;
            this.awayTeam = awayTeam;
            this.homeScore = 0;
            this.awayScore = 0;
        }
        
        public void updateScore(int homeScore, int awayScore) {
            this.homeScore = homeScore;
            this.awayScore = awayScore;
        }
        
        public int getTotalScore() {
            return homeScore + awayScore;
        }
        
        public String getSummary() {
            return homeTeam + " " + homeScore + " - "   + awayTeam + " " +  awayScore;
        }
    }

    List<Match> matches;
    
    public Scoreboard() {
        matches = new ArrayList<>();
    }
    
    public void startMatch(String homeTeam, String awayTeam) {
        Match match = new Match(homeTeam, awayTeam);
        matches.add(match);
    }
    
    public void updateScore(int matchIndex, int homeScore, int awayScore) {
        if (matchIndex < 0 || matchIndex >= matches.size()) {
            throw new IllegalArgumentException("Invalid match index");
        }
        Match match = matches.get(matchIndex);
        match.updateScore(homeScore, awayScore);
    }
    
    public void finishMatch(int matchIndex) {
        matches.remove(matchIndex);
    }
    
    private List<Match> getSummaryHelper() {
        List<Match> summary = new ArrayList<>(matches);
        Collections.sort(summary, new Comparator<Match>() {
            @Override
            public int compare(Match m1, Match m2) {
                if (m1.getTotalScore() != m2.getTotalScore()) {
                    return Integer.compare(m2.getTotalScore(), m1.getTotalScore());
                } else {
                    // Compare based on the order of matches added
                    return Integer.compare(matches.indexOf(m2), matches.indexOf(m1));
                }
            }
        });
        return summary;
    }

    public List<String> getSummary() {
        List<String> summary = new ArrayList<>();
        for (Match match : getSummaryHelper()) {
            summary.add(match.getSummary());
        }
        return summary;
    }
    
}
