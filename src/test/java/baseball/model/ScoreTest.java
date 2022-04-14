package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@DisplayName("Score 단위테스트")
class ScoreTest {

    private Score score;

    @BeforeEach
    void setUp() {
        score = new Score();
    }

    @Test
    void reportScore_메서드는_인자로_전달된_값이_STRIKE_일_경우_STRIKE_점수를_기록한_후_Score_객체를_반환합니다() {
        Score expected = new Score(1, 0);

        score = score.reportScore(GameResult.STRIKE);

        assertThat(score).isEqualTo(expected);
    }

    @Test
    void reportScore_메서드는_인자로_전달된_값이_BALL_일_경우_BALL_점수를_기록한_후_Score_객체를_반환합니다() {
        Score expected = new Score(0, 1);

        score = score.reportScore(GameResult.BALL);

        assertThat(score).isEqualTo(expected);
    }

    @Test
    void reportScore_메서드는_인자로_전달된_값이_NOTHING_일_경우_현재_Score_객체를_그대로_반환합니다() {
        Score expected = new Score(0, 0);

        score = score.reportScore(GameResult.NOTHING);

        assertThat(score).isEqualTo(expected);
    }

}
