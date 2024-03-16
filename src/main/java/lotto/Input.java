package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;



public class Input {

    public static int userBuyIn() {
        Scanner sc1 = new Scanner(System.in);
        int money = sc1.nextInt();

        if(money % 1000 != 0) {
            UserHelp.errorUserBuy();
        }

        return money / 1000;
    }

    public static List<Integer> luckyNumberIn() {

        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        String[] strArr = str.split(",");
        List<String> intList = new ArrayList<>(Arrays.asList(strArr));

        List<Integer> luckyNumber = new ArrayList<>();
        for (String s : intList) {
            luckyNumber.add(Integer.parseInt(s));
        }

        if(luckyNumber.size() != 6) {
            UserHelp.errorLuckyNumber_size();
        }
        for (int i = 0; i < 6; ++i) {
            if(luckyNumber.get(i) > 45 || luckyNumber.get(i) < 0) {
                UserHelp.errorLuckyNumber_number();
            }
        }

        return luckyNumber;

    }

    public static int plusNumberIn(List<Integer> luckyNumber) {
        Scanner sc = new Scanner(System.in);
        int plusNumber = sc.nextInt();
        boolean plus = luckyNumber.contains(plusNumber);
        if(plus) {
            UserHelp.errorPlusNumber();
        }

        return plusNumber;
    }


}
