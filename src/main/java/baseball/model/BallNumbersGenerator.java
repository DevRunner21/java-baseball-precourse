package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class BallNumbersGenerator {

    public static final int BALL_COUNT = 3;

    public List<BallNumber> generateRandomBallNumbers() {
        Set<Integer> nonDupPickedNumbers = new HashSet<>();
        while (nonDupPickedNumbers.size() < BALL_COUNT) {
            int pickedNumber = Randoms.pickNumberInRange(
                    BallNumber.MIN_BALL_NUMBER,
                    BallNumber.MAX_BALL_NUMBER
            );
            nonDupPickedNumbers.add(pickedNumber);
        }

        return convertToBallNumberList(nonDupPickedNumbers);
    }

    public List<BallNumber> generateRandomBallNumbers(List<Integer> numbers) {
        validate(numbers);

        List<BallNumber> ballNumbers = new ArrayList<>();
        for (Integer pickedNumber : numbers) {
            ballNumbers.add(new BallNumber(pickedNumber));
        }

        return ballNumbers;
    }

    private List<BallNumber> convertToBallNumberList(Set<Integer> nonDupPickedNumbers) {
        List<Integer> pickedNumbers = new ArrayList<>(nonDupPickedNumbers);
        List<BallNumber> ballNumbers = new ArrayList<>();

        for (Integer pickedNumber : pickedNumbers) {
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
