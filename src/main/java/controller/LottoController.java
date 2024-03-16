package controller;

import domain.*;
import view.*;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;




public class LottoController {
    private static final int TICKET_PRICE = 1000;//로또 개당 가격
    private static final int PERCENTAGE = 100;//추후 성공률 계산에 이용

    private static PlayerLottoAmount playerLottoAmount;//금액을 받고 로또를 할 수 있는 금액인지 적합성 검사 후 발행할 로또 개수
    //정해줌
    private static List<Integer> lotto = new ArrayList<>();
    private static List<Lotto> lottoList;//로또들을 발행한 개수 만큼 리스트에 저장
    private static WinningResult winningResult;//당첨 로또 번호 6개와 와 보너스 번호 1개를 가지고 있는 객체, 추후 가지고 있는
    //로또(리스트)들과 당첨 로또 간의 비교를 한 후 Ranking enum 반환 할 예정
    public void run() {
        start();
        return;
    }
    public void start(){
        int ticketCount = inputPlayerAmount();//발행할 로또 개수
        OutputView.printTicketCount(ticketCount);//로또 개수 출략
        lottoList = makeLottoList(ticketCount);//로또 개수 만큼의 리스트 배열 생성
        winningResult = validateBonus();
        lottoResult(lottoList, winningResult, ticketCount);


    }
    public int inputPlayerAmount(){
        playerLottoAmount = new PlayerLottoAmount(InputView.inputPlayerAmount());
        return playerLottoAmount.calculateLottoCount();

    }
    public WinningResult validateBonus(){
        Lotto lotto = new Lotto(InputView.inputLottoWinningNum());
        List<Integer>winningList = lotto.getLottoNumbers();
        int ball = InputView.inputBonusNumber();
        lotto.validateBonusNumber(winningList, ball);


        return  new WinningResult(lotto, ball);

    }


    public List<Lotto>makeLottoList(int ticketCount){
        lottoList = new ArrayList<>();
        for(int i = 0; i < ticketCount; i++){
            lottoList.add(makeLotto());//로또 개수만큼 로또 내부 리스트 생성(6개) 후 해당 로또를 lottoList에 저장함

        }
        return lottoList;//저장 후 결과 값 반환
    }

    private static Lotto makeLotto(){//로또 만드는 과정은 외부에서 접근하지 못하도록(랜덤하게 made) private 접근 제한자 사용
        LottoNumbers lottoNumbers = new LottoNumbers();
        lotto = lottoNumbers.setRandomLottos();//랜덤하게 로또 만들어 리스트 형태로 반환해 lotto에 넘겨줌
        System.out.println(lotto);
        return new Lotto(lotto);
    }

    public void lottoResult(List<Lotto>lottoList, WinningResult winningResult, int ticketCount){
        Map<Ranking, Integer>result = setResult();//map 초기화 작업 진행 key에는 Ranking values() 각각 넣고 value는 0으로 초기화
        Ranking r;

        OutputView.printSuccessResult();
        for(int i = 0; i < lottoList.size(); i++){
            r = winningResult.match(lottoList.get(i));//lottoList에 들어있는 로또 하나씩을 꺼내서 당첨 로또와 유사성 비교 후
            //적절한 Ranking Enum 객체를 반환해주는 역할 수행
            result.put(r, result.get(r) + 1);//헤당 enum 객체와 그 수량을 하나 증가시켜서 map에 put해줌
        }
        printResult(result);//결과를 map으로 출력
        printEarningRate(result, ticketCount);//수익률 계산하는 메서드 수행


    }

    public void printResult(Map<Ranking, Integer> result){
        for(int i = Ranking.values().length -1; i >= 0; i--){//3~6순으로 해야되므로 인덱스 역순으로 출력하게 작성
            Ranking.values()[i].printMessage(result.get(Ranking.values()[i]));//헤당 enum객체의 정보 출력
        }
    }
    public void printEarningRate(Map<Ranking, Integer>result, int ticketCount){
        double percent = 0.0;

        for(Ranking r : result.keySet()){
            percent += ((double)((r.getWinningAmount() * result.get(r))*PERCENTAGE)
                    / (TICKET_PRICE * ticketCount));


        }
        OutputView.printRevenueRate(percent);


    }
    public Map<Ranking, Integer>setResult(){
        Map<Ranking, Integer>result = new LinkedHashMap<>();
        for(Ranking r : Ranking.values()){
            result.put(r, 0);
        }
        return result;

    }

}