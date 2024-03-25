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

#### OutputView

- 역할 : 입력 문구 및 결과 출력한다.

### **Validation**

#### Validation

#### ErrorMessage

- 역할 : 에러 메세지 모음

## Test
