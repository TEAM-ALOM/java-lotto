package lotto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class WinLotto extends Lotto{
    public static int purchase;
    public int bonusnumber;
    private boolean bonus = false;
    public int[] accord = new int[6];
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
        super(ns);
        for(int i=0;i<6;i++)
            this.accord[i] = 0;
    }

    private boolean issame(int a, int b){
        if(a == bonusnumber)
            bonus = true;
        if(a == b)
            return true;
        return false;
    }
    private int checking(MyLotto lotto){
        int cnt = 0;
        //일치하는 번호 개수 확인
        for(int i=0;i<6;i++){
            for(int j=0;j<6;j++){
                if(issame(lotto.getNum(i), this.getNum(j))){
                    cnt++;
                    continue;
                }
            }
        }

        if(cnt == 5 && bonus)   //보너스 번호 확인
            cnt++;
        return cnt;
    }
    public void updateaccord(List<MyLotto> lottos){
        for(int i=0;i<lottos.size();i++){
            int cnt = checking(lottos.get(i));
            if(cnt < 3)
                continue;
            accord[cnt - 3]++;
        }
    }
    private int getMoney(int a){
        if(a==0)
            return 5000;
        if(a==1)
            return 50000;
        if(a==2)
            return 1500000;
        if(a==3)
            return 30000000;
        if(a==4)
            return 2000000000;
        return 0;
    }

    private float getprofit(){
        for(int i=0;i<6;i++){
            if(accord[i]!=0) {
                MyLotto.profit += accord[i] * getMoney(i);
            }
        }
        //return MyLotto.profit;
        return (float)(purchase / (float)MyLotto.profit) * 100.0f;
    }

    public void printresult(){
        System.out.println(Result.THREE.n + "개 일치 (" + Result.THREE.price + ") - " + accord[0] + "개");
        System.out.println(Result.FOUR.n + "개 일치 (" + Result.FOUR.price + ") - " + accord[1] + "개");
        System.out.println(Result.FIVE.n + "개 일치 (" + Result.FIVE.price + ") - " + accord[2] + "개");
        System.out.println(Result.FIVEBONUS.n + "개 일치, 보너스 볼 일치 (" + Result.FIVEBONUS.price + ") - " + accord[3] + "개");
        System.out.println(Result.SIX.n + "개 일치 (" + Result.SIX.price + ") - " + accord[4] + "개");

        String str = String.format("총 수익률은 %.1f%%입니다.", getprofit());
        System.out.println(str);
    }

}
