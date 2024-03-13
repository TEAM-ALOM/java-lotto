package lotto.controller;

import lotto.domain.LottoGame;
import lotto.domain.betting.Betting;
import lotto.domain.number.Lotto;
import lotto.domain.number.LottoMachine;
import lotto.domain.participant.WinningNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        final Betting betting = new Betting(getBetting());
        ArrayList<Lotto> lotto = getLottoNumbers(betting);
        final WinningNumbers winningNumbers =
                new WinningNumbers(getWinningArray(),getBonusNumber());
        final LottoGame lottoGame = startLottoGame(lotto, winningNumbers, betting);

    }
    private String getBetting() {
        return inputView.readMoney();
    }
    private List<Integer> getWinningArray() {
        return inputView.readWinningArray();
    }
    private String getBonusNumber() {
        return inputView.readBonusNumber();
    }

    private ArrayList<Lotto> getLottoNumbers(Betting betting) {
        ArrayList<Lotto> list = new ArrayList<>();
        final int cnt = betting.getTicketNumber();
        for(int i=0; i<cnt; i++){
            list.add(LottoMachine.createNumbers());
        }
        return list;
    }
    private LottoGame startLottoGame(final ArrayList<Lotto> lotto,
                                     final WinningNumbers winningNumbers,
                                             final Betting betting) {
        final LottoGame lottoGame = new LottoGame(lotto, winningNumbers, betting);
        //final LottoResponse lottoResponse = LottoResponse.from(lottoGame);
        //final List<ParticipantResponse> playerResponses = getPlayerResponses(blackJackGame.players());
        //outputView.printDealCards(dealerResponse, playerResponses, INIT_DRAW_COUNT);
        return lottoGame;
    }

}
