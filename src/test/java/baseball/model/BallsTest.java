package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Balls 단위 테스트")
class BallsTest {

    @Test
    void matchToBalls_메서드는_Balls_두개를_비교_후_Score_객체를_반환합니다_3_STRIKE() {
        List<BallNumber> ballNumbers = Arrays.asList(
                new BallNumber(1),
                new BallNumber(2),
                new BallNumber(3)
        );
        Balls computerBalls = new Balls(ballNumbers);
        Balls myBalls = new Balls(ballNumbers);
        Score expected = new Score(3, 0);

        Score score = computerBalls.matchToBalls(myBalls);
        assertThat(score).isEqualTo(expected);
    }

    @Test
    void matchToBalls_메서드는_Balls_두개를_비교_후_Score_객체를_반환합니다_1_STRIKE_2_BALL() {
        Balls computerBalls = new Balls(Arrays.asList(
                new BallNumber(1),
                new BallNumber(2),
                new BallNumber(3)
        ));
        Balls myBalls = new Balls(Arrays.asList(
                new BallNumber(1),
                new BallNumber(3),
                new BallNumber(2)
        ));
        Score expected = new Score(1, 2);

        Score score = computerBalls.matchToBalls(myBalls);
        assertThat(score).isEqualTo(expected);
    }

    @Test
    void matchToBalls_메서드는_Balls_두개를_비교_후_Score_객체를_반환합니다_NOTHING() {
        Balls computerBalls = new Balls(Arrays.asList(
                new BallNumber(1),
                new BallNumber(2),
                new BallNumber(3)
        ));
        Balls myBalls = new Balls(Arrays.asList(
                new BallNumber(4),
                new BallNumber(5),
                new BallNumber(6)
        ));
        Score expected = new Score(0, 0);

        Score score = computerBalls.matchToBalls(myBalls);
        assertThat(score).isEqualTo(expected);
    }

}
