package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        Scanner scanner = new Scanner(System.in);
        int purchase_num = scanner.nextInt();   //로또 구입 금액
        List<Integer> correctNumber = new ArrayList<>();

        String s = scanner.next();
        String[] n = s.split(",");
        for(int i=0;i<n.length;i++)
            correctNumber.add(Integer.parseInt(n[i]));



    }
}
