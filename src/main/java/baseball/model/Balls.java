package baseball.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Balls {

    private final List<Ball> balls = new ArrayList<>();

    public Balls(List<BallNumber> ballNumbers) {
        for (int i = 0; i < ballNumbers.size(); i++) {
            balls.add(new Ball(ballNumbers.get(i), i));
        }
    }

    public Score matchToBalls(Balls rivalBalls) {
        Score score = new Score();
        if (this.equals(rivalBalls)) {
            return new Score(3, 0);
        }

        for (Ball ball : balls) {
            score = rivalBalls.checkScore(ball, score);
        }

        return score;
    }

    private Score checkScore(Ball rivalBall, Score score) {
        for (Ball ball : balls) {
            GameResult matchResult = ball.match(rivalBall);
            score = score.reportScore(matchResult);
        }
        return score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Balls balls1 = (Balls) o;
        return Objects.equals(balls, balls1.balls);
    }

    @Override
    public int hashCode() {
        return Objects.hash(balls);
    }

}
