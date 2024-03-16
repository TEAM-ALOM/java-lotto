package domain;

import java.util.List;

public class Lotto {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);//로또 번호 개수가 6개로 정상적으로 들어왔는지 여부 확인
        validateRange(numbers);//1~45까지의 값이 있나 확인
        this.numbers = numbers;//검사 통과하면 numbers라는 리스트 객체에 저장
    }

    public List<Integer> getLottoNumbers(){//로또 리스트 반환
        return numbers;
    }

    public boolean containNumber(int number){//로또 리스트에 해당 숫자가 있는지 검사할 수 있는 메서드
        return numbers.contains(number);
    }
    public int countMatch(Lotto winningLotto){//winningLotto에 들어있는 로또 리스트 객체와 확인하고자 하는 로또
        //비교 후 같은 정수가 있으면 값을 증가시켜 반환
        return (int)numbers.stream().filter(w -> winningLotto.numbers.contains(w)).count();
    }


    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
    private void validateRange(List<Integer> numbers) {
        for(int i = 0; i < numbers.size(); i++){
            if(numbers.get(i) < MIN_NUMBER || numbers.get(i) > MAX_NUMBER){
                throw new IllegalArgumentException();
            }
        }
    }

    public static void validateBonusNumber(List<Integer> numbers, int bonusNumber) {
        //추후 당첨 로또의 6개의 로또 번호와 1개의 보너스 번호에서 보너스 변호와 로또 번호가 겹치는게 있는지 확인하기 위한 매서드
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }


}

