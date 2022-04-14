# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 구현목록
- [x] 1 ~ 9까지의 서로 다른 숫자를 3개 생성한다.
- [ ] 3자리 숫자를 입력 입력한다.(UI)
- [x] 입력한 숫자가 1 ~ 9 까지의  서로 다른 3자리 숫자가 아니라면 IllegalArgumentException를 던진다.
  - [x] 1 ~ 9까지의 숫자가 아니라면 IllegalArgumentException를 던진다.
  - [x] 서로 다른 숫자가 아니라면 IllegalArgumentException를 던진다.
- [ ] 두가지를 비교해서 결과를 계산한다.
    - [x] 숫자와 위치가 모두 같으면? → 1 Strike
    - [ ] 숫자와 위치 중 하나만 같다면? → 1 Ball
    - [x] 숫자와 위치 모두 다르다면? → Nothing
- [ ] 결과에 따라 다음 프로세스를 진행한다.
    - 결과가 3 Strike라면? → 게임 종료
    - 결과가 3 Strike가 아니라면? → 다시시작
