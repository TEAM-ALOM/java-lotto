package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class LottoGeneratorTest {
    // 올바른 단위에 금액인지( 1000단위인지, 양수의 금액인지)
    // 하나의 로또가 잘 생성됐는지 (오름차순, 중복이 없는지)
    // 금액만큼 로또가 잘 생성됐는지


    @ParameterizedTest
    @ValueSource(ints = {1000, 3000, 10000, 240000, 5000000})
    @DisplayName("구매 금액은 1000원 단위로 나눠 떨어져야합니다.")
    void lottoGeneratorSuccessTest1(int money){
        //when
        LottoGenerator lottoGenerator = new LottoGenerator(money);
        int lottoQuantity = lottoGenerator.getLottoQuantity();
        //then
        Assertions.assertThat(lottoQuantity).isPositive();

    }
    @ParameterizedTest // 여러 값은 한 번에 테스트할 수 있게 해줌
    @ValueSource(ints = {-1000, -1500, 0, 2400, 45602})
    @DisplayName("구매 금액은 1000원 단위로 나눠 떨어지지 않거나, 0보다 작거나 같으면 실패합니다.")
    void lottoGeneratorSuccessTest2(int money){
        Assertions.assertThatThrownBy(() -> new LottoGenerator(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");


    }

}