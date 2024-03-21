# JAVA - LOTTO

https://github.com/TEAM-ALOM/java-lotto

## 🗂️ Package 구조(MVC)

### **Model**

#### LottoUser

- 역할 : (int)`money`, `Lottos`과 `LottosWinningStatus`를 가지고 있는 객체

#### Lotto

- 역할 : 로또의 실질적 데이터

#### Lottos

- 역할 : 구매한 `Lotto`들의 묶음(`List`) 실질적 데이터

#### LottoGenerator

- 역할 : `LottoUser.money`에 따라 `Lotto`들을 생성

#### LottosWinningChecker

- 역할 : `Lottos`의 당첨 계산 후 `LottosWinningStatus` 생성

#### LottosWinningStatus

- 역할 : `WinningNumbers`,`WinningType`를 바탕으로 `Lottos`의 당쳠 계산 `LottoWinningChecker` 결과를 담은 실질적 데이터

#### WinningNumbers

- 역할 : 보너스 번호와 당첨 번호들(하나의 로또 객체)의 실질적 데이터

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

- 역할 : 사용자 입출력에 관한 검증
    - [ ] InputView
        - [ ] 로또 구입 금액
            - [ ] 숫자인가?
        - [ ] 당첨 번호 입력
            - [ ] 쉼표로 구분이 되었나
            - [ ] 쉼표로 시작하는가
            - [ ] 쉼표로 끝나는가
        - [ ] 보너스 번호
            -  [ ] 숫자 인가
    - [ ] OutputView
        - [ ] 구매 로또 출력
        - [ ] 당첨 통계 출력

#### ControllerValidation

#### ModelValidation

- 역할 : 각 모델 객체에 관한 검증

#### ErrorMessage

- 역할 : 에러 메세지 모음

## Test
