package lotto;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Application {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            numbers.add(i);
        }

        Collections.shuffle(numbers);
        List<Integer> lotto = numbers.subList(0, 6);
        Collections.sort(lotto);
        System.out.println("당신의 로또 번호는: " + lotto);
    }
}

