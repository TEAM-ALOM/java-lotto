package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.*;

public class LottoTicket {
    private final List<Lotto> ticket;

    public LottoTicket(){
        this(List.of());
    }
    public LottoTicket(List<Lotto> ticket) {
        this.ticket = ticket;
    }
    @Override
    public String toString() {
        return ticket.toString();
    }

    public List<List<Integer>> value() {
        return ticket.stream()
                .map(Lotto::value)
                .collect(toList());
    }

    public LottoResult check(Lotto winningNumbers, LottoNumber bonusNumber) {
        return ticket.stream()
                .map(lotto -> lotto.check(winningNumbers, bonusNumber))
                .collect(collectingAndThen(groupingBy(identity(), counting()), LottoResult::new));
    }
}
