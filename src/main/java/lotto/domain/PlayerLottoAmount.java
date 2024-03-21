package lotto.domain;
import lotto.view.ExceptionMessage;

public class PlayerLottoAmount {
    private static final int lottoPrice = 1000;
    private final int coin;
    public  PlayerLottoAmount(String coin){
        int coinNum = validateNumber(coin);
        validateCoin(coinNum);
        this.coin = coinNum;
    }
    public int calcLottoCount(){
        return coin / lottoPrice;
    }
    private void validateCoin(int coin){
        validateNatural(coin);
        validateDivisible(coin);
    }
    private static int validateNumber(String coin) throws IllegalArgumentException{
        try{
            return Integer.parseInt(coin);
        } catch (NumberFormatException e){
            ExceptionMessage.numberException();
            throw new IllegalArgumentException();
        }
    }
    private void validateNatural(int coin){
        if (coin <= 0) {
            ExceptionMessage.naturalException();
            throw new IllegalArgumentException();
        }
    }
    private void validateDivisible(int coin){
        if (coin % lottoPrice != 0){
            ExceptionMessage.divisibleException();
            throw new IllegalArgumentException();
        }
    }
}