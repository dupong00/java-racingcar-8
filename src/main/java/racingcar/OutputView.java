package racingcar;

import java.util.List;
import java.util.Map;

public class OutputView {

    public static void carAnswerPrint(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void countAnswerPrint(){
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public static void resultCharPrint(){
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void racePrint(Map<String, Integer> carStatus){
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

    public static void winnerPrint(List<String> winners){
        String winner = String.join(", ", winners);
        System.out.print("최종 우승자 : " + winner);
    }
}
