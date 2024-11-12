package day21;

import java.util.Scanner;

/**
 *  BoardService1
 *      - 내용과 작성자로 구성된 게시물 최대 100개까지 저장하는 서비스 구축
 *      - 조건 : main 1개와 배열은 최대 2개까지 사용 구현
 *      - 구축 : 게시물 쓰기와 게시물 출력 기능 구현
 */

public class BoardService1 {
    public static void main(String[] args) {
        // 배열 변수를 사용하는 이유 : 여러개의 변수에 있는 데이터를 배열로 사용하면
        // 배열이란? 여러개의 동일한 타입의 데이터들을 하나의 변수에 저장할 수 있는 (참조)타입
        // 인덱스이란 ? 배열내 저장된 데이터들의 저장 순서 번호, 0 ~ 최대 길이
            // 반복문 활용 : 시작값부터 끝 값까지 반복
        Scanner sc = new Scanner(System.in); // 입력 객체

        String[] writers = new String[100]; // String 데이터 100개를 저장할 수 있는 배열 선언
        String[] contents  = new String[100]; // 배열 선언 방법 : 타입[] 변수명 = new 타입[갯수];

        while (true) { // 무한루프
            System.out.println("1. 게시물쓰기 2. 게시물 출력 3. 종료");
            int choose = sc.nextInt();

               if(choose == 1) {
                   System.out.println("작성자 입력"); String content = sc.next();
                   System.out.println("게시물 입력"); String writer = sc.next();
                   // 만약에 게시물이 비어 있으면, 게시물이 100개이면 if 100개 검사? X
                   // 인덱스 0부터 마지막 인덱스 99까지 1씩 증가
                        // 스위치 변수 = 상태 저장하는 변수
                   boolean save = false;
                   for ( int i = 0; i <= contents.length-1; i++) {
                       if(contents[i] == null) {
                           contents[i] = content; writers[i] = writer; // 비어 있는 게시물의 입력받은 내용물 저장
                           save = true; // 만약에 저장 성공 했으면 save 변수에 true값으로 변경
                           break; // 만약에 저장을 했으면 1개 저장해야 하므로 brake해서 반복문 종료
                       }
                   }
                   // for 종료후에 save 변수값이 true 성공,false 이면 실패
                   if (save) {
                       System.out.println("게시물 쓰기 성공");
                   } else {
                       System.out.println("게시물 쓰기 실패 : 빈공간이 없습니다");
                   }
               }
               if(choose == 2 ) {
                   for(int i = 0; i <= contents.length-1; i++) { // 0 ~ 99 까지
                       if(contents[i] != null) { // 만약에 i번째 게시물이 존재하면
                           System.out.printf("*** %d 번째 ***%n작성자 : %s%n게시글 : %s%n",i+1, writers[i],contents[i]);
                       }
                   }
               }
               if(choose == 3) {
                   break;
               }


        } // while end

    } // main end
} // class end
