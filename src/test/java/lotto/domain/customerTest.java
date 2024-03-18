package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

@DisplayName("Customer Test") //테스트 이름 지정
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class customerTest {

    @Test
   void buyLottoTickey_고객이_로또를_구매(){
       customer customers = new customer(Money.won(2000));
       customers.buyLottoTicket(new LottoSeller());
       assertThat(customers.getLottoTicket()).isNotNull();
    }

    @Test
    void check_LottoMachine_메소드_호출(){
        customer customers = new customer(Money.won(2000));
        customers.buyLottoTicket(new LottoSeller());

        LottoMachine lottoMachine = mock(LottoMachine.class);
        customers.check(lottoMachine);
    }


}
