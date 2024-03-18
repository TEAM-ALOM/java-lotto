package lotto;
import org.kokodak.Randoms;
import org.kokodak.Console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Application {
    public static void main(String[] args) throws IOException {
        String cost;
        int num;
        System.out.println("구입금액을 입력해 주세요.");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        cost= reader.readLine();
        int costValue = Integer.parseInt(cost);
        if (costValue%1000 !=0){
            throw new IllegalArgumentException();
        }
        num = costValue/1000;
        System.out.println(num + "개를 구매했습니다.");





    }
}
