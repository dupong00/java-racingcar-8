package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OutputVIewTest extends NsTest {
    @Test
    @DisplayName("pobi 2칸 woni 1칸이 출력된다.")
    void race_print_Test() {
        OutputVIew outputVIew = new OutputVIew();

        Map<String, Integer> carStatus = new LinkedHashMap<>();
        carStatus.put("pobi", 2);
        carStatus.put("woni", 1);

        outputVIew.race_print(carStatus);

        String captureOutput = output();
        assertThat(captureOutput).contains("pobi : --");
        assertThat(captureOutput).contains("woni : -");

    }

    @Override
    protected void runMain() {

    }
}