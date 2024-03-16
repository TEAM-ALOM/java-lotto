package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LottoController {
    public LottoController(){
    }
    private static final int ticketPrice = 1000;
    private static final int percentage = 100;

    private static PlayerLottoAmount playerLottoAmount;
    private static List<Integer> lotto = new ArrayList<>();
    private static List<Lotto> lottoList;
    private static WinResult winResult;

    public void run(){
        try{
            start();
        }catch(IllegalArgumentException e){
            e.printStackTrace();
        }
    }
    public void start(){
        int ticketCnt = inputPlayerAmount();
        OutputView.printTicketCount(ticketCnt);
        lottoList = makeLottoList(ticketCnt);
        winResult = validateBonus();
        lottoResult(lottoList,winResult,ticketCnt);
    }
    public int inputPlayerAmount(){
        playerLottoAmount = new PlayerLottoAmount(InputView.inputPlayerAmount());
        return playerLottoAmount.calcLottoCount();
    }
    public WinResult validateBonus(){
        Lotto lotto = new Lotto(InputView.inputLottoWinningNum());
        List<Integer> winNum = lotto.getLottoNumbers();

        int pick = InputView.inputBonusNumber();
        lotto.validateBonusNumber(winNum,pick);
        winResult = new WinResult(new Lotto(winNum),pick);
        return winResult;
    }
    private static List<Lotto> makeLottoList(int ticketCnt){
        lottoList = new ArrayList<>();
        for (int i = 0; i<ticketCnt;i++){
            lottoList.add(makeLotto());
        }
        return lottoList;
    }
    private static Lotto makeLotto(){
        LottoNumbers lottoNumbers = new LottoNumbers();
        lotto = new ArrayList<>();

        lotto = lottoNumbers.setRandomNumbers();
        System.out.println(lotto);
        return new Lotto(lotto);
    }
    private void lottoResult(List<Lotto> lottoList, WinResult winLotto,int amount){
        Map<Ranking,Integer> result = setResult();
        Ranking rank;

        OutputView.printSuccessResult();
        for(int i= 0;i<lottoList.size();i++){
            rank = winLotto.match(lottoList.get(i));
            result.put(rank,result.get(rank) + 1);
        }
        printResult(result);
        printEarn(result,amount);
    }
    private void printResult(Map<Ranking,Integer> result){
        for (int i = Ranking.values().length -1 ; i>=0 ;i--){
            Ranking.values()[i].printMessage(result.get(Ranking.values()[i]));
        }
    }
    private void printEarn(Map<Ranking,Integer> result ,int lottoAmount){
        double earnRate = 0;
        for (Ranking rank : result.keySet()){
            earnRate = earnRate + ((double) (rank.getWinAmount())/ (lottoAmount * ticketPrice) * (result.get(rank)) * (percentage));
        }
        OutputView.printRevenueRate(earnRate);
    }
    private Map<Ranking,Integer> setResult(){
        Map<Ranking, Integer> result = new LinkedHashMap<>();
        for (Ranking rank : Ranking.values()){
            result.put(rank,0);
        }
        return result;
    }

}
