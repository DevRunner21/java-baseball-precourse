package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("BallNumber 단위 테스트")
class BallNumberTest {

    @ParameterizedTest(name = "BallNumber 생성 - 성공 {index} , args = {arguments}")
    @ValueSource(ints = {BallNumber.MAX_BALL_NUMBER, BallNumber.MIN_BALL_NUMBER})
    void BallNumber_는_MIN_BALL_NUMBER_이상_MAX_BALL_NUMBER_이하의_수를_필드로_생성됩니다(int number) {
        assertThat(new BallNumber(number)).isNotNull();
    }

    @ParameterizedTest(name = "BallNumber 생성 - 실패 {index} , args = {arguments}")
    @ValueSource(ints = {BallNumber.MAX_BALL_NUMBER + 1, BallNumber.MIN_BALL_NUMBER - 1})
    void BallNumber_는_1_이상_9_이하의_수가_아니라면_IllegalArgumentException_을_던집니다(int number) {
        assertThatThrownBy(() -> new BallNumber(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
