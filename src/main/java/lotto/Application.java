package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.util.Random;


public class Application {
    private List<Lotto> lottos = new ArrayList<>();
    private WinningLotto winningLotto;
    private Scanner scanner = new Scanner(System.in);

    public void start() {
        purchaseLottos();
        inputWinningNumbers();
        showResults();
    }

    private void purchaseLottos() {
        System.out.println("구입 금액을 입력해 주세요.");
        int purchaseAmount = Integer.parseInt(scanner.nextLine());
        int lottoCount = purchaseAmount / 1000;
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto(pickUniqueNumbersInRange(1, 45, 6)));
        }
        System.out.println(lottoCount + "개를 구매했습니다.");
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    private List<Integer> pickUniqueNumbersInRange(int start, int end, int count) {
        Random random = new Random();
        Set<Integer> uniqueNumbers = new HashSet<>();

        while (uniqueNumbers.size() < count) {
            int number = start + random.nextInt(end - start + 1);
            uniqueNumbers.add(number);
        }

        return new ArrayList<>(uniqueNumbers);
    }

    private void inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> winningNumbers = new ArrayList<>();
        String[] numbers = scanner.nextLine().split(",");
        for (String number : numbers) {
            winningNumbers.add(Integer.parseInt(number.trim()));
        }

        System.out.println("보너스 볼을 입력해 주세요.");
        int bonusNumber = Integer.parseInt(scanner.nextLine().trim());

        winningLotto = new WinningLotto(new Lotto(winningNumbers), bonusNumber);
    }

    private void showResults() {
        LottoResult lottoResult = new LottoResult();
        for (Lotto lotto : lottos) {
            Rank rank = winningLotto.match(lotto);
            lottoResult.addResult(rank);
        }

        lottoResult.printResult();
        double totalPrize = lottoResult.calculateTotalPrize();
        System.out.printf("총 수익률은 %.2f%%입니다.\n", (totalPrize / (lottos.size() * 1000)) * 100);
    }

    public static void main(String[] args) {
        new Application().start();
    }
}
