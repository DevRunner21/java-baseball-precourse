package baseball.view;

import baseball.dto.ReadGameScoreResponse;

public class Output {

    public static final String TREE_STRIKE_ANNOUNCE_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임종료";
    public static final String BALL_UNIT = "볼";
    public static final String STRIKE_UNIT = "스트라이크";
    public static final String NOTHING_UNIT = "낫싱";

    public void printGameScore(ReadGameScoreResponse readGameScoreResponse) {
        System.out.println(makeScoreMessage(readGameScoreResponse));
    }

    public void print3StrikeMessage() {
        System.out.println(TREE_STRIKE_ANNOUNCE_MESSAGE);
    }

    private String makeScoreMessage(ReadGameScoreResponse scoreResponse) {
        StringBuilder stringBuilder = new StringBuilder();

        if (scoreResponse.getBallCount() > 0) {
            stringBuilder.append(scoreResponse.getBallCount()).append(BALL_UNIT).append(" ");
        }
        if (scoreResponse.getStrikeCount() > 0) {
            stringBuilder.append(scoreResponse.getStrikeCount()).append(STRIKE_UNIT);
        }
        if (scoreResponse.getStrikeCount() == 0 && scoreResponse.getBallCount() == 0) {
            stringBuilder.append(NOTHING_UNIT);
        }

        return stringBuilder.toString();
    }

}
