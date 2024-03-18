package service;

import lotto.domain.*;
import lotto.dto.LottoDto;
import lotto.dto.LottoInformationDto;
import lotto.dto.LottoResultDto;
import lotto.service.LottoService;
import org.junit.jupiter.api.*;

import java.util.List;
import java.util.Map;

import static lotto.domain.Lotto.LOTTO_NUMBERS_SIZE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("LottoService 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class LottoServiceTest {
    private LottoService lottoService;
    @BeforeEach //먼저 실행되어야 함
    void setup(){
        LottoSeller lottoSeller = new LottoSeller();
        lottoService = new LottoService(lottoSeller);
    }

    @Test
    void buy_사용자_입력받고_로또구매_메세지_출력_구매한_로또_정보_반환(){
        Money givenAmount = Money.won(2000);
        customer customers = new customer(givenAmount);
        LottoInformationDto lottoInformation = lottoService.buy(customers);
        assertThat(lottoInformation.getSize()).isEqualTo(2);
        assertThat(lottoInformation.getLottoTicket()).allMatch(lotto->lotto.size()==LOTTO_NUMBERS_SIZE);
    }

    @Test
    void buy_로또_구매_실패(){
        Money givenAmount = Money.won(2001);
        customer customers= new customer(givenAmount);
        assertThatThrownBy(()->lottoService.buy(customers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void draw_올바르지_않은_당첨번호(){
        LottoDto lottoDto = new LottoDto(List.of(2,3,3,4,4,4),5);
        assertThatThrownBy(()->lottoService.draw(lottoDto))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void draw_당첨번호_입력받고_LottoMachine_반환(){
        LottoDto lottoDto = new LottoDto(List.of(1,2,3,4,5,6),7);
        LottoMachine lottoMachine = lottoService.draw(lottoDto);
        assertThat(lottoMachine).isNotNull();
    }

    @Test
    void check_고객이_로또_구입하지_않은경우_빈_LottoResultDto_반환(){
        customer customers = new customer(Money.won(2000));
        LottoMachine lottoMachine = new LottoMachine(new Lotto(List.of(1,2,3,4,5,6)), LottoNumber.valueOf(7));
        LottoResultDto result = lottoService.check(customers, lottoMachine);
        assertThat(result.getPrizeCount()).isEqualTo(Map.of());
        assertThat(result.getProfitRatio()).isEqualTo(0.0);
    }

    @Test
    void check_고객과_LottoMachine_입력받아_LottoResultDto_반환(){
        customer customers = new customer(Money.won(2000));
        customers.buyLottoTicket(new LottoSeller());
        LottoMachine lottoMachine = new LottoMachine(new Lotto(List.of(1, 2, 3, 4, 5, 6)), LottoNumber.valueOf(7));
        assertThat(lottoService.check(customers, lottoMachine)).isInstanceOf(LottoResultDto.class);
    }

}
