package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class BallNumbersGenerator {

    public static final int BALL_COUNT = 3;

    public List<BallNumber> generateRandomBallNumbers() {
        List<Integer> pickedNumbers = Randoms
                .pickUniqueNumbersInRange(BallNumber.MIN_BALL_NUMBER, BallNumber.MAX_BALL_NUMBER, BALL_COUNT);

        List<BallNumber> ballNumbers = new ArrayList<>();
        for (Integer pickedNumber : pickedNumbers) {
            ballNumbers.add(new BallNumber(pickedNumber));
        }

        return ballNumbers;
    }

    public List<BallNumber> generateRandomBallNumbers(List<Integer> numbers) {
        validate(numbers);

        List<BallNumber> ballNumbers = new ArrayList<>();
        for (Integer pickedNumber : numbers) {
            ballNumbers.add(new BallNumber(pickedNumber));
        }

        return ballNumbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateUniqueNumbers(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (Objects.isNull(numbers) || numbers.isEmpty() || numbers.size() != BALL_COUNT) {
            throw new IllegalArgumentException("숫자는 " + BALL_COUNT + "개를 입력해야 합니다.");
        }
    }

    private void validateUniqueNumbers(List<Integer> numbers) {
        HashSet<Integer> nonDupNumbers = new HashSet<>(numbers);
        if (nonDupNumbers.size() != BALL_COUNT) {
            throw new IllegalArgumentException("서로 다른 숫자를 입력해주세요.");
        }
    }

}
