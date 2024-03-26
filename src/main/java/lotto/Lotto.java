package lotto;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public void sort() {
        Collections.sort(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현

    public enum accord{
        THREE(3, "5,000원"),
        FOUR(4, "50,000원"),
        FIVE(5, "1,500,000원"),
        FIVEBONUS(6, "30,000,000원"),
        SIX(7, "2,000,000,000원");

        public int num;
        public String price;
        accord(int i, String s){
            this.num = i;
            this.price = s;
        }
    }
    //로또 번호 출력
    public void printLotto(){
        System.out.print("[");
        for(int i=0;i<numbers.size();i++){
            System.out.print(numbers.get(i));
            if(i!=numbers.size()-1)
                System.out.print(", ");
        }
        System.out.println("]");
    }

    //로또 당첨 계산
    public int winCheck(Lotto winLotto, int bonusnumber){
        ArrayList<Integer> ns = new ArrayList<>();
        ns.addAll(numbers);

        int  bonus = 0;
        if(ns.contains(bonusnumber))
            bonus = 1;

        ns.retainAll(winLotto.numbers);

        if(ns.size() == 5)
            return ns.size() + bonus;
        if(ns.size() == 6)
            return ns.size() + 1;
        return ns.size();
    }

    public static int getProfit(ArrayList<Integer> prize){
        return prize.get(3) * 5000 + prize.get(4) * 50000 +
                prize.get(5) * 1500000 + prize.get(6) * 30000000 +
                prize.get(7) * 2000000000;
    }

}
