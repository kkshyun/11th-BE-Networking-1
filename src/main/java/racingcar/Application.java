package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;
import java.util.Map;

public class Application {
    static Map<String,Integer> map;
    public static String[] getCars() throws IllegalArgumentException {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] cars = Console.readLine().split(",");
        for (int i = 0; i < cars.length; i++) {
            if(cars[i].length()>5)
                throw new IllegalArgumentException();
        }
        return cars;
    }

    public static int getMoveCount() throws IllegalArgumentException {
        System.out.println("시도할 회수는 몇회인가요?");
        int count = Integer.parseInt(Console.readLine());
        if(count<0)
            throw new IllegalArgumentException();
        return count;
    }

    public static void move(){
        for (Map.Entry<String,Integer> element : map.entrySet()) {
            int num = Randoms.pickNumberInRange(0, 9);
            if(num>=4)
                map.replace(element.getKey(),element.getValue()+1);
        }
    }

    public static void print(){
        for (Map.Entry<String,Integer> element : map.entrySet()) {
            System.out.print(element.getKey()+" : ");
            for (int i = 0; i < element.getValue(); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 자동차 이름 입력 받기
        String[] cars;
        try{
            cars = getCars();
        } catch(IllegalArgumentException e) {
            System.out.println("잘못된 값을 입력하였습니다. 이름은 5자 이하만 가능합니다.");
            return;
        }

        // 자동차 이동 횟수 입력 받기
        int moveCount = 0;
        try{
            moveCount = getMoveCount();
        } catch(IllegalArgumentException e) {
            System.out.println("잘못된 값을 입력하였습니다.");
        }

        map = new HashMap<>();
        for (int i = 0; i < cars.length; i++) {
            map.put(cars[i],0);
        }

        System.out.println("\n실행결과");

        for (int i = 0; i < moveCount; i++) {
            move();
            print();
            System.out.println();
        }
    }
}
