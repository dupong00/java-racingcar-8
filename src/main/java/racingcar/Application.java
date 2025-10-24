package racingcar;

import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        List<String> cars = InputView.readCarNames();

        int tryCount = InputView.readTryCount();

        Racing racing = new Racing(cars);
        for(int i = 0; i < tryCount; i++){
            racing.race();

            Map<String,Integer> currentStatus = racing.getCarStatus();

            OutputVIew.race_print(currentStatus);
        }

        OutputVIew.winner_print(racing.winner());
    }
}
