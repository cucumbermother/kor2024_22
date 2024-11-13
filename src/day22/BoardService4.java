package day22;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * - BoardService3의 모든 코드를 복사 후 진행
 * - 기존코드 : 고정길이 Board[] boardList = new Board[100];
 * - 수정조건 : 고정길이가 아닌 가변길이 형식으로 수정하여 100개가 아닌
 *            무한개 저장 가능한 배열 만들기
 * - 이유 : 가변길이의 여러개 데이터를 관리할때는
 *      - 컬렉션프라임워크(ArrayList) = 실무
 *      - 가변배열 = 시험/ 코테
 */

public class BoardService4 { // 실행 클래스
    public static void main(String[] args) {
        // - 입력 객체
        Scanner scan = new Scanner(System.in);
        // - 가변길이 배열 만들기 예제
        Board[] boardList = null;
        // 현제 게시물 수를 저장하는 변수
        int count = 0;
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
                // 새로운 배열내 마지막 인덱스에 입력받은 게시물 객체 등록
                boardList = new Board[1];
                // [2] 입력받은 데이터로 게시물 객체 생성
                Board board = new Board();
                board.content = content; board.writer = writer; board.pwd = pwd;
                // [3]
                count ++; // 게시물 수 1 증가
                Board[] newBoardList = new Board[count]; // 새로운 배열 생성
                // 기존 배열 내 게시물들을  새로운 배열에 이동하기 // 배열 복사
                if(count != 1) { // 만약에 기존 배열 내 게시물이 존재 하면
                    for(int i = 0; i <= boardList.length-1; i++ ){
                        newBoardList[i] = boardList[i]; // 기존 배열 내 게시물들을 새로운 배열에 대입
                    }

                }
                // 새로운 배열내 마지막 인덱스(배열명.length-1)에 입력받은 게시물 객체 등록
                newBoardList[ count - 1 ] = board;
                // ** 새로운 배열을 기존배열에 대입한다.
                boardList = newBoardList;


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
