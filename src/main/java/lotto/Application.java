package lotto;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Scanner sc = new Scanner(System.in);
        int cash = 0;
        while (true) {
            System.out.println("구매금액을 입력해 주세요.");
            cash = sc.nextInt(); //금액입력받음
            if (cash >= 1000)
                break;
            System.out.println("[ERROR] 1000이상의 금액을 입력해야 합니다.");
        }
        int cnt = cash / 1000;
        System.out.println(cnt + "개를 구매하셨습니다");
        Lotto lottoArr[cnt];
        Random rd = new Random();
        for (int i = 0; i < cnt; i++)
        {
            List<Integer> numbers = new ArrayList<>();
            numbers.add(fd.nextInt(44) + 1);
            Lotto[i] = new Lotto(numbers); //i번째 로또객체 생성
            System.out.println("[" + Lotto[i].getNumbers() + "]"); //한줄씩 출력 // 굳이 객체호출하지말고 바로 쓰는편이 낫나 의문
        }
    }
}
