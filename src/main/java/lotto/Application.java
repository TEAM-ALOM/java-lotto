package lotto;

import domain.WinningLotto;
import service.LottoService;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        // TODO: 프로그램 구현
        LottoService.run();
    }
}
