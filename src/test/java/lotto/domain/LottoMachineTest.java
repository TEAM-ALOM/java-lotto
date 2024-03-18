package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@DisplayName("LottoMachine Test") //테스트 이름 지정
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class LottoMachineTest {
    @Test
    void get_winning_number_and_bonus_number(){
        LottoMachine lottoMachine = new LottoMachine(new Lotto(List.of(1,2,3,4,5,6)), LottoNumber.valueOf(7));
        assertThat(lottoMachine).isInstanceOf(LottoMachine.class);
    }

    @Test
    void check_lottoTicket입력받아_check_메소드_호출(){
        Lotto winningNumbers = new Lotto(List.of(1,2,3,4,5,6));
        LottoNumber bonusNumber = LottoNumber.valueOf(7);
        LottoMachine lottoMachine = new LottoMachine(winningNumbers, bonusNumber);
        LottoTicket lottoTicket = mock(LottoTicket.class);
        lottoMachine.check(lottoTicket);
        verify(lottoTicket, only()).check(winningNumbers, bonusNumber);
    }
}
