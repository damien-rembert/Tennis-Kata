
public class TennisGame1 implements TennisGame {

    private int m_score1 = 0;
    private int m_score2 = 0;
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
            m_score1++;
        else
            m_score2++;
    }

    public String getScore() {
        if (m_score1 == m_score2) {
            return handleEqual();
        } else if (m_score1 >= 4 || m_score2 >= 4) {
            return handleEndGame();
        } else {
            return handleMidGame();
        }
    }

    private String handleMidGame() {
        String score = "";
        int tempScore = 0;

        for (int i = 1; i < 3; i++) {

            if (i == 1)
                tempScore = m_score1;
            else {
                score += "-";
                tempScore = m_score2;
            }
            switch (tempScore) {
                case 0:
                    score += LOVE;
                    break;
                case 1:
                    score += FIFTEEN;
                    break;
                case 2:
                    score += THIRTY;
                    break;
                case 3:
                    score += FORTY;
                    break;
            }
        }
        return score;
    }

    private String handleEndGame() {
        int difference = m_score1 - m_score2;
        if (difference == 1)
            return appendPlayer1Name("Advantage");
        else if (difference == -1)
            return appendPlayer2Name("Advantage");
        else if (difference >= 2)
            return appendPlayer1Name(WIN);
        else
            return appendPlayer2Name(WIN);
    }

    private String handleEqual() {
        switch (m_score1) {
            case 0:
                return LOVE_ALL;
            case 1:
                return FIFTEEN_ALL;
            case 2:
                return THIRTY_ALL;
            default:
                return DEUCE;
        }
    }

    private String appendPlayer1Name(String string) {
        return string + " " + player1Name;
    }

    private String appendPlayer2Name(String string) {
        return string + " " + player2Name;
    }
}
