package lotto.model.domain;

import static lotto.validation.ErrorMessage.LOTTOS_COUNT_OUT_OF_RANGE_100;
import static lotto.validation.ErrorMessage.LOTTOS_SIZE_NOT_MATCH_COUNT;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class LottosTest {

    private static final int TEST_RIGHT_COUNT = 2;
    private static final int TEST_WRONG_COUNT = 101;
    private static final List<Lotto> RIGHT_LOTTOS = new ArrayList<>();
    private static final List<Lotto> WRING_SIZE_LOTTOS = new ArrayList<>();

    @BeforeAll
    static void set() {
        RIGHT_LOTTOS.add(new Lotto(
                List.of(1, 2, 3, 4, 5, 6)
        ));
        RIGHT_LOTTOS.add(new Lotto(
                List.of(6, 7, 8, 9, 10, 11)
        ));

        WRING_SIZE_LOTTOS.add(new Lotto(
                List.of(1, 2, 3, 4, 5, 6)
        ));
        WRING_SIZE_LOTTOS.add(new Lotto(
                List.of(6, 7, 8, 9, 10, 11)
        ));
        WRING_SIZE_LOTTOS.add(new Lotto(
                List.of(10, 11, 12, 13, 14, 15)
        ));
    }

    @AfterAll
    static void clear() {
        RIGHT_LOTTOS.clear();
        WRING_SIZE_LOTTOS.clear();
    }

    @Test
    void Lottos와_count_정상() {

        new Lottos(
                TEST_RIGHT_COUNT,
                RIGHT_LOTTOS
        );
    }

    @Test
    void count_100_초과_예외발생() {
        Assertions.assertThatThrownBy(() ->
                        new Lottos(
                                TEST_WRONG_COUNT,
                                RIGHT_LOTTOS
                        ))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTOS_COUNT_OUT_OF_RANGE_100.getMessage());
    }

    @Test
    void count와_Lottos_크기_불일치_예외발생() {
        Assertions.assertThatThrownBy(() ->
                        new Lottos(
                                TEST_RIGHT_COUNT,
                                WRING_SIZE_LOTTOS
                        ))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTOS_SIZE_NOT_MATCH_COUNT.getMessage());
    }
}