package view;

public class OutputView {
    public static void printTicketCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public static void printSuccessResult() {
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    public static void printSuccessMessage(String message, int numberOfMatch) {
        System.out.println(message + numberOfMatch + "개");
    }

    public static void printRevenueRate(double EarningRate) {
        System.out.printf("총 수익률은 %.1f%%입니다.\n", EarningRate);
    }


}
