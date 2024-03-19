# JAVA - LOTTO

https://github.com/TEAM-ALOM/java-lotto

## 🗂️ Package 구조(MVC)

### **Model**

#### Lotto

- 역할 : 로또의 실질적 데이터
    - [ ] 

#### Lottos

- 역할 : 구매한 로또들의 묶음 실질적 데이터

#### LottoGenerator

- 역할 : Lotto 생성

#### LottosWinningChecker

- 역할 : Lottos의 당첨 계산

#### LottosStatus

- 역할 : Lottos의 당쳠 계산 결과를 담은 실질적 데이터

#### WinningNumbers

- 역할 : 당첨 번호들(하나의 로또 객체)의 실질적 데이터

#### WinningType

- 역할 : 등수 별 당첨 조건 목록의 실질적 데이터

### Controller

#### LottoSystemController

- 역할 : 로또 시스템을 실행

### **View**

#### InputView

- 역할 : 사용자의 입력을 받는다.
    - [ ] 로또 구입 금액 입력
        - [ ] 1000원 단위로 입력
            - [ ] 나누어 떨어지지 않은 경우 예외
    - [ ] 당첨 번호 입력
        - 번호는 쉼표로 구분
    - [ ] 보너스 번호 입력

#### OutputView

- 역할 : 출력한다.
    - [ ] 결과를 출력한다.
        - [ ] 구매 결과를 출력한다.
            - [ ] 구매한 Lottos를 출력
        - [ ] 당첨 통계를 출력한다.
            - [ ] 3개 일치 ~ 6개 일치 별 금액과 당첨 개수를 출력
            - [ ] 수익률 출력
    - [ ] 문구를 출력한다.
        - [ ] 입력 문구를 출력한다.
            - [ ] 구입금액 입력 문구
            - [ ] 당첨 번호 입력 문구
            - [ ] 보너스 번호 입력 문구
        - [ ] 에러 문구를 출력한다.
            - [ ] [ERROR]로 시작해야한다.

### **Validation** (넣을까 고민중)

- 역할 : 각 계층별 조건에 맞는 검증 시행 및 예외 처리

#### ViewValidation

#### ControllerValidation

#### ModelValidation

## Test

