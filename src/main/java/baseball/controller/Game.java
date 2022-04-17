package baseball.controller;

import baseball.model.BallNumber;
import baseball.model.Balls;
import baseball.dto.ReadGameScoreResponse;
import baseball.model.Score;
import java.util.List;

public class Game {

    private final Balls inputBalls;

    private final Balls answerBalls;

    public Game(List<BallNumber> inputBallNumbers, List<BallNumber> answerBallNumbers) {
        inputBalls = new Balls(inputBallNumbers);
        answerBalls = new Balls(answerBallNumbers);
    }

    public ReadGameScoreResponse start() {
        Score score = answerBalls.matchToBalls(inputBalls);

        return score.convertToReadGameScoreResponse();
    }

}
