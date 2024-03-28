package lotto;

import org.kokodak.Console;
import org.kokodak.Randoms;

import java.lang.reflect.Array;
import java.util.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        //로또 가격
        int lotto_price = 1000;

        //로또 구입 금액 입력
        System.out.println("구입금액을 입력해 주세요.");
        String str = Console.readLine();
        int purchase = 0;
        try {
            purchase = Integer.parseInt(str);
        } catch (Exception e) {
            System.out.println("[ERROR]");
            return;
        }

        if(purchase % lotto_price != 0){
            throw new IllegalArgumentException("[ERROR]");
        }

        //로또 개수
        int lotto_num = purchase / lotto_price;

        //로또 구입
        System.out.println(lotto_num + "개를 구매했습니다.");
        ArrayList<Lotto> myLotto = new ArrayList<>();

        for(int i=0;i<lotto_num;i++){
            List<Integer> ns = Randoms.pickUniqueNumbersInRange(1,45,6);
            Collections.sort(ns);
            Lotto a = new Lotto(ns);
            myLotto.add(a);
        }
        //System.out.println();

        //구입한 로또 출력
        for(Lotto i : myLotto)
            i.printLotto();
        //System.out.println();

        //당첨 번호 입력
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> ns = new ArrayList<>();
        String s = Console.readLine();
        String[] n = s.split(",");
        for(int i=0;i<6;i++){
            ns.add(Integer.parseInt(n[i]));
        }
        Collections.sort(ns);

        //예외처리
        //1미만, 45초과인 경우 예외처리
        if(ns.get(0) < 1 || ns.get(5) > 45){
            System.out.println("[ERROR]");
            throw new IllegalArgumentException("[ERROR]");
        }
        //중복된 번호가 있는 경우 예외 처리
        if(ns.size() != ns.stream().distinct().count()){
            System.out.println("[ERROR]");
            throw new IllegalArgumentException("[ERROR]");
        }

        Lotto winLotto = new Lotto(ns);
        System.out.println();

        //보너스 번호 입력
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonus_number = Integer.parseInt(Console.readLine());

        //예외 처리
        if(bonus_number < 1 || bonus_number > 45){
            System.out.println("[ERROR]");
            throw new IllegalArgumentException("[ERROR]");
        }
        System.out.println();

        //당첨 통계
        System.out.println("당첨 통계");
        System.out.println("---");

        //3 ~ 6개 일치한 개수 저장
        ArrayList<Integer> prize = new ArrayList<>(){{
            for(int i=0;i<8;i++)
                add(0);
        }};

        for(Lotto i : myLotto){
            int idx = i.winCheck(winLotto, bonus_number);
            if(idx<3)
                continue;
            prize.set(idx, prize.get(idx) + 1);
        }

        //통계 출력
        System.out.println(Lotto.accord.THREE.num +
                "개 일치 (" + Lotto.accord.THREE.price +
                ") - " + prize.get(Lotto.accord.THREE.num) + "개");
        System.out.println(Lotto.accord.FOUR.num +
                "개 일치 (" + Lotto.accord.FOUR.price +
                ") - " + prize.get(Lotto.accord.FOUR.num) + "개");
        System.out.println(Lotto.accord.FIVE.num +
                "개 일치 (" + Lotto.accord.FIVE.price +
                ") - " + prize.get(Lotto.accord.FIVE.num) + "개");
        System.out.println(Lotto.accord.FIVEBONUS.num - 1 +
                "개 일치, 보너스 볼 일치 (" + Lotto.accord.FIVEBONUS.price +
                ") - " + prize.get(Lotto.accord.FIVEBONUS.num) + "개");
        System.out.println(Lotto.accord.SIX.num - 1 +
                "개 일치 (" + Lotto.accord.SIX.price +
                ") - " + prize.get(Lotto.accord.SIX.num) + "개");

        //수익률 계산
        int profit = Lotto.getProfit(prize);
        double earning_rate = (double)profit / (double)purchase * 100.0d;
        String str1 = String.format("총 수익률은 %.1f%%입니다.", earning_rate);
        System.out.println(str1);

    }

}
