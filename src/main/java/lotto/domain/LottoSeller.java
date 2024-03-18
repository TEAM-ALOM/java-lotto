package lotto.domain;

import org.kokodak.Randoms;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;
import static java.util.stream.StreamSupport.stream;

public class LottoSeller {
    public static final Money LOTTO_PRICE = Money.won(1000L);
    private static final String INVALID_AMOUNT_MESSAGE = "로또를 구매할 수 없습니다.";

    public void validate(Money amount){ //받은 금액이 유효한지 확인
        if(!amount.isGreaterEqualthan(LOTTO_PRICE)){ //고객이 가진 돈이 부족할때 에러 메세지
            throw new IllegalStateException(INVALID_AMOUNT_MESSAGE);

            //고객의 돈이 0원일 때 에러 메세지..?

        }
    }

    public LottoTicket sell(Money amount){ //고객에게 돈을 받아 로또를 판매
        validate(amount); //금액 유효 확인
        return generate_LottoTicket(amount.divide(LOTTO_PRICE));
    }

    public LottoTicket generate_LottoTicket(Long Pickcount){ //로또 티켓 생성
        return Stream.generate(this::PickLottoNumber)
                .limit(Pickcount)
                .collect(collectingAndThen(toList(), this::toLottoTicket));

    }

    public List<Integer> PickLottoNumber(){ //로또 번호 생성, 임의의 숫자 생성하고 리스트로 반환
       return Randoms.pickUniqueNumbersInRange(1, 45, 6)
                .stream() //스트림으로 변환
                .sorted() //오름차순 정렬
                .collect(toList()); //리스트로 수집
    }

    public boolean isZeroAfterBuyLotto(Money amount){ //로또 구매 후 0원인지 확인
        return amount.RemainMoney(LOTTO_PRICE).equals(Money.Zero);
    }

    private LottoTicket toLottoTicket(List<List<Integer>> quickPickNumbers) {
        return quickPickNumbers.stream()
                .map(numbers -> new lotto.domain.Lotto(numbers)) // lotto.domain.Lotto 클래스의 생성자 사용
                .collect(Collectors.collectingAndThen(Collectors.toList(), LottoTicket::new));
    }


}
