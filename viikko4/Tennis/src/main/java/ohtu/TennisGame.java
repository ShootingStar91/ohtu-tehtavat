package ohtu;

public class TennisGame {
    
    private int player1score = 0;
    private int player2score = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == player1Name)
            player1score += 1;
        else
            player2score += 1;
    }
    
    private String sameScore() {
        String score;
        switch (player1score)
            {
                case 0:
                        score = "Love-All";
                    break;
                case 1:
                        score = "Fifteen-All";
                    break;
                case 2:
                        score = "Thirty-All";
                    break;
                case 3:
                        score = "Forty-All";
                    break;
                default:
                        score = "Deuce";
                    break;
                
            }
        return score;
    }
    
    public String scoreOverForty() {
        String score;
        int minusResult = player1score-player2score;
        if (minusResult==1) score ="Advantage player1";
        else if (minusResult ==-1) score ="Advantage player2";
        else if (minusResult>=2) score = "Win for player1";
        else score ="Win for player2";
        return score;
    }

    public String differentScore() {
        String score = "";
        int tempScore;
        for (int i=1; i<3; i++) {
            if (i==1) tempScore = player1score;
            else { 
                score += "-"; 
                tempScore = player2score;
            }
            switch(tempScore)
            {
                case 0:
                    score+="Love";
                    break;
                case 1:
                    score+="Fifteen";
                    break;
                case 2:
                    score+="Thirty";
                    break;
                case 3:
                    score+="Forty";
                    break;
            }
        }
        return score;
    }

    public String getScore() {
        if (player1score == player2score) {
            return sameScore();
        } else if (player1score >= 4 || player2score >= 4)  {
            return scoreOverForty();
        }
        return differentScore();
    }
}