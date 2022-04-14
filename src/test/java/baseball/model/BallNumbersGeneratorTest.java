package baseball.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("BallNumbersGenerator 단위 테스트")
class BallNumbersGeneratorTest {

    private BallNumbersGenerator ballNumbersGenerator;

    @BeforeEach
    void setUp() {
        ballNumbersGenerator = new BallNumbersGenerator();
    }

    @Test
    void generateRandomBallNumbers_메서드는_BALL_COUNT_만큼의_서로_다른_Ball_목록을_반환합니다() {
        List<BallNumber> generatedBallNumbers = ballNumbersGenerator.generateRandomBallNumbers();

        assertThat(generatedBallNumbers.size()).isEqualTo(BallNumbersGenerator.BALL_COUNT);
        assertTrue(isAllArgUnique(generatedBallNumbers));
    }

    private boolean isAllArgUnique(List<BallNumber> ballNumbers) {
        HashSet<BallNumber> nonDupBallNumbers = new HashSet<>(ballNumbers);
        return nonDupBallNumbers.size() == ballNumbers.size();
    }

    @Test
    void generateRandomBallNumbers_메서드는_입력값에_대한_Ball_목록을_반환합니다() {
        List<Integer> inputNumbers = Arrays.asList(1, 2, 3);
        List<BallNumber> expected = Arrays.asList(
                new BallNumber(1),
                new BallNumber(2),
                new BallNumber(3)
        );

        List<BallNumber> generatedBallNumbers = ballNumbersGenerator.generateRandomBallNumbers(inputNumbers);

        assertThat(generatedBallNumbers).isEqualTo(expected);
    }

    @Test
    void generateRandomBallNumbers_메서드는_잘못된_입력값에_대해_IllegalArgumentException_을_던집니다() {
        List<Integer> NULL_INPUT = null;
        List<Integer> EMPTY_NUMBERS_INPUT = new ArrayList<>();
        List<Integer> INVALID_SIZE_INPUT = Arrays.asList(1, 1, 2);
        List<Integer> DUPLICATED_NUMBERS_INPUT = Arrays.asList(1, 1, 2);

        assertAll(
                () -> assertThatThrownBy(() -> ballNumbersGenerator.generateRandomBallNumbers(NULL_INPUT))
                        .isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> ballNumbersGenerator.generateRandomBallNumbers(EMPTY_NUMBERS_INPUT))
                        .isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> ballNumbersGenerator.generateRandomBallNumbers(INVALID_SIZE_INPUT))
                        .isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> ballNumbersGenerator.generateRandomBallNumbers(DUPLICATED_NUMBERS_INPUT))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

}
