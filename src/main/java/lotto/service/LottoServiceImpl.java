package lotto.service;

import lotto.constant.LottoConst;
import lotto.domain.Lotto;
import lotto.domain.LottoResultDto;
import lotto.domain.WinningLotto;
import lotto.constant.ExceptionConst;
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
    public List<Lotto> buyLottos(Integer money) {
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
        return lottoRepository.findAll();
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
    public LottoResultDto calculateLottos(WinningLotto winningLotto, Integer money) {
        LottoResultDto lottoResultDto = new LottoResultDto();
        Map<Integer, Integer> result = lottoResultDto.getResult();
        List<Lotto> findLottos = lottoRepository.findAll();
        for (Lotto findLotto : findLottos) {
            Integer rank = calculateLotto(findLotto, winningLotto);
            if (rank != null) {
                Integer value = result.get(rank);
                result.put(rank, value + 1);
            }
        }
        calculateRate(lottoResultDto, money);
        return lottoResultDto;
    }

    /**
     * 하나의 로또에 대해 맞은 결과 계산
     */
    @Override
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
    @Override
    public Integer calculateRank(int count, Boolean hasBonus) {
        if (hasBonus && count == 5) {
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

    @Override
    public Double calculateRate(LottoResultDto lottoResultDto, Integer money) {
        Map<Integer, Integer> result = lottoResultDto.getResult();
        Long profit = 0L;
        profit += lottoResultDto.getFifthCount() * LottoConst.FIFTH_PLACE_PRIZE.getMoney();
        profit += lottoResultDto.getFourthCount() * LottoConst.FOURTH_PLACE_PRIZE.getMoney();
        profit += lottoResultDto.getThirdCount() * LottoConst.THIRD_PLACE_PRIZE.getMoney();
        profit += lottoResultDto.getSecondCount() * LottoConst.SECOND_PLACE_PRIZE.getMoney();
        profit += lottoResultDto.getFirstCount() * LottoConst.FIRST_PLACE_PRIZE.getMoney();
        double rate = profit * 100.000 / money;
        lottoResultDto.setRate(rate);
        return lottoResultDto.getRate();
    }

    public void isRightUnit(Integer money) {
        if (money % LottoConst.LOTTO_PRICE.getMoney() != 0) {
            throw new IllegalArgumentException(ExceptionConst.UNIT_EXCEPTION.getMessage());
        }
    }
}
