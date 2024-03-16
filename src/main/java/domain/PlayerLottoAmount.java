package domain;

public class PlayerLottoAmount {
    private static final int Lotto_Min_Amount = 1000;//로또 한개 당 가격
    private final int amount;

    public PlayerLottoAmount(String amount){
        int amountNum = changeToInt(amount);
        validateAmount(amountNum);
        validateNum(amountNum);
        this.amount = amountNum;
    }
    public int changeToInt(String amount){
        return Integer.parseInt(amount);
    }
    public int calculateLottoCount() {//발행할 로또 개수 반환
        return amount / Lotto_Min_Amount;
    }

    public void validateAmount(int amountNum){//1000보다 작으면 로또 못삼(예외 처리)
        if(amountNum < Lotto_Min_Amount){
            throw new IllegalArgumentException();
        }

    }

    public void validateNum(int amountNum){//1000으로 안나누어지면 오류
        if(amountNum % Lotto_Min_Amount != 0){
            throw new IllegalArgumentException();
        }
    }


}
