package day25.toDoList.view;

import day25.toDoList.controller.MainController;
import day25.toDoList.model.ToDoListDto;
import day25.toDoList.model.TodoListDao;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class MainView {
    private static MainView mainView = new MainView();
    private MainView () {}
    public static MainView getInstance() {
        return mainView;
    }
    Scanner sc = new Scanner(System.in);
    
    public void mainPage(){
        while (true) {
            System.out.println("1. toDoList 작성 2. toDoList 확인 3. 삭제 4. 종료 : ");
            int ch = sc.nextInt();
            if(ch == 1) {
                toDoListWrite();
            } else if (ch == 2) {
                toDoListPrint();
            } else if (ch == 3) {
                deleteToDoList();
            } else if (ch == 4 ) {
                break;
            }
        }
    }

    public void toDoListWrite() {
        sc.nextLine();
        System.out.print("To Do : "); String todo = sc.nextLine();
        System.out.print("마감일 입력 [ 예) 2024.11.01 ] : ");
        LocalDate deadLine = changeDate(sc.nextLine());
        System.out.print("1. Done! 2. Done yet! : ");
        boolean isDone = isDone(sc.nextInt());
        sc.nextLine();

        boolean result = MainController.getInstance().checkDto(todo,deadLine,isDone);

        if (result) {
            System.out.println("toDoList 작성 완료!");
        } else {
            System.out.println("toDoList 작성 실패!");
        }

    }

    public LocalDate changeDate ( String date ) {
       try {
           String[] obj = date.split("\\.");
           int year = Integer.parseInt(obj[0]);
           int month = Integer.parseInt(obj[1]);
           int day = Integer.parseInt(obj[2]);
           return LocalDate.of(year,month,day);
       } catch ( DateTimeException e) {
          e.printStackTrace();
       }
       return LocalDate.of(1999,06,26);
    }

    public boolean isDone( int isDone) {
        if ( isDone == 1 ) {
            return true;
        } else if ( isDone == 2 ) {
            return false;
        } else {
           throw new IllegalArgumentException("1과 2중에 선택해주세요");
        }
    }

    public void toDoListPrint() {
        ArrayList<ToDoListDto> dtos = MainController.getInstance().gettoDoListDB();
        for(int i = 0; i < dtos.size(); i ++ ) {
            System.out.printf("🤖-------- %d번째 To Do --------🤖%n",i + 1);
            System.out.println("---- To Do ----");
            System.out.println(dtos.get(i).getContent());
            System.out.println("---- 마감일 ----");
            System.out.println(dtos.get(i).getDeadLine());
            System.out.println("---- 완료 여부 ----");
            System.out.println(dtos.get(i).isFinished());
        }
    }

    public void deleteToDoList() {
        System.out.println("삭제 메뉴 입니다. 몇 번째 ToDo를 삭제하겠습니까?");
        int ch = sc.nextInt();
        try {
            if (ch > 0 && ch <= TodoListDao.getInstance().toDoListDBInstance().size())
            MainController.getInstance().deleteDoListDB(ch);
        } catch (IllegalArgumentException e ) {
            e.printStackTrace();
            System.out.println("범위를 벗어난 숫자입니다");
        }

    }
}
