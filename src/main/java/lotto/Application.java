package lotto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Application {
    public static void main(String[] args) throws IOException {
        // TODO: 프로그램 구현

        int lotto_price = 1000;

        Scanner scanner = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 로또 구입 금액 입력
        //System.out.println("로또 구입 금액을 입력해주세요.");
        System.out.println("Please enter the amount of lotto purchase.");

        // int money = scanner.nextInt();
        int money = Integer.parseInt(br.readLine());

        if (money % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] This is not an appropriate value. Please check the amount again.");
        }

        List<Integer> numbers = new ArrayList<>();

        // 당첨 번호 입력
        System.out.println("Please enter winning number.");

        String str = br.readLine();
        List<String> list = Arrays.asList(str.split(","));

        if (list.size() > 6){
            throw new IllegalArgumentException("[ERROR] There are too many winning numbers.");
        }

        for (String s : list){
            numbers.add(Integer.parseInt(s));
        }

        // 보너스 번호 입력
        System.out.println("Please enter bonus number.");
        str = br.readLine();
        numbers.add(Integer.parseInt(str));

        //System.out.println(numbers);
    }
}
