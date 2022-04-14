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

}
