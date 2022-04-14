package baseball.model;

public class BallNumber {

    public static final int MIN_BALL_NUMBER = 1;
    public static final int MAX_BALL_NUMBER = 9;
    private final int number;

    public BallNumber(int number) {
        this.number = number;
        validate(number);
    }

    private void validate(int number) {
        if (number < MIN_BALL_NUMBER || number > MAX_BALL_NUMBER) {
            throw new IllegalArgumentException("1 ~ 9 사이의 숫자를 입력해주세요.");
        }
    }

}
