package lotto;

import java.util.*;
import static lotto.PrintLotto.printLotto;
import static lotto.checkLotto.*;
import static lotto.getLottoArray.*;

public class Application {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");
        int n = s.nextInt();   //키보드에서 정수 입력
        while(n%1000 != 0) {
            System.out.println("[ERROR] 구입 금액을 다시 입력하세요.");
            n = s.nextInt();
        }

        int cnt = n/1000;
        System.out.println("\n" + cnt + "개를 구매했습니다.");
        int[][] lottoArray = LottoArray(cnt);
        PrintArray(lottoArray,cnt);

        System.out.println("\n당첨 번호를 입력해 주세요.");
        int[] LottoNumbers = getNumbers();

        System.out.println("\n보너스 번호를 입력해 주세요.");
        int bonus = s.nextInt();
        LottoNumbers[6]=bonus;

        int[] stateArray = MakeResult(lottoArray,LottoNumbers,cnt);
        printLotto(stateArray,n);
    }

    public static int[] getNumbers(){  //당첨 번호 입력 받기
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        String[] numberStrings = str.split(",");

        int[] lottoNumbers = new int[numberStrings.length+1];
        for(int i=0;i<numberStrings.length;i++){
            lottoNumbers[i] = Integer.parseInt(numberStrings[i].trim());
            if(lottoNumbers[i]<1||lottoNumbers[i]>45){
                System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
                break;
            }
        }
        return lottoNumbers;
    }
}
