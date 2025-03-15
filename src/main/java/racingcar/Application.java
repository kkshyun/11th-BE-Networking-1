package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static String[] getCars() throws IllegalArgumentException {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] cars = Console.readLine().split(",");
        for (int i = 0; i < cars.length; i++) {
            if(cars[i].length()>5)
                throw new IllegalArgumentException();
        }
        return cars;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try{
            getCars();
        } catch(IllegalArgumentException e) {
            System.out.println("잘못된 값을 입력하였습니다. 이름은 5자 이하만 가능합니다.");
            return;
        }


    }
}
