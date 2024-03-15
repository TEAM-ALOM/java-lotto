package lotto;

public class PrintLotto {
    public static void printLotto(int[] stateArray,int n){
        double sum=0;
        sum = stateArray[0]*5000+stateArray[1]*50000+stateArray[2]*1500000+stateArray[3]*30000000+stateArray[4]*2000000000;

        double result = Math.round(sum/n)*100;
        System.out.println("당첨통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - "+stateArray[0]+"개");
        System.out.println("4개 일치 (50,000원) - "+stateArray[1]+"개");
        System.out.println("5개 일치 (1,500,000원) - "+stateArray[2]+"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+stateArray[3]+"개");
        System.out.println("6개 일치 (2,000,000,000원) - "+stateArray[4]+"개");
        System.out.println("총 수익률은" +result +"%입니다.");
    }

}
