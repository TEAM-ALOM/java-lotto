package lotto.config;

import lotto.controller.LottoController;
import lotto.repository.LottoRepository;
import lotto.repository.LottoRepositoryImpl;
import lotto.service.LottoService;
import lotto.service.LottoServiceImpl;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoConfig {
    private final LottoRepository lottoRepository = lottoRepository();
    private final InputView inputView = inputView();
    private final OutputView outputView = outputView();
    private final LottoService lottoService = lottoService(lottoRepository);
    private final LottoController lottoController = lottoController(inputView, outputView, lottoService);

    public InputView inputView() {
        return new InputView();
    }

    public OutputView outputView() {
        return new OutputView();
    }

    public LottoRepository lottoRepository() {
        return new LottoRepositoryImpl();
    }

    public LottoService lottoService(LottoRepository lottoRepository) {
        return new LottoServiceImpl(lottoRepository);
    }

    public LottoController lottoController(InputView inputView, OutputView outputView, LottoService lottoService) {
        return new LottoController(inputView, outputView, lottoService);
    }

    public LottoRepository getLottoRepository() {
        return lottoRepository;
    }

    public InputView getInputView() {
        return inputView;
    }

    public OutputView getOutputView() {
        return outputView;
    }

    public LottoService getLottoService() {
        return lottoService;
    }

    public LottoController getLottoController() {
        return lottoController;
    }
}
