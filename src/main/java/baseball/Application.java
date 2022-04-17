package baseball;

import baseball.controller.Game;
import baseball.dto.ReadGameScoreResponse;
import baseball.model.BallNumber;
import baseball.model.BallNumbersGenerator;
import baseball.view.Input;
import baseball.view.Output;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        BallNumbersGenerator ballNumbersGenerator = new BallNumbersGenerator();
        Input input = new Input();
        Output output = new Output();

        gameStart(ballNumbersGenerator, input, output);
    }

    private static void gameStart(BallNumbersGenerator ballNumbersGenerator, Input input, Output output) {
        List<BallNumber> answerBallNumbers = ballNumbersGenerator.generateRandomBallNumbers();

        while (true) {
            List<BallNumber> inputBallNumbers = generateInputBallNumbers(ballNumbersGenerator, input);

            Game game = new Game(inputBallNumbers, answerBallNumbers);
            ReadGameScoreResponse readGameScoreResponse = game.start();
            output.printGameScore(readGameScoreResponse);

            if (isNotGameOver(readGameScoreResponse)) {
                continue;
            }

            output.print3StrikeMessage();
            break;
        }
    }

    private static List<BallNumber> generateInputBallNumbers(BallNumbersGenerator ballNumbersGenerator, Input input) {
        List<Integer> inputNumbers = input.inputBallNumbers();
        return ballNumbersGenerator.generateRandomBallNumbers(inputNumbers);
    }

    private static boolean isNotGameOver(ReadGameScoreResponse readGameScoreResponse) {
        return readGameScoreResponse.getStrikeCount() != 3;
    }

}
