package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Racing {
    private static final int MOVE_STANDARD = 4;
    private Map<String,Integer> carStatus = new LinkedHashMap<>();

    Racing(List<String> cars){
        for(String car : cars){
            carStatus.put(car, 0);
        }
    }

    public void race(){
        for(String car : carStatus.keySet()){
            int number = Randoms.pickNumberInRange(0, 9);
            if(number >= MOVE_STANDARD){
                carStatus.put(car, carStatus.get(car) + 1);
            }
        }
    }

    public  Map<String,Integer> getCarStatus(){
        return carStatus;
    }
}
