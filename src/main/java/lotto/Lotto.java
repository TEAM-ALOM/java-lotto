package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);          //String 검증용
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현

    public static ArrayList<List<Integer>> LottoNumber(int count) {

        int i;
        ArrayList<List<Integer>> numberU = new ArrayList<>();

        for (i = 0;i < count; ++i) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            numbers.sort(Comparator.naturalOrder());
            numberU.add(i, numbers);
        }

        return numberU;
    }

    public static int[] LottoWinning(ArrayList<List<Integer>> numberU, List<Integer> luckyNumber, int plusNumber, int count) {
        int[] win = new int[5];
        int i;

        for(i = 0; i < count; ++i) {
            int same = 0, p = 0;
            boolean plus = numberU.get(i).contains(plusNumber);
            if(plus) p = 1;

            numberU.get(i).retainAll(luckyNumber);
            same = numberU.get(i).size();

            if(same == 3) win[0] += 1;
            if(same == 4) win[1] += 1;
            if(same == 5) win[2] += 1;
            if(same == 5 && p == 1) win[3] += 1;
            if(same == 6) win[4] += 1;
        }

        return win;
    }

    public static double LottoReturnRate (int[] win, int count) {
        int sum;
        double avg;

        sum = win[0] * 5000 + win[1] * 50000 + win[2] * 1500000 + win[3] * 30000000 + win[4] * 2000000000;
        avg = sum / (double)count;

        return avg;
    }
}
