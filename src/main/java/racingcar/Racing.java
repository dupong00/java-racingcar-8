package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
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

    public List<String> winner(){
        int maxValue = -1;
        List<String> result = new ArrayList<>();

        for(Map.Entry<String,Integer> entry : carStatus.entrySet()){
            String car = entry.getKey();
            int number = entry.getValue();

            if(number > maxValue){
                maxValue = number;
                result.clear();
                result.add(car);
            }
            else if(number == maxValue){
                result.add(car);
            }
        }
        return result;
    }
}
