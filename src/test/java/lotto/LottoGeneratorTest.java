package lotto;

import lotto.domain.LottoGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoGeneratorTest {

    @DisplayName("0원이면 예외가 발생한다.")
    @Test
    void createLottoNumberByZeroSize() {
        assertThatThrownBy(() -> new LottoGenerator(0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1000으로 안나눠지면 예외가 발생한다.")
    @Test
    void createLottoNumberByNotDivide() {
        assertThatThrownBy(() -> new LottoGenerator(525))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("잘 개수가 생성되는가.")
    @Test
    void lottoNumberSize() {
        //give
        final LottoGenerator lottoGenerator = new LottoGenerator(1000);
        //when
        final List<Integer> lottoNumber = lottoGenerator.generateLottos();
        //then
        assertThat(lottoNumber.size()).isEqualTo(6);
    }

    @DisplayName("범위가 올바른지")
    @Test
    void lottoNumberRange(){
        //give
        final LottoGenerator lottoGenerator = new LottoGenerator(1000);
        //when
        final List<Integer> lottoNumber = lottoGenerator.generateLottos();
        //then
        assertThat(lottoNumber.stream().allMatch(v -> v >= 1 && v <= 45)).isTrue();
    }



}