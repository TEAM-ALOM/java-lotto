package lotto.domain;

public class customer {

    private Money amount;
    private LottoTicket lottoticket;

    public customer(Money amount){
        this(amount, new LottoTicket());
    }
    public customer(Money amount, LottoTicket lottoticket){
        this.amount=amount;
        this.lottoticket=lottoticket;
    }

   public void buyLottoTicket(LottoSeller lottoseller){ //고객이 로또티켓을 구입
    lottoticket = lottoseller.sell(amount);

   }

   public LottoTicket getLottoTicket(){

       return lottoticket;
   }

   public LottoResult check(LottoMachine lottoMachine){
       return lottoMachine.check(lottoticket);
   }
}
