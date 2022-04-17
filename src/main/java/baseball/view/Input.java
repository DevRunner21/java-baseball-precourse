package baseball.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Input {

    public static final String REQUEST_INPUT_COMMAND_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static final String REQUEST_INPUT_NUMBERS_MESSAGE = "숫자를 입력해주세요 : ";
    public static final String REGEX_ONLY_NUMBER = "[0-9]+";
    public static final String DELIMITER = "";

    public String inputGameCommand() {
        System.out.println(REQUEST_INPUT_COMMAND_MESSAGE);
        return Console.readLine();
    }

    public List<Integer> inputBallNumbers() {
        System.out.print(REQUEST_INPUT_NUMBERS_MESSAGE);
        String input = Console.readLine();
        if (isNotNumeric(input)) {
            throw new IllegalArgumentException("숫자만 입력이 가능합니다.");
        }

        return convertNumberStrToNumberList(input);
    }

    public List<Integer> convertNumberStrToNumberList(String input) {
        String[] split = input.split(DELIMITER);

        List<Integer> inputNumbers = new ArrayList<>();
        for (String s : split) {
            inputNumbers.add(Integer.valueOf(s));
        }

        return inputNumbers;
    }

    public boolean isNotNumeric(String input) {
        return !input.matches(REGEX_ONLY_NUMBER);
    }

}
