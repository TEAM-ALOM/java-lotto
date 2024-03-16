package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserInput {    //메소드를 static으로 선언하여 인풋 시 선언 필요 없도록
    //구매 액수 입력
    public static int getMoney(){
        System.out.println("구매 금액을 입력해 주세요");
        try{
            return Integer.parseInt(Console.readLine());    //액수 관련 오류는 Purchase Lotto에서 처리
        } catch(NumberFormatException numberFormatException) {  //입력 관련 오류 처리
            throw new IllegalArgumentException("[ERROR] 숫자가 아닌 값이 입력됐습니다.");
        }
    }

    //당첨 번호 입력

    public static List<Integer> getWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요");
        try {
            return Arrays.stream(Console.readLine().split(","))     // , 단위로 구분
                    .map(Integer::parseInt)         //  각 요소 Integer로
                    .collect(Collectors.toList());  // 리스트로 변환      스트림 사용법 다시 익히기
        } catch (NumberFormatException numberFormatException) {  //입력 관련 오류 처리
            throw new IllegalArgumentException("[ERROR] 숫자가 아닌 값이 입력됐습니다.");
        }
    }
    //보너스 번호 입력

    public static int getBonusNumber() {
            System.out.println("보너스 번호를 입력해 주세요");
            try {
                return Integer.parseInt(Console.readLine());
            } catch(NumberFormatException numberFormatException) {  //입력 관련 오류 처리
                throw new IllegalArgumentException("[ERROR] 숫자가 아닌 값이 입력됐습니다.");
            }
        }
}
