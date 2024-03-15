package view;

import org.kokodak.Console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Input {

    public static int inputPurchaseAmount() throws IOException {
        System.out.println("구입금액을 입력해 주세요.");
        try {
            return Integer.parseInt(Console.readLine());
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해야 합니다.");
        }
    }
    public static List<Integer> inputWinnerNumbers(){

        System.out.println("당첨 번호를 입력해 주세요.");
        try {
            String str = Console.readLine();
            return Arrays.stream(str.split(",")).map(ch -> Integer.parseInt(ch)).collect(Collectors.toList());
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해야 합니다.");
        }
    }

    public static int inputBonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
        try {
            return Integer.parseInt(Console.readLine());
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해야 합니다.");
        }
    }



}
