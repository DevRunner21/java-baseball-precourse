package baseball.model;

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

}
