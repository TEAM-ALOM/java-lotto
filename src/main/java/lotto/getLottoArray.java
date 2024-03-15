package lotto;

import java.util.Arrays;
import java.util.Random;

public class getLottoArray {   //발행한 로또 수량 및 번호 출력하기
    public static int[][] LottoArray(int n){
        int[][] lottoArray = new int[n][6];
        for(int i=0;i<n;i++){
            MakeRandomNumbers(lottoArray[i]);
            Arrays.sort(lottoArray[i]);
        }
        return lottoArray;
    }

    private static void MakeRandomNumbers(int[] array) {
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            array[i] = random.nextInt(45) + 1;
        }
    }

    public static void PrintArray(int[][] array, int cnt){
        for(int i=0; i<cnt; i++){
            System.out.print("[");
            for(int j=0;j<5;j++){
                System.out.print(array[i][j] + ", ");
            }
            System.out.println(array[i][5]+"]");
        }
    }

}
