public class Match {
    private String homeTeam;
    private String awayTeam;
    private int homeScore;
    private int awayScore;

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

    public int getHomeScore(){ return homeScore; }

    public int getAwayScore(){ return awayScore; }

    public int getTotalScore() {
        return homeScore + awayScore;
    }

    public String getSummary() {
        return String.format("%s %d - %s %d", homeTeam, homeScore, awayTeam, awayScore);
    }
}