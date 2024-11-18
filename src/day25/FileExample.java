package day25;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class FileExample {
    public static void main(String[] args) {
        // 1. 파일 출력(쓰기)
        // - 자바에서 사용되는 데이터를 자바 외부(c:/java) 메모장(.txt)으로 저장
        try {
            // 예외가 발생 할 것 같은 코드(예상/) try{ } 안에서 작성.
            // 현재 프로잭트내 텍스트 파일 생성
            FileOutputStream fileOutput = new FileOutputStream("./src/day25/test1.txt");
            fileOutput.write("Hello Java!".getBytes()); // 10 바이트

            // fileOutput[객체].write[메소드](인자값1);
        } catch ( FileNotFoundException e ) { // 예외가 발생 했을때 실행되는 코드 작성
            e.printStackTrace();
        } catch ( Exception e ) {
            // [모든] 예외가 발생 했을때 실행되는 코드 작성 (Exception : 예외 클래스의 super 클래스)
            e.printStackTrace();
        } finally {
            // 예외가 있던 없든 실행되는 코드 작성
        }
     }
}
