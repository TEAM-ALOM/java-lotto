package lotto.view;

public class OutputView {

    public static void printTicketCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public static void printSuccessMessage(String message, int count) {
        System.out.println(message + count + "개");
    }

    public static void printRate(double rate) {
        System.out.println("총 수익률은 " + String.format("%.1f", rate) + "%입니다.");
    }
}
