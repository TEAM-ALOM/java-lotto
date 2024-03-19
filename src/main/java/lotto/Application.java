package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        Scanner scanner = new Scanner(System.in);
        int purchase = scanner.nextInt();   //로또 구입 금액
        List<Integer> winNumber = new ArrayList<>();

        String s = scanner.next();
        String[] n = s.split(",");
        for(int i=0;i<n.length;i++)
            winNumber.add(Integer.parseInt(n[i]));

        int bonusNumber = scanner.nextInt();

        int lottos = purchase / 1000;



    }
}
