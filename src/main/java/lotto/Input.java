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
            UserHelp.error();
            return -1;
        }

        return money / 1000;
    }

    public static List<Integer> luckNumberIn() {

        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        String intStr = str.replaceAll(",", "");
        String[] strArr = intStr.split("");
        List<String> intList = new ArrayList<>(Arrays.asList(strArr));

        List<Integer> luckyNumber = new ArrayList<>();
        for (String s : intList) {
            luckyNumber.add(Integer.parseInt(s));
        }

        return luckyNumber;

    }

    public static int plusNumberIn() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }


}
