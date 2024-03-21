package lotto;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import org.kokodak.Randoms;

public class Application {

    private static List<Integer> generateLottoNumbers() {
        List<Integer> numbers = new ArrayList<>();
        numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Scanner sc = new Scanner(System.in);
        int cash = 0;
        while (true) {
            System.out.println("구매금액을 입력해 주세요.");
            cash = sc.nextInt(); //금액입력받음
            if (cash >= 1000)
                break;
            System.out.println("[ERROR] 1000이상의 금액을 입력해야 합니다.");
        }
        int cnt = cash / 1000;
        System.out.println(cnt + "개를 구매하셨습니다");
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            List<Integer> numbers = generateLottoNumbers(); // 6개의 랜덤한 번호 생성
            Lotto lotto = new Lotto(numbers); // 생성된 번호로 Lotto 객체 생성
            lottoList.add(lotto); // 리스트에 Lotto 객체 추가
        }

        // 생성된 Lotto 객체들을 사용하거나 출력
        for (int i = 0; i < lottoList.size(); i++) {
            Lotto lotto = lottoList.get(i);
            System.out.println("Lotto " + (i + 1) + " numbers: " + lotto.getNumbers());
        }
    }
}
