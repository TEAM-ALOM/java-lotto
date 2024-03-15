package lotto;

public class checkLotto {
    public static int[] MakeResult(int[][] array,int[] lottonum, int cnt) {
        int[] stateArray = new int[5];
        for (int i = 0; i < cnt; i++) {
            if(vsNumber(array[i],lottonum,cnt)!=9)
                stateArray[vsNumber(array[i], lottonum, cnt)]++;
        }
        return stateArray;
    }
    public static int vsNumber(int[] array,int[] lottonum, int cnt){
        int n=0;
        int m=0;  //보너스 볼 불일치
        for(int i=0;i<6;i++){
            for(int j=0;j<7;j++){
                if(array[i] == lottonum[j])
                    n++;
                if(array[i] ==lottonum[6])
                    m=1;  //보너스 볼 일치
            }
        }
        if(n>=3){
            if(n==6&&m==1)
                return 3;
            return n-3;
        }
        return 9;
    }
}
