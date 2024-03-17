package lotto;

import lotto.util.ExceptionMessage;
import lotto.view.InputView;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputViewTest {
    private InputView inputview= new InputView();
    @DisplayName("금액은 1000원가 아니면 예외가 발생한다. ")
    @Test
    void 천원단위검증(){
        ByteArrayInputStream in = new ByteArrayInputStream("101".getBytes(StandardCharsets.UTF_8));
        System.setIn(in);
        assertThatThrownBy(()-> inputview.readMoney()).
                isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INVALID_MONEY_UNIT.getMessage());
    }

    @DisplayName("0원이면 예외가 발생한다. ")
    @Test
    void 빵원검증(){
        ByteArrayInputStream in = new ByteArrayInputStream("0".getBytes(StandardCharsets.UTF_8));
        System.setIn(in);
        assertThatThrownBy(()-> inputview.readMoney()).
                isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.ZERO_EXCEPTION.getMessage());
    }

    @DisplayName("당첨번호가 정수인지 검증")
    @Test
    void 당첨번호정수검증(){
        ByteArrayInputStream in = new ByteArrayInputStream("1,2,3,4,5,k".getBytes(StandardCharsets.UTF_8));
        System.setIn(in);
        assertThatThrownBy(()-> inputview.readWinningNumbers()).
                isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.NOT_INT.getMessage());
    }

    @DisplayName("당첨번호가 1~45인지 검증")
    @Test
    void 당첨번호범위검증(){
        ByteArrayInputStream in = new ByteArrayInputStream("1,2,3,4,5,800".getBytes(StandardCharsets.UTF_8));
        System.setIn(in);
        assertThatThrownBy(()-> inputview.readWinningNumbers()).
                isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INVALID_LOTTO_NUMBER_RANGE.getMessage());
    }

    @DisplayName("당첨번호가 6개인지 검증")
    @Test
    void 당첨번호개수검증(){
        ByteArrayInputStream in = new ByteArrayInputStream("1,2,3,4,5".getBytes(StandardCharsets.UTF_8));
        System.setIn(in);
        assertThatThrownBy(()-> inputview.readWinningNumbers()).
                isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INVALID_WINNING_SIZE.getMessage());
        in = new ByteArrayInputStream("1,2,3,4,5,6,7".getBytes(StandardCharsets.UTF_8));
        System.setIn(in);
        assertThatThrownBy(()-> inputview.readWinningNumbers()).
                isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INVALID_WINNING_SIZE.getMessage());
    }
    @DisplayName("당첨번호중에 중복이 있는지 검증")
    @Test
    void 당첨번호중복검증(){
        ByteArrayInputStream in = new ByteArrayInputStream("1,2,3,4,5,5".getBytes(StandardCharsets.UTF_8));
        System.setIn(in);
        assertThatThrownBy(()-> inputview.readWinningNumbers()).
                isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INVALID_WINNING_NUMBER_DUPLICATE.getMessage());
    }
    @DisplayName("보너스번호 정수 검증")
    @Test
    void 보너스번호정수검증(){
        ByteArrayInputStream in = new ByteArrayInputStream("1k".getBytes(StandardCharsets.UTF_8));
        System.setIn(in);

        assertThatThrownBy(()-> inputview.readBonusNumber(List.of(1, 2, 3, 4, 5, 6))).
                isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.NOT_INT.getMessage());
    }
    @DisplayName("보너스번호 중복 검증")
    @Test
    void 보너스번호중복검증(){
        ByteArrayInputStream in = new ByteArrayInputStream("5".getBytes(StandardCharsets.UTF_8));
        System.setIn(in);

        assertThatThrownBy(()-> inputview.readBonusNumber(List.of(1, 2, 3, 4, 5, 6))).
                isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INVALID_BONUS_NUM.getMessage());
    }

    @DisplayName("보너스번호 범위 검증")
    @Test
    void 보너스번호범위검증(){
        ByteArrayInputStream in = new ByteArrayInputStream("51".getBytes(StandardCharsets.UTF_8));
        System.setIn(in);

        assertThatThrownBy(()-> inputview.readBonusNumber(List.of(1, 2, 3, 4, 5, 6))).
                isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INVALID_LOTTO_NUMBER_RANGE.getMessage());
    }



}
