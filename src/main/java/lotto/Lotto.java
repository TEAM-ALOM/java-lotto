package lotto;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    Application application = new Application();


    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }



    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }


    public void sortNumbers(){
        Collections.sort(this.numbers);
    }

}
