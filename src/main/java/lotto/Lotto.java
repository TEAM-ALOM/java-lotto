package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Lotto {
    private final List<Integer> numbers;
    private int money;
    private List<Integer> select_numbers = new ArrayList<>();
    private final int[] ranking = new int[8];

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 7) {
            System.out.println("[ERROR] 로또 번호 개수는 7개어야 합니다.");
            throw new IllegalArgumentException();
        }

        for (Integer number : numbers) {
            if (number > 45 || number < 1) {
                System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
                throw new IllegalArgumentException();
            }
        }
    }

    private void getMoney() {
        System.out.println("구입 금액을 입력해 주세요.");
        money = Integer.parseInt(Console.readLine());

        if (money % 1000 != 0) {
            System.out.println("[ERROR] 로또 금액을 잘못 입력하였습니다..");
            throw new IllegalArgumentException();
        }
        System.out.printf("\n%d개를 구매했습니다.\n", money / 1000);
    }

    private void viewNumbers() {
        for (int i = 0; i < money / 1000; i++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 7); // 새로운 로또 번호를 생성
            System.out.println(lottoNumbers);
        }
    }

    private void getSelectNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        select_numbers = Stream.of(Console.readLine().split(",")).map(Integer::parseInt).collect(Collectors.toList());
        System.out.println("\n보너스 번호를 입력해 주세요.");
        select_numbers.add(Integer.parseInt(Console.readLine()));
        validate(select_numbers);
    }

    private void Extract() {
        for (int i = 0; i < money / 1000; i++) {
            checkLottoNumbers(numbers);
        }
    }

    private void checkLottoNumbers(List<Integer> number) {
        int correct_lotto_numbers = 0;
        for (int i = 0; i < number.size(); i++) {
            if (select_numbers.get(i).equals(number.get(i))) {
                correct_lotto_numbers++;
            }
        }
        if (correct_lotto_numbers == 5 && number.contains(select_numbers.get(6))) {
            ranking[0]++; // 2등.
            return;
        }
        ranking[7 - correct_lotto_numbers]++;
    }

    private void lottoResult() {
        System.out.println("당첨 통계\n---");

        System.out.printf("3개 일치 (5,000원) - %d개\n", ranking[4]);
        System.out.printf("4개 일치 (50,000원) - %d개\n", ranking[3]);
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", ranking[2]);
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", ranking[0]);
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", ranking[1]);
        System.out.printf("총 수익률은 %.1f",
                (float) (ranking[4] * 5000 + ranking[3] * 50000 + ranking[2] * 1500000 + ranking[0] * 30000000 + ranking[1] * 2000000000) / money);
        System.out.print("%입니다.");
    }

    void Play() {
        getMoney(); // 구입 금액 입력
        viewNumbers(); // 로또 구매 결과 출력
        getSelectNumbers(); // 당첨 , 보너스 번호 입력
        Extract(); // 로또 번호 추첨
        lottoResult(); // 결과 출력
    }
}
