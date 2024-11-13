package day22;

import java.util.Scanner;

/**
 * 타입 : 데이터 형태를 분류 
 *     대분류 : - 기본타입( byte ,int, short, long, float, double, char, boolean ) 8개
 *             --- > 기본값 : 정수 , 실수 0.0, 논리 false
 *             - 참조타입( []배열, class, 인터페이스, 열거타입 ) 등등 ---> 기본값 : null
 * 클래스 : 멤버변수(필드), 생성자, 메소드(멤버 함수)로 구성된 새로운 타입 만들기
 * 객체 : 하나의 자료(여러개 자료들의 주소값)를 저장하는 메모리 공간 ( JVM 힙 영역 )
 *        클래스 타입으로 생선된 메모리 공간
 * 변수 : 하나의 자료(실제값, 주소값)를 저장하는 메모리 공간 ( JVM 스택영역 )
 *       기본/참조 타입으로 생선된 메모리 공간
 */
public class BoardService3 { // 실행 클래스
    public static void main(String[] args) {
        // - 입력 객체
        Scanner scan = new Scanner(System.in);
        // - Board 객체 100개를 저장할 수 있는 배열 선언 (고정 길이)
        Board[] boardList = new Board[100];
        while (true) {
            System.out.println("1. 글쓰기 2. 글출력 : ");
            int choose = scan.nextInt();
            if(choose == 1){
                // [1] 사용자로부터 저장할 데이터 입력 받음
                scan.nextLine(); // 의미없는 nextLine() 입력
                // 사용자로 부터 저장할 데이터를 입력 받는다.
                System.out.println("내용 : "); String content = scan.nextLine();
                // .next() 문자열(공백X) 입력, .nextLine() 문자열 (공백/띄어쓰기 포함) 입력
                System.out.println("작성자 : "); String writer = scan.next();
                System.out.println("비밀번호 : "); int pwd = scan.nextInt();
                // [2] 배열 내 빈 공간을 찾아서 게시물 작성하기
                for(int i = 0; i <= boardList.length-1; i++) {
                    if(boardList[i] == null ) { // 만약에 i번째 게시물이 비어 있으면
                        Board board = new Board(); // 게시물 객체 생성
                        // 생성된 게시물 객체 내 입력받은 값들을 대입한다.
                        board.content = content; board.writer = writer; board.pwd = pwd;
                        // 배열 내 i번째 위치에 생성한 객체를 저장/대입 한다.
                        boardList[i]= board;
                        break; // 반복문 종료
                    }
                }

            }else if(choose == 2 ){
                // 배열 내 존재하는 게시물 모두 출력하기
                for( int i = 0; i <= boardList.length-1; i ++) {
                    if(boardList[i] != null) { // 게시물이 존재하면
                        System.out.printf("***%d번째 게시물***%n작성자 : %s%n게시글 : %s%n", i+1 ,
                                boardList[i].writer,boardList[i].content);
                    }
                }
            }

        }



    }

}
