package org.example.tennisgamekata;

public class TennisGame {

    private int playerOneScore = 0;
    private int playerTwoScore = 0;
    private final String playerOneName = "A";
    private final String playerTwoName = "B";

    private boolean gameOver;

    public void getScore(String result) {

        if (result.isEmpty()) throw new IllegalArgumentException("Illegal result");

        int i = 0;

        while (i < result.length() && !gameOver) {
            addPointToPlayer(String.valueOf(result.charAt(i)));
            System.out.print(getScoreAfterWonBall() + "\n");
            i++;
        }
    }

    public String getScoreAfterWonBall() {

        if (hasWinner()) {
            this.gameOver = true;
            return "Player " + getHighScorerPlayer() + " wins the game";
        }

        if (hasAdvantage()) {
            return "Advantage " + getHighScorerPlayer();
        }

        if (isDeuce())
            return "Deuce Game";

        return "Player A :" + getOutputScore(playerOneScore) + " / Player B :" + getOutputScore(playerTwoScore);
    }

    private boolean isDeuce() {
        return playerOneScore >= 3 && playerTwoScore == playerOneScore;
    }

    private String getHighScorerPlayer() {
        return playerOneScore > playerTwoScore ? playerOneName : playerTwoName;
    }

    private boolean hasWinner() {
        return (playerTwoScore >= 4 && playerTwoScore >= playerOneScore + 2) || (playerOneScore >= 4 && playerOneScore >= playerTwoScore + 2);
    }

    private boolean hasAdvantage() {
        return (playerTwoScore >= 4 && playerTwoScore == playerOneScore + 1) || (playerOneScore >= 4 && playerOneScore == playerTwoScore + 1);
    }

    private void addPointToPlayer(String playerName) {
        if (playerName.equals(playerOneName)) playerOneScore++;
        else playerTwoScore++;
    }

    private String getOutputScore(int score) {
        return switch (score) {
            case 0 -> "0";
            case 1 -> "15";
            case 2 -> "30";
            case 3 -> "40";
            default -> throw new IllegalArgumentException("Illegal score:" + score);
        };
    }


}
