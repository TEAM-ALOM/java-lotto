package lotto;
import controller.LottoController;
import org.kokodak.Randoms;
import org.kokodak.Console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;


public class Application {
    public static void main(String[] args){
        try {
            LottoController lottoController = new LottoController();
            lottoController.start();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }




    }
}
