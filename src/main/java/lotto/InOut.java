package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InOut {
    public InOut(){}

    public List<Integer> InWinningLotto(){
        System.out.println("당첨 로또 번호 : ");
        String[] input = Console.readLine().split(",");
        List<Integer> WinningLotto = new ArrayList<>();
        for(int i=0;i<6;i++){
            WinningLotto.add(Integer.parseInt(input[i]));
        }
        return WinningLotto;
    }
    public Integer InLottoMoney(){
        System.out.println("투입 금액 : ");
        return Integer.parseInt(Console.readLine());
    }
    public Integer InBonusNum(){
        System.out.println("보너스 번호 : ");
        return Integer.parseInt(Console.readLine());
    }

}
