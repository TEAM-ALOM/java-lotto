package lotto;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;

    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public void print(){
        System.out.print("[");
        for(int i=0;i<6;i++) {
            System.out.print(numbers.get(i));
            if(i!=5)
                System.out.print(", ");
        }
        System.out.println("]");
    }

    public void sorting(){
        Collections.sort(numbers);
    }

    public void overlapcheck(){
        sorting();
        int a = numbers.get(0);
        for(int i=1;i<numbers.size();i++){
            if(numbers.get(i) == a){
                System.out.println("[ERROR]");
                throw new IllegalArgumentException();
            }
            a=i;
        }
    }


    public int getNum(int i){
        return numbers.get(i);
    }

}
