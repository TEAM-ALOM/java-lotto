package lotto;
import java.util.*;

public class Application {
    public static void main(String[] args) {

        try{
            List<Lotto> purchasedLottos = new ArrayList<>();
            int[] result;

            //구입 금액 입력 받은 후 로또 개수 구하기
            int purchaseAmount = InputHelper.getIntInput("구입금액을 입력해 주세요.");
            int numLotto = Lotto.getNumberOfLotto(purchaseAmount);
            System.out.println(numLotto + "개를 구매했습니다.");

            //로또 생성 후 생성한 로또들 출력
            Lotto.generateLotto(purchasedLottos, numLotto);
            Application.printPurchasedLottos(purchasedLottos);

            //당첨번호 입력받기
            List<Integer> winningNumbers = new ArrayList<>(getWinningNumbers());

            //보너스 번호 입력받기
            int bonus = getBonusNumber();
            Lotto.checkWinningNumberBonus(winningNumbers, bonus);


            //로또 비교하기
            result = getResult(purchasedLottos, winningNumbers, bonus);

            //결과 출력하기
            Application.printWinningResults(result, purchaseAmount);

        } catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

    }


    //구매한 로또 목록 출력하는 메소드
    private static void printPurchasedLottos(List<Lotto> purchased){
        for(int i = 0; i<purchased.size(); i++){
            System.out.println(purchased.get(i).getLottoNum());
        }
    }

    //당첨 번호 입력받는 메소드
    private static List<Integer> getWinningNumbers() {
        List<Integer> winningNumbers = new ArrayList<>(InputHelper.getListInput("당첨 번호를 입력해 주세요."));
        Collections.sort(winningNumbers);
        if(!Lotto.checkWinningNumbersRange(winningNumbers)){
            throw new IllegalArgumentException("[ERROR]로또 번호 개수는 6개입니다.");
        }
        if (!Lotto.checkWinningNumbersCount(winningNumbers)) {
            throw new IllegalArgumentException("[ERROR]번호의 범위는 1~45입니다.");
        }
        if(!Lotto.checkWinningNumbersDuplication(winningNumbers)){
            throw new IllegalArgumentException("[ERROR]로또 번호에 중복이 있습니다.");
        }
        return winningNumbers;
    }

    //보너스 번호 입력 받는 메소드
    private static int getBonusNumber(){
        int bonusN = InputHelper.getIntInput("보너스 번호를 입력해 주세요.");
        if(bonusN < 1 || bonusN > 45){
            throw new IllegalArgumentException("[ERROR]번호의 범위는 1~45입니다.");
        }
        return bonusN;
    }

    //구매한 모든 로또에 대해 반복문을 돌면서 당첨 확인한 후 결과를 저장하는 메소드
    private static int[] getResult(List<Lotto> purchased, List<Integer> winningNumbers, int bonus){
        int[] result = {0, 0, 0, 0, 0, 0};
        for(int i = 0; i<purchased.size(); i++){
            int rank = Lotto.checkWinningResults(winningNumbers, purchased.get(i), bonus);
            result[rank] += 1;
        }
        return result;
    }

    //결과 출력하는 메소드
    private static void printWinningResults(int[] result, int purchaseP) {
        double earningRate;
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + result[5] + "개");
        System.out.println("4개 일치 (50,000원) - " + result[4] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + result[3] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + result[2] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + result[1] + "개");
        earningRate = (double)((result[5] * 5 + result[4] * 50 + result[3] * 1500 + result[2] * 30000 + result[1] * 2000000)) / (purchaseP / 1000) * 100;
        System.out.println("총 수익률은 " + earningRate + "%입니다.");
    }
}
