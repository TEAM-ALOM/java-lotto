package lotto.view;

import java.util.ArrayList;
import java.util.List;

public class Parser {
    public static List<Integer> parseByDelimiter(final String input, final String delimiter) {
        String[] tmp=input.split(delimiter);

        final List<Integer> numbers = new ArrayList<>();

        for(String c:tmp){
            numbers.add(Integer.parseInt(c));
        }

        return numbers;
    }

}
