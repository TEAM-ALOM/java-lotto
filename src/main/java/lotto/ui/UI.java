package lotto.ui;

import lotto.lotto.LottoAction;

import java.util.List;

public class UI {
    public void printRequestPrice(){
        System.out.println("구입금액을 입력해 주세요.");
    }
    public void printMakeEntireLotto(int buyNumber){
        System.out.println(buyNumber + "개를 구매했습니다.");
    }
    public void printRequestWinNumber(){
        System.out.println("당첨 번호를 입력해주세요.");
    }
    public void printRequestBonusNumber(){
        System.out.println("보너스 번호를 입력해주세요.");
    }
    public void printResult(int[] result,int amount){
        int sum;
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - "+result[0]+"개");
        System.out.println("4개 일치 (50,000원) - "+result[1]+"개");
        System.out.println("5개 일치 (1,500,000원) - "+result[2]+"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+result[3]+"개");
        System.out.println("6개 일치 (2,000,000,000원) - "+result[4]+"개");
        sum = result[0] * 5000 + result[1] * 50000 + result[2] * 1500000 + result[3] * 30000000 +
                result[4] * 2000000000;
        System.out.println("총 수익률은 " + (double) sum / amount * 100 + "%입니다.");}


}
