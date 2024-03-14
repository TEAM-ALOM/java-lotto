package lotto;

import org.kokodak.Console;
public class Application {
    public static void main(String[] args) {
        Member member = new Member();
        WinningLotto winningLotto = new WinningLotto();
        int bonusNumber;
        try{
            //구입 금액 입력
            System.out.println("구입 금액 : ");
            member.setPurchaseAmount(Integer.parseInt(Console.readLine()));
            member.setCountLotto();
            member.setMyLotto();

            //구입한 로또 개수 출력
            member.getCountLotto();
            //구입한 로또 출력
            member.getMyLotto();
            //로또번호 당첨 6자리 입력
            System.out.println("당첨 번호를 입력해 주세요.");
            winningLotto.setWinningLotto(Console.readLine());
            //보너스 번호 입력
            System.out.println("보너스 번호를 입력해 주세요.");
            bonusNumber = Integer.parseInt(Console.readLine());
            winningLotto.setBonusNumber(bonusNumber);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
