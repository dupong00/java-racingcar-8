package racingcar;

import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        OutputView.carAnswerPrint();
        List<String> cars = InputView.readCarNames();

        OutputView.countAnswerPrint();
        int tryCount = InputView.readTryCount();

        OutputView.resultCharPrint();

        Racing racing = new Racing(cars);
        for(int i = 0; i < tryCount; i++){
            racing.race();

            Map<String,Integer> currentStatus = racing.getCarStatus();

            OutputView.racePrint(currentStatus);
        }

        OutputView.winnerPrint(racing.winner());
    }
}
