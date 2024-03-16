package lotto.service;

import lotto.constant.LottoConst;
import lotto.domain.Lotto;
import lotto.domain.LottoResultDto;
import lotto.domain.WinningLotto;
import lotto.exception.ExceptionConst;
import lotto.repository.LottoRepository;
import lotto.util.LottoGenerator;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class LottoServiceImpl implements LottoService {
    private final LottoRepository lottoRepository;

    public LottoServiceImpl(LottoRepository lottoRepository) {
        this.lottoRepository = lottoRepository;
    }

    @Override
    public void buyLottos(Integer money) {
        // 1000원 단위로 금액이 들어왔는지 체크
        isRightUnit(money);
        Integer count = money / LottoConst.LOTTO_PRICE.getMoney();
        while (count != 0) {
            List<Integer> numbers = LottoGenerator.generateLotto();
            Collections.sort(numbers);
            Lotto lotto = new Lotto(numbers);
            lottoRepository.save(lotto);
            count--;
        }
    }

    @Override
    public List<Lotto> findAll() {
        List<Lotto> findLottos = lottoRepository.findAll();
        return findLottos;
    }

    /**
     * 구매한 로또들에 대한 결과 계산
     */
    @Override
    public LottoResultDto calculateLottos(WinningLotto winningLotto) {
        LottoResultDto lottoResultDto = new LottoResultDto();
        Map<Integer, Integer> result = lottoResultDto.getResult();
        List<Lotto> findLottos = lottoRepository.findAll();
        for (Lotto findLotto : findLottos) {
            Integer rank = calculateLotto(findLotto, winningLotto);
            if (rank != null) {
                Integer value = result.get(rank);
                result.put(rank, value);
            }
        }
        return lottoResultDto;
    }

    /**
     * 하나의 로또에 대해 맞은 결과 계산
     */
    public Integer calculateLotto(Lotto lotto, WinningLotto winningLotto) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        List<Integer> winningLottoNumbers = winningLotto.getNumbers();
        int count = 0;
        Boolean hasBonus = false;
        for (Integer winningLottoNumber : winningLottoNumbers) {
            if (lottoNumbers.contains(winningLottoNumber))
                count++;
        }
        if (lottoNumbers.contains(winningLotto.getBonusNumber())) {
            hasBonus = true;
            count++;
        }
        return calculateRank(count, hasBonus);
    }

    /**
     * 맞은 결과에 따른 등수 계산
     */
    private Integer calculateRank(int count, Boolean hasBonus) {
        if (!hasBonus && count == 5) {
            return 2;
        }
        if (count == 3) {
            return 5;
        }
        if (count == 4) {
            return 4;
        }
        if (count == 5) {
            return 3;
        }
        if (count == 6) {
            return 1;
        }
        return null;
    }


    private void isRightUnit(Integer money) {
        if (money % LottoConst.LOTTO_PRICE.getMoney() != 0) {
            throw new IllegalArgumentException(ExceptionConst.UNIT_EXCEPTION.getMessage());
        }
    }
}
