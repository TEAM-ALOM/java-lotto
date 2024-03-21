package lotto;


import java.util.ArrayList;
import java.util.List;
import org.kokodak.Console;

public class InputHelper {

    //정수를 입력받는 메소드
    public static int getIntInput(String prompt) {
        try{
            System.out.println(prompt);
            int num = Integer.parseInt(Console.readLine());
            return num;
        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException("[ERROR]유효한 숫자를 입력해주세요");
        }
    }

    //리스트를 입력받는 메소드
    public static List<Integer> getListInput(String prompt){
        List<Integer> list = new ArrayList<>();
        System.out.println(prompt);
        String line = Console.readLine();
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
