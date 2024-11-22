package day29.boardService10MVC.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class BoardDao {

    private Connection connection; // DB 연동 인터페이스 // DB 연동 결과를 가지고 있어서 DB 조작이 가능한 인터페이스

    // ---- 싱글톤 ----
    private static BoardDao boardDao = new BoardDao();
    private BoardDao(){
        // DB 연동시 필요한 코드 2줄\
        try {
            // [1] 외부라이브(JDBC) 폴더 내 com 폴더 -> mysql폴더 -> cj폴더 -> jdbc 폴더 -> Driver 클래스 호출, * 일반 예외
            Class.forName("com.mysql.cj.jdbc.Driver");
            // [2] DB연동 인터페이스 만들기 DriverManager.getConnection("MySQLSERVER_URL/DB명","계정명", "비밀번호");
            // DriverManager.getConnection() : DB SERVER와 연동을 성공 했을때 연동된 결과의 객체를 반환 * 일반 예외
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb1122", "root", "1234");
            // [3] 확인
            System.out.println("[3] DB 연동 성공");
            // 연동에 실패하는 이유 : 1. 프로젝트에 jdbc 라이브러리 등록 안함  2. DB 연동 url 경로
        } catch ( ClassNotFoundException e ) {
            System.out.println(e);
        } catch ( SQLException e ) {
            e.getMessage();
        }
        // forname() 특정한 클래스를 호출 하는데 사용되는 함수, 만일 클래스가 존재하지 않으면 어떻게 해야하는지 일반 예외에서 처리
    }
    public static BoardDao getInstance() {return boardDao;};
    // ---------------


    // 여러개 게시물을 저장하는 리스트
    ArrayList<BoardDto> boardDB = new ArrayList<>();


    // 1. 게시물 등록 접근 함수
    public boolean boardWrite( BoardDto boardDto){
        // boardDB.add( boardDto );

        try {
            // [1] connection.prepareStatement (DML(SQL) 작성 ) : 연동된 DB에 SQL을 서명할 준비하는 함수
            PreparedStatement ps = connection.prepareStatement("insert into board(bcontent, bwriter, bpwd)values('여기는 JAVA' , '유재석', '1234')" );
            // [2] 서명된 SQL 실행
            ps.execute();
        } catch ( SQLException e) {
            e.getMessage();
        }
        return true;
    }

    // 2. 게시물 출력 접근 함수
    public ArrayList<BoardDto> boardPrint( ){
        return  boardDB;
    }

}
