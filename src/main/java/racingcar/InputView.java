package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {
    private static final int MAX_NAME_LENGTH = 5;

    public static List<String> readCarNames(){
        String input = Console.readLine();

        var names = Arrays.asList(input.split(","));

        validateCarNames(names);

        return names;
    }

    private static void validateCarNames(List<String> names){
        for(String name : names){
            if(name.length() > MAX_NAME_LENGTH){
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
            if (name.isBlank()){
                throw new IllegalArgumentException("자동차 이름은 공백이 불가합니다.");
            }
        }
    }
}
