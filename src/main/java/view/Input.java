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

        int purchaseAmount = Integer.parseInt(Console.readLine());

        return purchaseAmount;
    }



}
