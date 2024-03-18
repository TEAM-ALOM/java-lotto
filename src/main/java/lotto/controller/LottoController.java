package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoResult;
import lotto.domain.customer;
import lotto.dto.BuyAmountDto;
import lotto.dto.LottoDto;
import lotto.dto.LottoInformationDto;
import lotto.dto.LottoResultDto;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.service.LottoService;
import lotto.domain.Money;

public class LottoController {
    private static final InputView inputView = InputView.INSTANCE;
    private static final OutputView outputView = OutputView.INSTANCE;
    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void run() {
        try {
            lotto();
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
        }
    }

    private void lotto(){
       customer customers = buyLotto();
        LottoMachine lottoMachine = draw();
        check(customers, lottoMachine);

    }

    private void check(customer customers, LottoMachine lottoMachine){
        LottoResultDto lottoResultDto = lottoService.check(customers, lottoMachine);
        outputView.printLottoResult(lottoResultDto);
    }

    private LottoMachine draw(){
        LottoDto lottoDto = inputView.inputLottoNumbers();
        return lottoService.draw(lottoDto);
    }

    private customer buyLotto(){
        BuyAmountDto buyAmountDto = inputView.inputBuyAmount();
        customer customers = new customer(Money.won(buyAmountDto.getAmount()));
        LottoInformationDto lottoInformationDto = lottoService.buy(customers);
        outputView.printLottoInformation(lottoInformationDto);
        return customers;
    }
}
