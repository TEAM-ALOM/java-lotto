package lotto;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

import org.kokodak.Console;
import org.kokodak.Randoms;
import org.mockito.internal.matchers.Null;

public class Application {

    private static List<Integer> generateLottoNumbers() {
        List<Integer> numbers = new ArrayList<>();
        numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }

    public static int cashInput()
    {
        int cash;
        while (true) {
            System.out.println("구매금액을 입력해 주세요.");
            String input = Console.readLine(); //수정중
//            cash = sc.nextInt(); //금액입력받음 //Console 메소드 사용으로 바꿔야한다
            cash = Integer.parseInt(input);
            if (cash >= 1000)
                return cash;
            System.out.println("[ERROR] 1000이상의 금액을 입력해야 합니다.");
        }
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
       // Scanner sc = new Scanner(System.in);
        int cash = cashInput();
        int numOfPurchase = cash / 1000;
        System.out.println(numOfPurchase + "개를 구매하셨습니다");
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
        System.out.println("당첨 번호를 입력해 주세요.");
        String str = Console.readLine();
        String[] array = str.split(",");
        if (array.length != 6)
        {
            System.out.println("error");
            //error처리 추가
        }
        //숫자 자르기
        List<Integer> winnigNum = new ArrayList<>();
        int i = 0;
        //위닝넘버를 저장한다
        for (int j = 0; j < 6; j++)
        {
            int num = Integer.parseInt(array[i++]);
            if (num > 45 || num < 1) {
                System.out.println("error");
                //error동작
            }
            winnigNum.add(num); //winning num 리스트에 값들을 추가한다
        }
        int bonusNum;
        while (true) {
            System.out.println("보너스 번호를 입력해 주세요.");
            bonusNum = Integer.parseInt(Console.readLine());
            if (bonusNum > 45 || bonusNum < 1) {
                System.out.println("error");
                //error동작
            }
            else {
                break;
            }
        }
        winnigNum.add(bonusNum);
        //7개의 당첨번호로 로또마다 당첨금액을 계산한다
        for (int j = 0; j < numOfPurchase ; j++)
        {
            for (int k = 0; k < 6; k++)
            {

            }
        }
    }
}
