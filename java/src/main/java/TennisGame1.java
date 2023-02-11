
public class TennisGame1 implements TennisGame {

    private int scorePlayer1 = 0;
    private int scorePlayer2 = 0;
    private String player1Name;
    private String player2Name;

    private static final String LOVE_ALL = "Love-All";
    private static final String FIFTEEN_ALL = "Fifteen-All";
    private static final String THIRTY_ALL = "Thirty-All";
    private static final String DEUCE = "Deuce";
    private static final String LOVE = "Love";
    private static final String WIN = "Win for";
    private static final String FIFTEEN = "Fifteen";
    private static final String THIRTY = "Thirty";
    private static final String FORTY = "Forty";

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equalsIgnoreCase(player1Name))
            scorePlayer1++;
        else
            scorePlayer2++;
    }

    public String getScore() {
        if (scorePlayer1 == scorePlayer2) {
            return handleEqual();
        } else if (scorePlayer1 >= 4 || scorePlayer2 >= 4) {
            return handleEndGame();
        } else {
            return handleMidGame();
        }
    }

    private String handleMidGame() {
        return getScoreName(scorePlayer1) + "-" + getScoreName(scorePlayer2);
    }

    private String getScoreName(int score) {
        if (score == 0) return LOVE;
        if (score == 1) return FIFTEEN;
        if (score == 2) return THIRTY;
        return FORTY;
    }

    private String handleEndGame() {
        int difference = scorePlayer1 - scorePlayer2;
        if (difference == 1)
            return appendPlayer1Name("Advantage");
        if (difference == -1)
            return appendPlayer2Name("Advantage");
        if (difference >= 2)
            return appendPlayer1Name(WIN);
        return appendPlayer2Name(WIN);
    }

    private String handleEqual() {
        if (scorePlayer1 == 0)
                return LOVE_ALL;
        if (scorePlayer1 == 1)
                return FIFTEEN_ALL;
        if (scorePlayer1 == 2)
                return THIRTY_ALL;
        return DEUCE;
    }

    private String appendPlayer1Name(String string) {
        return string + " " + player1Name;
    }

    private String appendPlayer2Name(String string) {
        return string + " " + player2Name;
    }
}
