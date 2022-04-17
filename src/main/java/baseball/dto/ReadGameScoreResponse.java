package baseball.dto;

public class ReadGameScoreResponse {

    private final int strikeCount;

    private final int ballCount;

    public ReadGameScoreResponse(int strikeCount, int ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

}
