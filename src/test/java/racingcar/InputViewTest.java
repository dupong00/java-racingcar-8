package racingcar;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest {

    private InputStream originalIn;

    @BeforeEach
    void setUp() {
        originalIn = System.in;
    }

    @AfterEach
    void tearDown() {
        System.setIn(originalIn);
        Console.close();
    }

    private void setFakeInput(String input) {
        InputStream fakeIn = new ByteArrayInputStream(input.getBytes());
        System.setIn(fakeIn);
    }

    // --- readCarNames 테스트 ---

    @Test
    @DisplayName("readCarNames: 쉼표로 구분된 자동차 이름을 List로 반환한다.")
    void readCarNames_success() {
        // given
        String input = "pobi,woni,jun";
        setFakeInput(input);

        // when
        List<String> names = InputView.readCarNames();

        // then
        assertThat(names).containsExactly("pobi", "woni", "jun");
    }

    @Test
    @DisplayName("readCarNames: 5자 초과하는 이름이 있으면 예외를 발생시킨다.")
    void readCarNames_fail_nameLength() {
        // given
        String input = "pobi,javajigi"; // "javajigi"가 5자 초과
        setFakeInput(input);

        // when & then
        assertThatThrownBy(InputView::readCarNames)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("readCarNames: 이름이 공백이면 예외를 발생시킨다.")
    void readCarNames_fail_nameBlank() {
        // given
        String input = "pobi,,jun"; // 가운데 이름이 비어있음
        setFakeInput(input);

        // when & then
        assertThatThrownBy(InputView::readCarNames)
                .isInstanceOf(IllegalArgumentException.class);
    }
}