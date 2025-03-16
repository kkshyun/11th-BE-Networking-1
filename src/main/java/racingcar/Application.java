package racingcar;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;

public class Application {
    static Map<String,Integer> map;
    public static String[] getCars() throws IllegalArgumentException {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        // 아무것도 입력하지 않은 경우
        if(input.isEmpty())
            throw new IllegalArgumentException();
        String[] cars = input.split(",",-1);
        for (int i = 0; i < cars.length; i++) {
            // 이름을 5글자 이상 입력한 경우 또는 콤마(,)만 입력한 경우
            if(cars[i].length()>5||cars[i].isEmpty()) {
                throw new IllegalArgumentException();
            }
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

    public static void printWinner(){
        // 가장 많이 전진한 횟수 구하기
        int max = 0;
        for (Map.Entry<String,Integer> element : map.entrySet()) {
            if(max < element.getValue())
                max = element.getValue();
        }
        // 가장 많이 전진한 횟수를 가진 자동차 출력
        boolean first = false;
        for (Map.Entry<String,Integer> element : map.entrySet()) {
            if(element.getValue()==max && first) {
                System.out.print(", "+element.getKey());
            } else if(element.getValue()==max && !first) {
                System.out.print("최종 우승자 : " + element.getKey());
                first = true;
            }
        }
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try{
            // 자동차 이름 입력 받기
            String[] cars;
            cars = getCars();

            // 자동차 이동 횟수 입력 받기
            int moveCount = 0;
            moveCount = getMoveCount();


            // 게임 실행 및 결과 출력
            map = new HashMap<>();
            for (int i = 0; i < cars.length; i++) {
                map.put(cars[i],0);
            }

            System.out.println("\n실행 결과");

            for (int i = 0; i < moveCount; i++) {
                move();
                print();
                System.out.println();
            }

            // 우승자 출력
            printWinner();

        } catch(IllegalArgumentException e) {
            System.out.println("잘못된 값을 입력하였습니다.");
            throw e;
        }
    }
}
