package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoResultDto;
import lotto.domain.WinningLotto;
import lotto.repository.LottoRepository;
import lotto.repository.LottoRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LottoServiceTest {
    private LottoRepository lottoRepository;
    private LottoService lottoService;

    @BeforeEach
    void init() {
        this.lottoRepository = new LottoRepositoryImpl();
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        Lotto lotto = new Lotto(numbers);
        lottoRepository.save(lotto);
        this.lottoService = new LottoServiceImpl(lottoRepository);
    }

    @Test
    void calculateLottosTest() {
        List<Integer> winningNumbers = new ArrayList<>();
        winningNumbers.add(1);
        winningNumbers.add(2);
        winningNumbers.add(3);
        winningNumbers.add(4);
        winningNumbers.add(5);
        winningNumbers.add(6);

        WinningLotto winningLotto = new WinningLotto(winningNumbers, 7);
        LottoResultDto lottoResultDto = lottoService.calculateLottos(winningLotto, 1000);
        assertThat(lottoResultDto.getFirstCount()).isEqualTo(1);
    }

}