package lotto;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Application {

    private static List<Integer> generateLottoNumbers() {
        List<Integer> numbers = new ArrayList<>();
        // 여기에서 각 번호를 랜덤하게 생성하는 코드를 작성하세요.
        // 이 예시에서는 간단하게 1부터 45까지의 랜덤한 번호를 생성합니다.
        for (int i = 0; i < 6; i++) {
            int randomNumber = (int) (Math.random() * 45) + 1; // 1부터 45까지의 랜덤한 숫자 생성
            numbers.add(randomNumber); // 생성된 숫자를 리스트에 추가
        }
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
//        Random rd = new Random();
//        for (int i = 0; i < cnt; i++)
//        {
//            List<Integer> numbers = new ArrayList<>();
//            numbers.add(rd.nextInt(44) + 1);
//            Lotto[i] = new Lotto(numbers); //i번째 로또객체 생성
//            System.out.println("[" + Lotto[i].getNumbers() + "]"); //한줄씩 출력 // 굳이 객체호출하지말고 바로 쓰는편이 낫나 의문
//        }
    }
}
