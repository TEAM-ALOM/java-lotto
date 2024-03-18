package lotto.controller;

import lotto.domain.LottoGenerator;
import lotto.view.OutputView;
import org.kokodak.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LottoController {

    public void lottoStart(){
        int buyMoney;
        int bonusNumber;
        List<Integer> winLottoList;
        List<List<Integer>> lottoNumberList = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        OutputView.printBuyMoney();
        buyMoney = sc.nextInt();

        LottoGenerator lottoGenerator = new LottoGenerator(buyMoney); //로또 생성기


        OutputView.printBuyLotto(buyMoney);
        for (int i=0; i<lottoGenerator.lottoQuantity; i++){
            lottoNumberList.add(lottoGenerator.generateLottos());
        }
        OutputView.printLottoList(lottoNumberList);

        OutputView.printWinLotto();
        winLottoList =Arrays.stream(sc.next().split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        OutputView.printBonus();
        bonusNumber = sc.nextInt();

        OutputView.printResult(lottoNumberList, winLottoList, bonusNumber, buyMoney);

    }
}
