package lotto;
import java.util.*;

public class Application {
    public static void main(String[] args) {

        int purchaseAmount, numLotto;
        List<Lotto> purchasedLottos = new ArrayList<>();

        int[] result = {0, 0, 0, 0, 0, 0};

        purchaseAmount = InputHelper.getIntInput("구입금액을 입력해 주세요.");

        //구매한 로또 개수 구하고 출력
        numLotto = Lotto.getNumberOfLotto(purchaseAmount);
        System.out.println(numLotto + "개를 구매했습니다.");

        //로또 생성
        Lotto.generateLotto(purchasedLottos, numLotto);
        //구매한 로또 출력
        for(int i = 0; i<purchasedLottos.size(); i++){
            System.out.println(purchasedLottos.get(i).getLottoNum());
        }

        //당첨번호 입력받기
        List<Integer> winningNumbers = InputHelper.getListInput("당첨 번호를 입력해 주세요.");
        if(Lotto.isWinningNumberValuable(winningNumbers) == false){
            //보너스 번호 입력받기
            throw new IllegalArgumentException("[ERROR]번호의 범위는 1~45입니다.");
        }
        Collections.sort(winningNumbers);

        //보너스 번호 입력받기
        int bonus = InputHelper.getIntInput("보너스 번호를 입력해 주세요.");
        //보너스 번호 범위 확인
        if(bonus < 1 || bonus > 45){
            throw new IllegalArgumentException("[ERROR]번호의 범위는 1~45입니다.");
        }


        for(int i = 0; i<purchasedLottos.size(); i++){
           int rank = Lotto.checkWinningResults(winningNumbers, purchasedLottos.get(i), bonus);
           result[rank] += 1;
        }

        Lotto.printWinningResults(result, purchaseAmount);

    }
}
