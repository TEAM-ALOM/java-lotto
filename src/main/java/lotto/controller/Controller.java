package lotto.controller;

import lotto.Program;

public class Controller {
    Program program;
    public void start() {
        program = new Program();
        program.requestPrice();
        program.makeEntireLotto();
        program.requestWinNumber();
        program.requestBonusNumber();
        program.printResult();

    }
}
