package day23;

import java.util.ArrayList;
import java.util.Scanner;

public class BoardService6 {
    public static void main(String[] args) {

        // - 확인코드
        // 1. toString 오버라이딩 하기전
       // Board board = new Board();
     //   System.out.println(board); // 객체의 (힙 영역) 주소값

        // 2. toString() 오버라이딩 했을때, toString() 함수는 생략가능
       // Board board2 = new Board();
       // System.out.println(board); // 객체의 (힙 영역) 주소값

        // 구현 : BoardService5 구현

        Scanner scan = new Scanner(System.in);


        ArrayList<Board> boardList = new ArrayList<>();

        while (true) {
            System.out.println("1. 글쓰기 2. 글출력 3. 종료 : ");
            int choose = scan.nextInt();
            if(choose == 1){
                scan.nextLine();
                System.out.println("내용 : "); String content = scan.nextLine();
                System.out.println("작성자 : "); String writer = scan.next();
                System.out.println("비밀번호 : "); int pwd = scan.nextInt();
                Board board = new Board(content, writer, pwd);
                boardList.add(board);
            }else if(choose == 2 ){
                for( int i = 0; i < boardList.size()  ; i ++) {
                    System.out.printf("***%d번째 게시물***%n작성자 : %s%n게시글 : %s%n", i+1 ,
                            boardList.get(i).getContent(),boardList.get(i).getWriter());
                }
            } else if (choose == 3 ){
                System.out.println("시스템 종료");
                break;
            }

        }

    }
}
