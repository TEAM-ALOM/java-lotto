package lotto;

import java.util.ArrayList;
import java.util.List;

public class Output {

    public static int userBuyOut() {
        System.out.println("구입금액을 입력해 주세요.");

        int count = Input.userBuyIn();
        if(count != -1) {
            System.out.println(" ");
            System.out.println(count +"개를 구매했습니다.");
        }

        return count;
    }

    public static void usernumber(ArrayList<List<Integer>> numbers, int count) {
        int i;
        for(i = 0; i < count; ++i) {
            System.out.println(numbers.get(i));
        }

    }

    public static List<Integer> luckyNumberOut() {
        System.out.println(" ");
        System.out.println("당첨 번호를 입력해 주세요.");

        List<Integer> luckyNumber = new ArrayList<>();
        luckyNumber = Input.luckyNumberIn();

        return luckyNumber;
    }

    public static int plusNumberOut(List<Integer> luckyNumber) {
        System.out.println(" ");
        System.out.println("보너스 번호를 입력해 주세요.");

        return Input.plusNumberIn(luckyNumber);
    }

    public static void luckyResult(int[] win, double avg) {
        System.out.println(" ");
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - "+ win[0] +"개");
        System.out.println("4개 일치 (50,000원) - "+ win[1] +"개");
        System.out.println("5개 일치 (1,500,000원) - "+ win[2] +"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+ win[3] +"개");
        System.out.println("6개 일치 (2,000,000,000원) - "+ win[4] +"개");
        System.out.println("총 수익률은 " + avg + "%입니다.");
    }


}
