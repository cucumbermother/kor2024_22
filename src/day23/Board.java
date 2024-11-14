package day23;
// 클래스 사용처 :
// 1. main함수를 갖는 실행 클래스
// 2. 객체 생성하기 위한 객체 설계 클래스
// 클래스(도면지/ 설계도) vs 객체(설계도 기반 메모리 공간)
public class Board {
    // 클래스 구성멤버
    // 1. 필드 (멤버변수)
        // 필드는 초기값이 없으면 정수 : 0 , 실수 0.0, boolean : false , 참조타입 null 기본값이 들어간다
        // 주의할점 : 일반 지역변수는 초기화 값이 없으면 쓰레기값(임의) 이 들어감.
    private String writer;
    private String content = "a";
    private int pwd;
        // private : 다른 클래스에 접근을 차단하는 키워드, 즉 현재 클래스에서만 사용가능
        // 왜? 웹으로부터 지정한 필드의 직접 접근을 차단하기 위해 (안전하기 쓰기 위해) => 관례적으로 씀
    // 2. 생성자 (객체 초기화 함수) : 객체 생성시 new 뒤로 오는 함수
        // 생성자는 클래스명과 이름이 동일해야한다. 동일하지 않으면 함수로 취급된다.
        // 생성자는 매개변수(함수안으로 들어오는 값을 저장하는 변수)가 있지만 반환타입(함수가 종료될 때 반환하는 값)이 없다.
        // 오버로딩 : 동일한 함수명/생성자명으로 선언은 불가능 하지만 매개변수의 타입, 갯수, 순서에 따라 식별 가능한 함수 선언 방법
    //2-1 매개변수 없는 기본 생성자
    Board() {}
    //2-2 매개변수 1개 존재하는 생성자

    public Board(String content) {
        this.content = content;
    }

    //2-3 매개변수 2개 존재하는 생성자

    public Board(String writer, String content) {
        this.writer = writer;
        this.content = content;
    }

    //2-4 매개변수 3개(전체) 존재하는 생성자

    public Board(String writer, String content, int pwd) {
        this.writer = writer;
        this.content = content;
        this.pwd = pwd;
        // this : 현재 클래스의 필드를 식별할때 사용하는 키워드
        // 함수 내 매개변수(지역변수)와 클래스의 필드명이 충돌(중복) 일때 사용
    }

    // 3. 메소드 (멤버 함수)
        // getter(필드값 호출함수) 함수 : private로 선언된 필드를 public으로 함수로 외부 클래스부터 간접 허용한다.

    public String getWriter() {
        return writer;
    }

    public String getContent() {
        return content;
    }

    public int getPwd() {
        return pwd;
    }

    // setter(필드값 저장함수) 함수 : private로 선언된 필드를 public 함수로 외부 클래스로 부터 간접 접근 허용한다.

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setPwd(int pwd) {
        this.pwd = pwd;
    }
    // toString : Object 객체(자바의 최상위 클래스) 의 메소드
    // 재정의 : Object 클래스 내 toString 함수를 재정의 한다.
    // 원래 toString() 함수는 객체의 주소값을 반환하는 함수인데,
    // 주소값 대신 객체의 필드정보를 출력하기 위해 재정의 한다.
    @Override
    public String toString() {
        return "Board{" +
                "writer='" + writer + '\'' +
                ", content='" + content + '\'' +
                ", pwd=" + pwd +
                '}';
    }
}
