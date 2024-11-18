package day25;

import java.io.*;
import java.util.Scanner;

public class FileExample3 {
    public static void main(String[] args) {
        // 생각해보기
        // 1. 키보드로 부터 입력받은 문자열을 day25 폴더 내 test1.txt 에 저장하시오
        // 2. 'day25' 폴더 내 test2.txt에 저장된 (문자열)바이트를 읽어 콘솔에 출력
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("파일에 저장할 내용 : ");
            FileOutputStream fileOutputStream = new FileOutputStream("./src/day25/test2.txt");
            String outStr = sc.nextLine();
            fileOutputStream.write(outStr.getBytes());
            System.out.println("저장 성공");
            FileInputStream fileInputStream = new FileInputStream("./src/day25/test2.txt");
            // byte[] bytes = new byte[outStr.length()];
            File file = new File("./src/day25/test2.txt");
            System.out.println(file.isFile()); // true
            System.out.println(file.getName()); // test2.txt
            System.out.println(file.length()); // 반환타입 long
            byte[] bytes = new byte[(int) file.length()]; // 21억 바이트까지 허용
                // (캐스팅) : 강제 타입 변환, long 타입을 int 타입으로 변환
                // 배열내 [] 안에 들어가는 배열 크기는 타입이 정수(int)만 가능
            fileInputStream.read(bytes);
            String inStr = new String(bytes);
            System.out.println(inStr);
            System.out.println("불러오기 성공");
        } catch (FileNotFoundException e ){
            e.printStackTrace();
        } catch (IOException e ) {
            e.printStackTrace();
        } catch ( Exception e ){
            e.printStackTrace();
        } finally {
            System.out.println("프로그램 끗");
        }     } // main e
} // class e

