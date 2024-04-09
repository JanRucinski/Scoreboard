# Live Football World Cup Scoreboard Library

This Java library provides functionality to manage and display ongoing football matches in a live scoreboard format. It allows users to start new matches, update scores, finish matches, and retrieve summaries of ongoing matches ordered by their total score.

## Usage

To use this library, follow these steps:

1. **Instantiate Scoreboard**: Create an instance of the `Scoreboard` class.

2. **Start a New Match**: Use the `startMatch(String homeTeam, String awayTeam)` method to start a new match by providing the names of the home team and away team.

3. **Update Score**: Use the `updateScore(int matchIndex, int homeScore, int awayScore)` method to update the score of a match. Provide the index of the match (starting from 0) and the new scores for the home team and away team.

4. **Finish Match**: Use the `finishMatch(int matchIndex)` method to finish a match. Provide the index of the match to be finished.

5. **Get Summary**: Use the `getSummary()` method to retrieve a summary of ongoing matches. The matches will be ordered by their total score. Matches with the same total score will be ordered by the most recently started match in the scoreboard.

## Example

```java
Scoreboard scoreboard = new Scoreboard();

// Start matches
scoreboard.startMatch("Team A", "Team B");
scoreboard.startMatch("Team C", "Team D");

// Update scores
scoreboard.updateScore(0, 2, 1);
scoreboard.updateScore(1, 1, 1);

// Finish a match
scoreboard.finishMatch(1);

// Get summary
List<Match> summary = scoreboard.getSummary();
for (Match match : summary) {
    System.out.println(match.getSummary());
}
