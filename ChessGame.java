public class ChessGame {
    private int gameId;
    private boolean rated;
    private int turns;
    private String victoryStatus;
    private String winner;
    private String timeIncrement;
    private String whiteId;
    private int whiteRating;
    private String blackId;
    private int blackRating;


    // Constructor
    public ChessGame(int gameId, boolean rated, int turns, String victoryStatus, String winner, String timeIncrement,
                     String whiteId, int whiteRating, String blackId, int blackRating) {
        this.gameId = gameId;
        this.rated = rated;
        this.turns = turns;
        this.victoryStatus = victoryStatus;
        this.winner = winner;
        this.timeIncrement = timeIncrement;
        this.whiteId = whiteId;
        this.whiteRating = whiteRating;
        this.blackId = blackId;
        this.blackRating = blackRating;
    }


    public int getGameId() {
        return gameId;
    }

    public boolean isRated() {
        return rated;
    }

    public int getTurns() {
        return turns;
    }

    public String getVictoryStatus() {
        return victoryStatus;
    }

    public String getWinner() {
        return winner;
    }

    public String getTimeIncrement() {
        return timeIncrement;
    }

    public String getWhiteId() {
        return whiteId;
    }

    public int getWhiteRating() {
        return whiteRating;
    }

    public String getBlackId() {
        return blackId;
    }

    public int getBlackRating() {
        return blackRating;
    }

    public double getAveragePlayerRating() {
        return  (double)blackRating + (double)whiteRating / 2;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public void setRated(boolean rated) {
        this.rated = rated;
    }

    public void setTurns(int turns) {
        this.turns = turns;
    }

    public void setVictoryStatus(String victoryStatus) {
        this.victoryStatus = victoryStatus;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public void setTimeIncrement(String timeIncrement) {
        this.timeIncrement = timeIncrement;
    }

    public void setWhiteId(String whiteId) {
        this.whiteId = whiteId;
    }

    public void setWhiteRating(int whiteRating) {
        this.whiteRating = whiteRating;
    }

    public void setBlackId(String blackId) {
        this.blackId = blackId;
    }

    public void setBlackRating(int blackRating) {
        this.blackRating = blackRating;
    }


    @Override
    public String toString() {
        return gameId + "," + rated + "," + getAveragePlayerRating() + "," + turns + "," + victoryStatus + "," + winner + "," +
                timeIncrement + "," + whiteId + "," + whiteRating + "," + blackId + "," + blackRating;
    }
}