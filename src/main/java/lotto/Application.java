package lotto;
import java.util.*;

public class Application {
    public static void main(String[] args) {
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
        List<Integer> winningNumbers = getWinningNumbers();

        //보너스 번호 입력받기
        int bonus = getBonusNumber();

        //로또 비교하기
        result = getResult(purchasedLottos, winningNumbers, bonus);

        //결과 출력하기
        Lotto.printWinningResults(result, purchaseAmount);
    }



    private static void printPurchasedLottos(List<Lotto> purchased){
        for(int i = 0; i<purchased.size(); i++){
            System.out.println(purchased.get(i).getLottoNum());
        }
    }
    private static List<Integer> getWinningNumbers() {
        List<Integer> winningNumbers = InputHelper.getListInput("당첨 번호를 입력해 주세요.");
        if (!Lotto.isWinningNumberValuable(winningNumbers)) {
            throw new IllegalArgumentException("[ERROR]번호의 범위는 1~45입니다.");
        }
        Collections.sort(winningNumbers);
        return winningNumbers;
    }

    private static int getBonusNumber(){
        int bonusN = InputHelper.getIntInput("보너스 번호를 입력해 주세요.");
        if(bonusN < 1 || bonusN > 45){
            throw new IllegalArgumentException("[ERROR]번호의 범위는 1~45입니다.");
        }
        return bonusN;
    }

    private static int[] getResult(List<Lotto> purchased, List<Integer> winningNumbers, int bonus){
        int[] result = {0, 0, 0, 0, 0, 0};
        for(int i = 0; i<purchased.size(); i++){
            int rank = Lotto.checkWinningResults(winningNumbers, purchased.get(i), bonus);
            result[rank] += 1;
        }
        return result;
    }
}
