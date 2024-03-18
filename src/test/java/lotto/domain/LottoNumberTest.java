package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.assertThat;

import static lotto.domain.LottoNumber.LOTTO_NUMBER_LOWER_BOUND;
import static lotto.domain.LottoNumber.LOTTO_NUMBER_UPPER_BOUND;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("LottoNumber Test") //테스트 이름 지정
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {LOTTO_NUMBER_LOWER_BOUND,10,20,30,40,LOTTO_NUMBER_UPPER_BOUND})
    void valueOf_범위내의_값을_입력하면_LottoNumber_인스턴스_반환(int number){
        assertThat(LottoNumber.valueOf(number)).isInstanceOf(LottoNumber.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {LOTTO_NUMBER_LOWER_BOUND,10,20,30,40,LOTTO_NUMBER_UPPER_BOUND})
    void valueOf_범위밖의_값을_입력하면_예외_던짐(int number){
        assertThatThrownBy(() -> LottoNumber.valueOf(number))
                .isInstanceOf(IllegalStateException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {LOTTO_NUMBER_LOWER_BOUND,10,20,30,40,LOTTO_NUMBER_UPPER_BOUND})
    void valueOf_로또_번호를_반환(int number){
        LottoNumber lottoNumber = LottoNumber.valueOf(number);
        assertThat(lottoNumber.value()).isEqualTo(number);
    }
}
