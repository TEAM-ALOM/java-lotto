package lotto.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
