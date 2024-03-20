package lotto;

import org.kokodak.Console;
import org.kokodak.Randoms;

import java.sql.SQLOutput;
import java.util.*;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("구입금액을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        int purchase = scanner.nextInt();   //로또 구입 금액

        if(purchase % 10 != 0){
            System.out.println("[ERROR]");
            throw new IllegalArgumentException();
        }

        System.out.println();

        int lottoCount = purchase / 1000;
        System.out.println(lottoCount + "개를 구매했습니다.");

        List<MyLotto> lottos = new ArrayList<>();

        for(int i=0;i<lottoCount;i++)
        {
            List<Integer> ns = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(ns);
            Lotto tmp = new Lotto(ns);
            lottos.add(new MyLotto(tmp));
        }

        for(int i=0;i<lottoCount;i++){
            lottos.get(i).lottos.print();
        }
        System.out.println();

        System.out.println("당첨 번호를 입력해 주세요.");
        String s = Console.readLine();
        String[] n = s.split(",");
        List<Integer> inputwin = new ArrayList<>();
        for(int i=0;i<n.length;i++)
            inputwin.add(Integer.parseInt(n[i]));
        WinLotto win = new WinLotto(inputwin);

        System.out.println();

        System.out.println("보너스 번호를 입력해 주세요.");
        win.bonusnumber = scanner.nextInt();

        win.updateaccord(lottos);
        win.printresult();

    }
}
