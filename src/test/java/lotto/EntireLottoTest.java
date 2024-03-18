package lotto;

import lotto.lotto.EntireLotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class EntireLottoTest {

    @Test
    void makeLotto() {
        //given
        EntireLotto el = new EntireLotto(6);
        //when
        for(int i=0;i<6;i++){
            el.makeLottos();
        }
        System.out.println(el.isSize(6));
        //then
        Assertions.assertThat(el.isSize(6)).isEqualTo(true);
    }


}