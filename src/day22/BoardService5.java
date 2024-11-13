package day22;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * - BoardService4의 모든 코드를 복사 후 진행
 * - 기존코드 : 가변길이 배열 구현
 * - 수정조건 : 가변길이 배열 대신 ArrayList 컬렉션프레임워크로 수정
 * - 컬렉션(수집) 프레임워크(미리 만들어진 구조) : (데이터) 수집 관련 클래스들
 *      - 여러개의 데이터들을 하나의 객체에서 관리하기 위해서 
 *      ---> 배열은 고정길이라서 가변길이로 구현하는 방법이 복잡하다!
 *      ---> 자바회사에서 배열을 이용한 가변길이의 배열클래스를 이용하여 편리성과 기능을 제공한다. 
 *      - 대표 인터페이스 : List, Set, Map 컬렉션
 *      - ArrayList 클래스
 *          대표 함수
 *          .add(새로운 객체) : 리스트내 지정한 객체 저장
 *          .get(인덱스) : 리스트내 지정한 인덱스에 객체 반환 함수
 *          .size() : 리스트내 저장한 총 객체 수 반환 함수
 *          .remove(인덱스) : 리스트내 지정한 인덱스에 객체 삭제하는 함수
 */
public class BoardService5 {
    public static void main(String[] args) {
        // - 입력 객체
        Scanner scan = new Scanner(System.in);
        // - 컬렉션 프레임워크중 ArrayList 클래스를 이용한 배열타입 대체한다.
        // 배열(고정길이) vs 컬렉션프라임워크(가변길이)

        ArrayList<Board> boardList = new ArrayList<>();
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
                Board board = new Board();
                board.content = content; board.writer = writer; board.pwd = pwd;
                // [3] 컬렉션 프레임워크인 리스트객체에 게시물을 저장
                boardList.add(board);

            }else if(choose == 2 ){
                // 배열 내 존재하는 게시물 모두 출력하기
                for( int i = 0; i < boardList.size()  ; i ++) {
                    System.out.printf("***%d번째 게시물***%n작성자 : %s%n게시글 : %s%n", i+1 ,
                            boardList.get(i).writer,boardList.get(i).content);
                }
            } else if (choose == 3 ){
                System.out.println("시스템 종료");
                break;
            }

        }



    }

}
