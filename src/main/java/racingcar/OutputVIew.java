package racingcar;

import java.util.Map;

public class OutputVIew {

    public static void race_print(Map<String, Integer> carStatus){
        for(String car : carStatus.keySet()){
            System.out.print(car+" : ");
            int count = carStatus.get(car);
            for(int i = 0; i < count; i++){
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }
}
