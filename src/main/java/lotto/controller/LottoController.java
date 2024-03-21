package lotto.controller;

import lotto.config.BaseException;
import lotto.config.BaseResponseStatus;
import lotto.domain.Member;
import lotto.domain.MyLottoResult;
import lotto.domain.WinningLotto;

public class LottoController {
    public void start(){
        try{
            Member member = setMemberLotto();
            showMyLotto(member);
            WinningLotto winningLotto = setWinningLotto();
            member.setResult(new MyLottoResult());
            member.getResult(winningLotto);

        }catch (BaseException e){
            System.out.println(e.getMessage());
            return;
        }
        System.out.println(BaseResponseStatus.SUCCESS);
    }
    private Member setMemberLotto(){
        Member member = new Member();
        member.setPurchaseAmount();
        member.setCountLotto();
        member.setMyLotto();
        return member;
    }
    private WinningLotto setWinningLotto(){
        WinningLotto winningLotto = new WinningLotto();
        winningLotto.setWinningLotto();
        winningLotto.setBonusNumber();
        return winningLotto;
    }
    private void showMyLotto(Member member){
        //구입한 로또 개수 출력
        member.getCountLotto();
        //구입한 로또 출력
        member.printMyLotto();
    }
}
