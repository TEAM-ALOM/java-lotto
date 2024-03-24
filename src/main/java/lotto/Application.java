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

    private static List<Lotto> getLottoNums(int numOfPurchase) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < numOfPurchase; i++) {
            List<Integer> numbers = generateLottoNumbers(); // 6개의 랜덤한 번호 생성
            Lotto lotto = new Lotto(numbers); // 생성된 번호로 Lotto 객체 생성
            lottoList.add(lotto); // 리스트에 Lotto 객체 추가
        }

        return lottoList;
    }

    public static void printLotto(List<Lotto> lottoList){
        for (int i = 0; i < lottoList.size(); i++) {
            Lotto lotto = lottoList.get(i);
            System.out.println("Lotto " + (i + 1) + " numbers: " + lotto.getNumbers());
        }
    }

    private static String[] winningNumInput(){
        System.out.println("당첨 번호를 입력해 주세요.");
        String str = Console.readLine();
        String[] array = str.split(",");
        return array;
    }

    private static boolean InputValidationCheck(String[] array){
        if (array.length != 6) {
            System.out.println("[ERROR]Invalid number count");
            return false;
        }
        for (String tmp: array) {
            int num = Integer.parseInt(tmp);
            if (num > 45 || num < 1) {
                System.out.println("[ERROR]Invalid Num Arrange");
                return false;
            }
        }
        return true;
    }

    public static List<Integer> getWinningNum(){
        List<Integer> winningNum = new ArrayList<>();
        String[] winningNumStr;
        //올바른 값이 들어오도록 계속 입력받아야한다
        while (true) {
            winningNumStr = winningNumInput();
            if (InputValidationCheck(winningNumStr) == true) {
                break;
            }
        }
        //올바르게 입력받은 당첨 번호들을 나눠야한다
        for (String tmp : winningNumStr) {
            winningNum.add(Integer.parseInt((tmp)));
        }
        return winningNum;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int cash = cashInput(); //금액을 입력받음
        int numOfPurchase = cash / 1000;
        System.out.println(numOfPurchase + "개를 구매하셨습니다");

        //로또 번호를 생성한다
        List<Lotto> lottoList = getLottoNums(numOfPurchase);

        // 생성된 Lotto 객체들을 사용하거나 출력
        printLotto(lottoList);

        //당첨번호 입력받기
        List<Integer> winnigNum = getWinningNum();//new ArrayList<>();
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
