package lotto.view;

import static lotto.model.domain.WinningType.MATCHES_FIVE;
import static lotto.model.domain.WinningType.MATCHES_FIVE_WITH_BONUS;
import static lotto.model.domain.WinningType.MATCHES_FOUR;
import static lotto.model.domain.WinningType.MATCHES_SIX;
import static lotto.model.domain.WinningType.MATCHES_THREE;

public enum ViewMessage {
    PURCHASE_AMOUNT_PROMPT("구입금액을 입력해 주세요.\n"),
    MAIN_WINNING_NUMBERS_PROMPT("당첨 번호를 입력해 주세요.\n"),
    BONUS_NUMBER_PROMPT("보너스 번호를 입력해 주세요.\n"),
    LOTTOS_SIZE_PROMPT("%d개를 구매했습니다.\n"),
    WINNING_STATUS_START("당첨 통계\n---"),
    WINNING_STATUS_MAIN(
            MATCHES_THREE.getMessage() + " - %d개\n"
                    + MATCHES_FOUR.getMessage() + " - %d개\n"
                    + MATCHES_FIVE.getMessage() + " - %d개\n"
                    + MATCHES_FIVE_WITH_BONUS.getMessage() + " - %d개\n"
                    + MATCHES_SIX.getMessage() + " - %d개\n"
                    + "총 수익률은 %.1f%%입니다."
    );

    private final String message;

    ViewMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
