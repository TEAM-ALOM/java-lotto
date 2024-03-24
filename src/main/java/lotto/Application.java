package lotto;
import java.util.*;

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
            int num;
            try {
                num = Integer.parseInt(tmp);
            } catch (NumberFormatException e) {
                System.out.println("[ERROR]Invalid Num Input");
                return false;
                // 변환에 실패한 경우, 문자열에 숫자 이외의 문자가 포함되어 있다.
            }
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

    private static boolean checkNumInWinningNum(List<Integer> winningNum, int number){
        for (int winNum : winningNum) {
            if (number == winNum)
                return true;
        }
        return false;
    }


    private static int matches(List<Integer> winningNum, Lotto lottos, int bonusNum){
        int match = 0;
        int flag = 0;

        for (int number : lottos.getNumbers()){
            if (checkNumInWinningNum(winningNum, number) == true)
                match++;
            if (number == bonusNum)
                flag = 1;
        }
        if (match == 6)
            match = 7;
        if (match == 5 && flag == 1)
            match = 6;
        return match; //몇개가 일치하는지 제공
    }

    public static int printSpecificNumberCounts(List<Integer> numbers, List<Lotto>lottoList) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : numbers) {
            if (num >= 3 && num <= 6) {
                counts.put(num, counts.getOrDefault(num, 0) + 1);
            }
        }
        int sum = 0;
        String[] winnigAmount = {"5,000", "50,000", "1,500,000", "30,000,000", "2,000,000,000"};
        for (int i = 3; i <= 7; i++) {
            if (i == 6)
                System.out.println(i - 1 + "개 일치, 보너스 볼 일치 (" + winnigAmount[i - 3] + "원) - " + counts.getOrDefault(i, 0) + "개");
            else if (i == 7)
                System.out.println(i - 1 + "개 일치 (" + winnigAmount[i - 3] + "원) - " + counts.getOrDefault(i, 0) + "개");
            else
            System.out.println(i + "개 일치 (" + winnigAmount[i - 3] + "원) - " + counts.getOrDefault(i, 0) + "개");
            sum += counts.getOrDefault(i, 0) * Integer.parseInt(winnigAmount[i - 3].replace(",", ""));
        }
        return sum;
    }

    public static void winningStatistics(List<Integer> winningNum, List<Lotto> lottoList, int bonusNum, int numOfPurchase){
        List<Integer> lottoResult = new ArrayList<>();

        for (Lotto lottos : lottoList){
            lottoResult.add(matches(winningNum, lottos, bonusNum));
        }
        //당첨개수를 출력한다
        int sum = printSpecificNumberCounts(lottoResult, lottoList);
        System.out.println("sum : " + sum);
        double rateOfReturn = Math.round(((double)sum / (numOfPurchase * 1000) * 100) * 10.0) / 10.0;
        System.out.println("총 수익률은 " + rateOfReturn + "%입니다.");
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int cash = cashInput(); //금액을 입력받음
        int numOfPurchase = cash / 1000;
        System.out.println(numOfPurchase + "개를 구매했습니다.");

        //로또 번호를 생성한다
        List<Lotto> lottoList = getLottoNums(numOfPurchase);

        // 생성된 Lotto 객체들을 사용하거나 출력
        printLotto(lottoList);

        //당첨번호 입력받기
        List<Integer> winningNum = getWinningNum();
        int bonusNum;
        System.out.println("보너스 번호를 입력해 주세요.");
        bonusNum = Integer.parseInt(Console.readLine());

        //7개의 당첨번호로 로또마다 당첨금액을 계산한다
        winningStatistics(winningNum, lottoList, bonusNum, numOfPurchase);
    }
}
