package lotto.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class ValidationFilterTest {

    @Test
    @DisplayName("입력이 숫자인지 체크")
    void isNumberTest() {
        Integer number = ValidationFilter.isNumber("1000");
        assertThat(number).isEqualTo(1000);
        assertThatThrownBy(() -> ValidationFilter.isNumber("not-integer"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 숫자가 범위에 해당하는지 체크")
    void isInRangeTest() {
        Integer number1 = 46;
        Integer number2 = 0;
        assertThatThrownBy(() -> ValidationFilter.isInRange(number1))
                .isInstanceOf(IllegalArgumentException.class);
        System.out.println("45 초과 검증");

        assertThatThrownBy(() -> ValidationFilter.isInRange(number2))
                .isInstanceOf(IllegalArgumentException.class);
        System.out.println("1 미만 검증");
    }

    @Test
    @DisplayName("로또 숫자가 6개인지 체크")
    void isSixNumbersTest() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        assertThatThrownBy(() -> ValidationFilter.isSixNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class);

    }
}
