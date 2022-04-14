package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Ball 단위 테스트")
class BallTest {

    @Test
    void Ball은_잘못된_값을_인자로_넘길_경우_IllegalArgumentException를_던집니다() {
        BallNumber INVALID_BALL_NUMBER = null;
        int INVALID_POSITION = -1;

        assertAll(
                () -> assertThatThrownBy(() -> new Ball(INVALID_BALL_NUMBER, 0))
                        .isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> new Ball(new BallNumber(1), INVALID_POSITION))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void match_메서드는_BallNumber와_position이_모두_같다면_STRIKE를_반환합니다() {
        BallNumber ballNumber = new BallNumber(1);
        int position = 0;
        Ball computerBall = new Ball(ballNumber, position);
        Ball myBall = new Ball(ballNumber, position);
        GameResult expected = GameResult.STRIKE;

        GameResult result = computerBall.match(myBall);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    void match_메서드는_BallNumber가_다르고_position이_같다면_NOTHING을_반환합니다() {
        int position = 0;
        Ball computerBall = new Ball( new BallNumber(1), position);
        Ball myBall = new Ball( new BallNumber(2), position);
        GameResult expected = GameResult.NOTHING;

        GameResult result = computerBall.match(myBall);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    void match_메서드는_BallNumber와_position이_모두_다르다면_NOTHING을_반환합니다() {
        Ball computerBall = new Ball(new BallNumber(1), 0);
        Ball myBall = new Ball(new BallNumber(2), 1);
        GameResult expected = GameResult.NOTHING;

        GameResult result = computerBall.match(myBall);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    void match_메서드는_BallNumber가_같고_position이_다르다면_BALL을_반환합니다() {
        BallNumber ballNumber = new BallNumber(1);
        Ball computerBall = new Ball(ballNumber, 0);
        Ball myBall = new Ball(ballNumber, 1);
        GameResult expected = GameResult.BALL;

        GameResult result = computerBall.match(myBall);

        assertThat(result).isEqualTo(expected);
    }

}
