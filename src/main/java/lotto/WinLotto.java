package lotto;

import java.util.ArrayList;
import java.util.List;

public class WinLotto {
    private Lotto winlotto;
    public int purchase;
    public int bonusnumber;
    public int[] accord = new int[5];
    public enum Result{
        THREE(3,"5,000원"), FOUR(4, "50,000원"),
        FIVE(5, "1,500,000원"), FIVEBONUS(5, "30,000,000원"),
        SIX(6, "2,000,000,000원");

        private final String price;
        private final int n;
        Result(int i, String s) {
            this.n = i;
            this.price = s;
        }

        public int getNumber(){
            return n;
        }
        public String getPrice(){
            return price;
        }

    }

    public WinLotto(List<Integer> ns){
        this.winlotto = new Lotto(ns);
        for(int i=0;i<5;i++)
            this.accord[i] = 0;
    }

    private int checking(MyLotto lotto){
        int cnt = 0;
        boolean bonus = false;

        //일치하는 번호 개수 확인
        for(int i=0;i<6;i++){
            if(lotto.lottos.getNum(i) == winlotto.getNum(i))
                cnt++;
            if(lotto.lottos.getNum(i) == bonusnumber)
                bonus = true;
        }

        if(cnt == 5 && bonus)   //보너스 번호 확인
            cnt++;
        return cnt;
    }
    public void updateaccord(List<MyLotto> lottos){
        for(int i=0;i<lottos.size();i++){
            int cnt = checking(lottos.get(i));
            if(cnt<3)
                continue;
            accord[cnt]++;
        }
    }
    private float getprofit(){
        return (float)(MyLotto.profit / (float)purchase);
    }
    public void printresult(){
        System.out.println(Result.THREE.n + "개 일치 (" + Result.THREE.price + ") - " + accord[0] + "개");
        System.out.println(Result.FOUR.n + "개 일치 (" + Result.FOUR.price + ") - " + accord[0] + "개");
        System.out.println(Result.FIVE.n + "개 일치 (" + Result.FIVE.price + ") - " + accord[0] + "개");
        System.out.println(Result.FIVEBONUS.n + "개 일치 (" + Result.FIVEBONUS.price + ") - " + accord[0] + "개");
        System.out.println(Result.SIX.n + "개 일치 (" + Result.SIX.price + ") - " + accord[0] + "개");

        float f = getprofit();
        System.out.println("총 수익률은 " + f + "%입니다.");

    }

}
