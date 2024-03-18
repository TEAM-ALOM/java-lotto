
package lotto.service;

import lotto.domain.customer;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoNumber;
import lotto.domain.LottoResult;
import lotto.domain.LottoSeller;
import lotto.domain.LottoTicket;
import lotto.dto.LottoDto;
import lotto.dto.LottoInformationDto;
import lotto.dto.LottoResultDto;

public class LottoService {
    private final LottoSeller lottoSeller;

    public LottoService(LottoSeller lottoSeller) {
        this.lottoSeller = lottoSeller;
    }

    public LottoInformationDto buy(customer customers) {
        customers.buyLottoTicket(lottoSeller);
        LottoTicket lottoTicket = customers.getLottoTicket();
        return new LottoInformationDto(lottoTicket.value());
    }

    public LottoMachine draw(LottoDto lottoDto) {
        return new LottoMachine(
                new Lotto(lottoDto.getWinningNumbers()),
                LottoNumber.valueOf(lottoDto.getBonusNumber())
        );
    }

    public LottoResultDto check(customer customers, LottoMachine lottoMachine) {
        LottoResult result = customers.check(lottoMachine);
        return new LottoResultDto(result.calculateProfitRatio(), result.value());
    }
}
