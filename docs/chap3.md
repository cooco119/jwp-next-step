# Chap3. 개발 환경 구축 및 웹 서버 실습 요구사항

---

여기는 책에서는 https://github.com/slipp/web-application-server 스켈레톤으로 시작하라고 되어있지만, 직접 웹서버부터 만들어볼 예정

대부분을 참고해서 진행하겠지만, 기본 프레임워크를 만들어보는 경험도 좋을 것 같다.

## How to?

### 기본 구현 (스켈레톤 따라가기)

- [ ] dependency 복사
- [ ] 기본 webserver 구현

    - [x] http request handler
    - [ ] static resource handler
    - [ ] 인메모리 db(?) 구현 - 원래 인메모리로 되어있네요ㅋㅋ

- [ ] 테스트 복사해오기 - http request handler 및 IO Util 관련 테스트
- [ ] 프론트 구현 - 원래는 jquery로 되어있는데, vue로 할까 ㅎㅎ

### 이후 과제

## 기록

### Gradle 사용

- 원래 스켈레톤은 maven을 쓰지만, 나는 내 repo에 계속 구현하고 싶으므로, gradle을 그대로 사용했다.

### Logger 변경

- 기존에는 Logback을 쓴 걸로 보이는데, 요즘 트렌드는 slf4j랑 log4j2를 쓰는 것으로 보임
- 따라서 해당 세팅으로 변경

  - reference : http://dveamer.github.io/java/SLF4J-Log4J2.html
  
