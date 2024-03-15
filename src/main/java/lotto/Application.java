package lotto;

import org.kokodak.Randoms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) throws IOException {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("구입금액을 입력해 주세요.");
        // 구입금액
        String str = Console.readLine();
        int purchasePrice = Integer.parseInt(str);
        if (purchasePrice % 1000 != 0)
        {
            System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }

        // 몇개 샀는지
        int purchaseCnt = purchasePrice/1000;
        System.out.println(purchaseCnt + "개를 구매했습니다.");

        // 로또 번호 랜덤 생성
        List<List<Integer>> purchasedLottoNum = new ArrayList<>();
        for (int i=0; i<purchaseCnt; i++)
        {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            purchasedLottoNum.add(numbers);
            System.out.println(numbers);
        }

        // 당첨 번호 입력
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] str2 = new String[6];
        str2 = Console.readLine().split(",");

        List<Integer> userSelectedNum = new ArrayList<>();
        for (int i = 0; i < str2.length; i++)
        {
            userSelectedNum.add(Integer.parseInt(str2[i]));
        }

        // 보너스 숫자
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusStr = Console.readLine();
        int bonusNum = Integer.parseInt(bonusStr);

        // 몇개 맞았는지
        int[] correctCnt = new int[]{0, 0, 0, 0};
        int bonusCnt = 0;

        for (List<Integer> lottoNumbers : purchasedLottoNum)
        {
            int cnt = 0;
            for (int j : userSelectedNum)
            {
                //
                if (lottoNumbers.contains(j)) cnt++;
            }

            if (cnt == 5 && lottoNumbers.contains(bonusNum))
            {
                bonusCnt++;
            }
            else if(cnt>=3)
            {
                correctCnt[cnt-3]++;
            }
        }

        // 당첨 결과 출력
        int[] priceArr = new int[]{5000, 50000, 1500000, 2000000000};
        System.out.println("당첨 통계");
        System.out.println("---");

        double earnMoney = 0;  // 번 돈
        for (int i=0; i<correctCnt.length; i++)
        {
            System.out.println((3+i)+"개 일치 "+"("+priceArr[i]+") - "+correctCnt[i]+"개");
            earnMoney += priceArr[i] * correctCnt[i];
            if(i+3==5) // 5개 일치시
            {
                System.out.println((3+i)+"개 일치, 보너스 볼 일치 (" + +priceArr[i]*20 + ") - "+ bonusCnt+"개");
                earnMoney += (priceArr[i]*20) * bonusCnt;
            }
        }

        // 수익률
        double profitRate = earnMoney/purchasePrice;
        DecimalFormat df = new DecimalFormat("#.#");
        String profitRateForPrint = df.format(profitRate);
        System.out.println("총 수익률은 "+ profitRateForPrint + "%입니다.");
    }
}
