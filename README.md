<p align="center">
    <img width="200px;" src="https://raw.githubusercontent.com/woowacourse/atdd-subway-admin-frontend/master/images/main_logo.png"/>
</p>
<p align="center">
  <img alt="npm" src="https://img.shields.io/badge/npm-%3E%3D%205.5.0-blue">
  <img alt="node" src="https://img.shields.io/badge/node-%3E%3D%209.3.0-blue">
  <a href="https://edu.nextstep.camp/c/R89PYi5H" alt="nextstep atdd">
    <img alt="Website" src="https://img.shields.io/website?url=https%3A%2F%2Fedu.nextstep.camp%2Fc%2FR89PYi5H">
  </a>
  <img alt="GitHub" src="https://img.shields.io/github/license/next-step/atdd-subway-admin">
</p>

<br>

# 지하철 노선도 미션
[ATDD 강의](https://edu.nextstep.camp/c/R89PYi5H) 실습을 위한 지하철 노선도 애플리케이션

<br>

## 🚀 Getting Started

### Install
#### npm 설치
```
cd frontend
npm install
```
> `frontend` 디렉토리에서 수행해야 합니다.

### Usage
#### webpack server 구동
```
npm run dev
```
#### application 구동
```
./gradlew bootRun
```
<br>

## ✏️ Code Review Process
[텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

<br>

## 🐞 Bug Report

버그를 발견한다면, [Issues](https://github.com/next-step/atdd-subway-admin/issues) 에 등록해주세요 :)

<br>

## 📝 License

This project is [MIT](https://github.com/next-step/atdd-subway-admin/blob/master/LICENSE.md) licensed.

## 인수 테스트 실습
### Todo-list
- [X] 지하철 노선 생성 기능의 인수 테스트 작성하기
    - [X] 지하철 노선 생성 시도 인수 테스트 작성
    - [X] 지하철 노선 생성 확인 인수 테스트 작성
- [X] 지하철 노선 생성 기능 구현하기
- [X] 지하철 목록 조회 기능
  - [X] 지하철 목록 조회 인수 테스트 작성
  - [X] 서비스 레이어 구현(w. 유닛 테스트)
  - [X] 컨트롤러 구현
- [X] 지하철 조회 기능
  - [X] 지하철 조회 인수 테스트 작성
  - [X] 서비스 레이어 구현(w. 유닛 테스트)
  - [X] 컨트롤러 구현
- [X] 지하철 수정 기능
  - [X] 지하철 수정 인수 테스트 작성
  - [X] 서비스 레이어 구현(w. 유닛 테스트)
  - [X] 컨트롤러 구현
- [X] 지하철 삭제 기능
  - [X] 지하철 삭제 인수 테스트 작성
  - [X] 서비스 레이어 구현(w. 유닛 테스트)
  - [X] 컨트롤러 구현
  
## Step1 피드백 반영
- [X] update 기능에서도 도메인을 직접 노출하지 않도록 개선
- [X] 반복되는 인수테스트 과정을 추출한 static 메서드명들을 한글로 바꾸기
  - 이상한 스네이크 케이스로 인한 혼돈 방지 + 불필요한 과거 시제 뉘앙스를 살리기 위한 반복 제거
- [X] PUT API 검증 때 좀 더 안전하게 검증하기 위해 값 변화까지 검증하기

## Step2. 지하철 노선 구간 조회
### 인수 테스트 시나리오
- 이 부분에 시나리오 다시 정리해보고 빠진 부분 없는지 확인하기
- 기능: 새로운 지하철 노선 등록하기
  - [X] 시나리오1: 정상적으로 새로운 지하철 노선 등록
    - given
      - 상행종점역이 등록되어 있다.
      - and 하행종점역이 등록되어 있다.
      - and 등록하려는 노선 이름과 같은 이름으로 등록된 노선이 없다.
    - when
      - 사용자가 필요한 모든 정보를 입력하고 새로운 지하철 노선 등록을 요청한다.
    - then
      - 지하철 노선 등록 성공
      - and 응답으로 상행종점역, 하행종점역의 정보가 보인다.
  - [X] 시나리오2: 존재하지 않는 지하철 역을 상행종점역이나 상행종점역으로 새로운 지하철 노선 등록
    - given
      - 상행종점역, 하행종점역 중 하나가 등록되어 있지 않다.
      - and 등록하려는 노선 이름과 같은 이름으로 등록된 노선이 없다.
    - when
      - 사용자가 필요한 모든 정보를 입력하고 새로운 지하철 노선 등록을 요청한다.
    - then
      - 지하철 노선 등록 실패
  - [X] 시나리오3: 이미 존재하는 지하철 노선명으로 새로운 노선을 등록
    - given
      - 상행종점역이 등록되어 있다.
      - and 하행종점역이 등록되어 있다.
      - and 등록하려는 지하철 노선명과 같은 지하철 노선이 등록되어 있다.
    - when
      - 사용자가 필요한 모든 정보를 입력하고 새로운 지하철 노선 등록을 요청한다.
    - then
      - 지하철 노선 등록 실패
  - [X] 시나리오4: 상행종점역과 하행종점역을 같은 역으로 새로운 지하철 노선 등록
    - given
      - 역이 등록되어 있다.
      - and 등록하려는 노선 이름과 같은 이름으로 등록된 노선이 없다.
    - when
      - 사용자가 상행지하철역과 하행지하철역을 같은 역으로 선택하고 새로운 지하철 노선 등록을 요청한다.
    - then
      - 지하철 노선 등록 실패
  - [X] 시나리오5: 상행종점역과 하행종점역 간의 거리를 0으로 새로운 지하철 노선을 등록
    - given
      - 상행종점역이 등록되어 있다.
      - and 하행종점역이 등록되어 있다.
      - and 등록하려는 지하철 노선명과 같은 지하철 노선이 등록되어 있지 않다.
    - when
      - 사용자가 종점 간 거리를 0인 값으로 새로운 지하철 노선 등록을 요청한다.
    - then
      - 지하철 노선 등록 실패
  - [X] 시나리오6: 사용자가 필수값이 빠진 채로 새로운 지하철 노선을 등록
    - when
      - 사용자가 새로운 지하철 노선의 이름, 색상, 상행종점역, 하행종점역, 종점역 간 거리 중 하나라도 빠진 채로 지하철 노선 등록을 요청한다.
    - then
      - 지하철 노선 등록 실패
  - [ ] 시나리오7: 특정 지하철 노선 조회 시 `구간 순서대로` 역 목록이 보인다.
    - given
      - 지하철 노선 등록되어 있음
      - and 지하철 노선의 역들 모두 등록되어 있음
    - when
      - 사용자가 특정 지하철 노선 정보를 보기 위해 조회 요청
    - then
      - 특정 지하철 노선의 지하철 역 정보가 `구간 순서대로` 보인다.

### Todo-list
- Section
  - Line <-> Station 간 관계는 다대다 매핑 관계이다. (환승역이 존재)
  - 이 다대다 관계를 중간에서 관리해주기 위한 엔티티로써 관리 된다.
  - [X] Section <-> Line N:1 관계를 형성한다.
  - [X] Section <-> Station N:1 관계를 형성한다.
    - [X] Station은 상행역, 하행역이 각각 하나씩 있다.
    - [X] 상행역, 하행역은 같은 역일 수 없다.
  - [X] 해당 Section의 거리를 속성으로 갖는다.
    - [X] Section의 거리는 0일 수 없다.
- 아래 요구사항들은 양방향 연관관계가 필수인지 다시 생각해보고 결정할 것 => 폐기
  - Line
    - [ ] Line <-> Section 1:N 관계를 갖도록 변경
  - Station
    - [ ] Station <-> Section 1:N 관계를 갖도록 변경
- LineService
  - [X] 신규 노선 생성 시 Section도 생성 후 저장
- 인수 테스트
  - [X] 새로운 Line 생성 인수 테스트 작성
    - [X] 상행종점, 하행종점을 입력해야 생성되도록 만든다.
    - [X] 응답으로 등록된 역들의 정보를 반환한다.
- Line, Station 관계 변경(VO Collection을 이용한 느슨한 관계 설정)
  - 변경사유
    - 제이슨과 DM으로 질의응답 중 Line, Station을 중간 오브젝트로 관리할 경우의 문제점에 대해 알게 됨
    - Section의 생성은 Line에 종속적으로 일어나게 되는데, Section을 다루는 과정에서 불필요하게 Line 외 다른 도메인이 섞이게 됨
    - 도메인 로직을 서비스가 아닌 도메인에서 안전하게 처리할 수 있도록 Section 위에 Sections 일급 컬렉션을 만들고 VO로 변경하면 도메인 로직을 숨기 용이함
    - 추가로 Line, Station 간 결합도를 크게 낮출 수 있음
  - [X] Section을 VO 형태로 변경
    - Line 제거
    - Station 객체 의존성 제거 후 단순 ID 값만 보관하도록 변경
  - [X] Sections 일급 컬렉션 추가
    - [X] VO로 다룰 수 있도록 Embedded 타입 설정
  - [X] Line field를 Sections 일급 컬렉션으로 변경
  - [X] Station DIP 레이어 추가
    - Line 도메인에서 Station에 대한 의존도가 있기 때문에 Station의 변경 사항이 Line에 직접적으로 영향을 끼침
    - 이를 방지하기 위한 중간 레이어 구성
  - [X] LineFactory 도메인 서비스 추가
    - 라인 생성 시 Sation 존재 여부에 대한 의존성이 있기 때문에 라인이 정상적으로 생성됐는지 확인이 어렵기 때문에 변경
- [X] 특정 지하철 노선 조회 기능 리팩토링(역 정보들도 보이도록 변경)
  - [X] SafeStationDomainService에서 데이터의 정렬을 보장하도록 기능 구현
  - [X] Sections에서 중복 없이 등록된 역 목록을 받을 수 있도록 기능 구현
- [X] 사용자가 정상적으로 정보를 조회할 수 있도록 DTO에 getter 추가
- [X] SafeStationInfo 도메인이 외부로 직접 노출되지 않도록 DTO 변환 작업 추가
- [X] Line에서 Station 조회 시 Section 순서대로 조회
  - [X] Sections에서 상행종점역을 찾는 기능 추가
  - [X] Sections에서 생항종점역을 기준으로 다음역을 탐색하며 결과를 합치는 기능 추가
- [ ] 구간 역 목록 조회 기능의 인수 조건을 순서 정렬이 제대로 됐는지 확인하도록 변경

## Step2 피드백 반영
- [X] 불필요한 gradle 모듈 제거
- [X] 불필요한 http 테스트 제거
- [X] JPA Auditing의 setter 제거
- [X] JPA ID 구현을 Abstract 클래스로 전환
- [X] 중복되는 Exception 통합
- [X] Station Fixture에서 ID를 인자로 생성가능한 정적 팩토리 메서드 제거
  - 필요한 때 필요한만큼만 생성된 걸 사용하는 걸로
- [X] Line Fixture의 정적 팩토리 메서드도 마찬가지로 제거
