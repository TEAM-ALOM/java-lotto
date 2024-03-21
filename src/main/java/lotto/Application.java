package lotto;

import org.kokodak.Randoms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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

        // 로또 구입 금액이 1000원 단위가 아닐 때 예외 처리
        if (money % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] This is not an appropriate value. Please check the amount again.");
        }

        // 로또 구입 결과 출력
        int lotto_amount = money / 1000;
        System.out.println("Purchased " + lotto_amount + " lotto");

        List<List<Integer>> purchased_lotto = new ArrayList<>();

        for (int i = 0; i < lotto_amount; i++){
            List<Integer> RandomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(RandomNumbers);

            purchased_lotto.add(RandomNumbers);
        }

        for (int i = 0; i < lotto_amount; i++){
            System.out.println(purchased_lotto.get(i));
        }

        // 당첨 번호 입력
        List<Integer> numbers = new ArrayList<>();

        System.out.println("Please enter winning number.");

        String str = br.readLine();
        List<String> list = Arrays.asList(str.split(","));

        // 당첨번호 7개 이상 입력 시 예외 처리
        if (list.size() != 6){
            throw new IllegalArgumentException("[ERROR] There are too many winning numbers.");
        }

        // 당첨번호 중복 입력 시 예외 처리
        Set<String> listSet = new HashSet<>(list);

        if (list.size() != listSet.size()) {
            throw new IllegalArgumentException("[ERROR] There is a duplicate number.");
        }

        // 문자열 리스트 -> 정수형 리스트로 변환
        for (String s : list){
            numbers.add(Integer.parseInt(s));
        }

        // 입력된 당첨번호가 1~45 범위가 아닐 때 예외처리
        for (Integer num : numbers){
            if (num < 1 || num > 45){
                throw new IllegalArgumentException("[ERROR] Invalid value.");
            }
        }

        // 보너스 번호 입력
        System.out.println("Please enter bonus number.");
        str = br.readLine();
        int bonus = Integer.parseInt(str);

        // 보너스 번호 중복 시 예외 처리
        for (int i = 0; i < numbers.size(); i++){
            if (numbers.get(i) == bonus){
                throw new IllegalArgumentException("[ERROR] There is a duplicate number.");
            }
        }

        // 당첨 결과 계산
        int income = 0;
        int[] result = new int[5];
        for (int i = 0; i < 5; i++)
            result[i] = 0;

        for (List<Integer> purchased_list : purchased_lotto){
            List<Integer> matchList = purchased_list.stream().filter(o ->
                    numbers.stream().anyMatch(Predicate.isEqual(o))).toList();

            if (matchList.size() == 6) {
                income += 2000000000;
                result[0]++;

            }
            else if (matchList.size() == 5 && purchased_list.contains(bonus)) {
                income += 30000000;
                result[1]++;
            }
            else if (matchList.size() == 5) {
                income += 1500000;
                result[2]++;
            }
            else if (matchList.size() == 4) {
                income += 50000;
                result[3]++;
            }
            else if (matchList.size() == 3) {
                income += 5000;
                result[4]++;
            }
        }

        // 당첨 결과 출력
        System.out.println("winning statistics");
        System.out.println("---");
        System.out.println("Correct 3 (5,000) - " + result[4]);
        System.out.println("Correct 4 (50,000) - " + result[3]);
        System.out.println("Correct 5 (1,500,000) - " + result[2]);
        System.out.println("Correct 5, Bonus (30,000,000) - " + result[1]);
        System.out.println("Correct 6 (2,000,000,000) - " + result[0]);

        float total_return = (float)income / (float)money * 100.0f;
        System.out.println("Total Return : " + total_return + "%");
    }
}
