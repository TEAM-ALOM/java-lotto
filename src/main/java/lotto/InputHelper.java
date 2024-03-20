package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class InputHelper {
    private static final Scanner scanner = new Scanner(System.in);


    //정수를 입력받는 메소드
    public static int getIntInput(String prompt){
        System.out.println(prompt);
        int num = scanner.nextInt();
        scanner.nextLine(); //개행 처리
        return num;
    }

    //리스트를 입력받는 메소드
    public static List<Integer> getListInput(String prompt){
        List<Integer> list = new ArrayList<>();
        System.out.println(prompt);
        String line = scanner.nextLine();
        String[] str = line.split(",");
        if(str.length == 6){
            for(int i = 0; i < str.length; i++){
                list.add(Integer.parseInt(str[i]));
            }
            return list;
        }
        throw new IllegalArgumentException("[ERROR]당첨숫자의 개수를 잘못 입력했습니다.");
    }
}
