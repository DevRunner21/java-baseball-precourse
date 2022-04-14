package baseball.model;

import java.util.Objects;

public class Ball {

    private final BallNumber ballNumber;

    private final int position;

    public Ball(BallNumber ballNumber, int position) {
        validateBallNumber(ballNumber);
        validatePosition(position);

        this.ballNumber = ballNumber;
        this.position = position;
    }

    private void validatePosition(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("position은 음수 일 수 없습니다.");
        }
    }

    private void validateBallNumber(BallNumber ballNumber) {
        if (Objects.isNull(ballNumber)) {
            throw new IllegalArgumentException("ballNumber는 Null 일 수 없습니다.");
        }
    }

    public GameResult match(Ball ball) {
        if (this.equals(ball)) {
            return GameResult.STRIKE;
        }

        if (ball.isDiffBallNumber(this.ballNumber) && ball.isDiffPosition(this.position)) {
            return GameResult.NOTHING;
        }

        return GameResult.BALL;
    }

    private boolean isDiffBallNumber(BallNumber ballNumber) {
        return this.ballNumber != ballNumber;
    }

    private boolean isDiffPosition(int position) {
        return this.position != position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Ball ball = (Ball) o;
        return position == ball.position && Objects.equals(ballNumber, ball.ballNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ballNumber, position);
    }

}
