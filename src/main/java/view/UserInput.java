package view;

import domain.LottoRepository;
import domain.WinningLotto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserInput {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static int price = 0;
    public static String WinninglottoNumbers = null;
    public static int bonus_num = 0;
    public static int cnt = 0;
    public static void input() throws IOException {
        LottoRepository lottoRepository = new LottoRepository();

        price = input_price();
        WinninglottoNumbers = input_winninglotto();
        bonus_num = input_bonus();

        makewinninglotto();
    }

    public static int getCountBuyLotto(){
        return price / 1000;
    }

    public static int input_price() throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    public static String input_winninglotto() throws IOException {
        return reader.readLine();
    }

    public static int input_bonus() throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    public static void makewinninglotto() {
        List<Integer> list = Arrays.stream(WinninglottoNumbers.split(","))
                .mapToInt(Integer::parseInt)
                .boxed().collect(Collectors.toList());

        WinningLotto winningLotto = new WinningLotto(list, bonus_num);
    }
}
