package baseball.model;

import java.util.Objects;

public class Score {

    private final int strikeCount;

    private final int ballCount;

    public Score(int strikeCount, int ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public Score() {
        this.strikeCount = 0;
        this.ballCount = 0;
    }

    public Score reportScore(GameResult matchResult) {
        if (matchResult.equals(GameResult.STRIKE)) {
            return new Score(strikeCount + 1, ballCount);
        }

        if (matchResult.equals(GameResult.BALL)) {
            return new Score(strikeCount, ballCount + 1);
        }

        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Score score = (Score) o;
        return strikeCount == score.strikeCount && ballCount == score.ballCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(strikeCount, ballCount);
    }

}
