package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    @DisplayName("Map생성이 정상적으로 동작하는지 확인한다.")
    void race() {
        List<String> cars = Arrays.asList("pobi", "woni", "jun");

        Racing racing = new Racing(cars);
        Map<String, Integer> carStatus = racing.getCarStatus();

        assertThat(carStatus.get("pobi")).isEqualTo(0);
        assertThat(carStatus.get("woni")).isEqualTo(0);
        assertThat(carStatus.get("jun")).isEqualTo(0);
        assertThat(carStatus.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("race: 랜덤 값에 따라 이동한다.")
    void race_move_and_stop() {
        List<String> cars = Arrays.asList("pobi", "woni", "jun");
        Racing racing = new Racing(cars);

        assertRandomNumberInRangeTest(
                () -> {
                    racing.race();
                    Map<String, Integer> carStatus = racing.getCarStatus();

                    assertThat(carStatus.get("pobi")).isEqualTo(1);
                    assertThat(carStatus.get("woni")).isEqualTo(1);
                    assertThat(carStatus.get("jun")).isEqualTo(0);
                },
                MOVING_FORWARD, MOVING_FORWARD, STOP
        );
    }

    @Test
    @DisplayName("우승자를 반환한다.")
    void race_winner() {
        List<String> cars = Arrays.asList("pobi", "woni", "jun");
        Racing racing = new Racing(cars);

        assertRandomNumberInRangeTest(
                racing::race,
                MOVING_FORWARD, MOVING_FORWARD, STOP
        );
        List<String> result = racing.winner();
        assertThat(result).containsExactly("pobi", "woni");
    }

}