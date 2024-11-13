package day22;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * - BoardService5의 모든 코드를 복사 후 진행
 * - 추가조건 : NewBoard클래스 객체들을 캡슐화(접근제어자) 하시오
 *      1. NewBoard는 앞전 Board 와 동일하게 선언
 *      2. NewBoard의 모든 필드(멤버 변수)는 private로 선언
 *      3. 외부에서 객체생성시 생성자를 사용한다.
 *      4. getter and setter 사용 toString 사용
 *   public : 공개용, 모든 클래스/ 패키지 내에서 접근 가능
 *   private : 비공개용, 현재 클래스 내에서 접근 가능
 *      - 이유 : 객체의 자료는 중요하기 때문에 쉽게 저장/변경 하면 x (유효성검사 1. 원하는 데이터인지 , 2. 안전한 데이터인지)
 *      - 객체를 통해 필드 직접 접근을 차단하고 간접접근을 이용한 유효성 검사를 시행한다.
 *   protected : 동일한 패키지 내에서 접근 가능, 상속을 통해 다른 패키지에서 접근 가능
 *   (default) : 동일한 패키지 내에서 접근 가능, 위에 3가지를 작성 안헀을때 기본적으로 저용되는 접근 제어자
 */
public class BoardService6 {
    public static void main(String[] args) {
        // - 입력 객체
        Scanner scan = new Scanner(System.in);
        // - 컬렉션 프레임워크중 ArrayList 클래스를 이용한 배열타입 대체한다.
        // 배열(고정길이) vs 컬렉션프라임워크(가변길이)

        ArrayList<NewBoard> boardList = new ArrayList<>();
            // ArrayList<제네릭 타입> : 리스트 객체에 저장할 여러개 객체들의 타입
        // 현제 게시물 수를 저장하는 변수
        while (true) {
            System.out.println("1. 글쓰기 2. 글출력 3. 종료 : ");
            int choose = scan.nextInt();
            if(choose == 1){
                // [1] 사용자로부터 저장할 데이터 입력 받음
                scan.nextLine(); // 의미없는 nextLine() 입력
                // 사용자로 부터 저장할 데이터를 입력 받는다.
                System.out.println("내용 : "); String content = scan.nextLine();
                // .next() 문자열(공백X) 입력, .nextLine() 문자열 (공백/띄어쓰기 포함) 입력
                System.out.println("작성자 : "); String writer = scan.next();
                System.out.println("비밀번호 : "); int pwd = scan.nextInt();
                // 새로운 배열내 마지막 인덱스에 입력받은 게시물 객체 등록
                // [2] 입력받은 데이터로 게시물 객체 생성
                NewBoard newboard = new NewBoard(writer,pwd,content);

                // [3] 컬렉션 프레임워크인 리스트객체에 게시물을 저장
                boardList.add(newboard);

            }else if(choose == 2 ){
                // 배열 내 존재하는 게시물 모두 출력하기
                for( int i = 0; i < boardList.size()  ; i ++) {
                    System.out.println(boardList.get(i));
                }
            } else if (choose == 3 ){
                System.out.println("시스템 종료");
                break;
            }

        }



    }

}
