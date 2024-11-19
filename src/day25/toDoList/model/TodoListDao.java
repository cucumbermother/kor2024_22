package day25.toDoList.model;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class TodoListDao {
    private String src =  "C:/Users/유나/Desktop/김유나/java/src/day25/toDoList/data.txt";
    private static TodoListDao toDoListDao = new TodoListDao();
    private TodoListDao (){
        File file = new File(src);
        if(file.exists()) {
            fileLoad();
        } else {
            try {
                file.createNewFile();
            } catch (IOException e ) {
                e.printStackTrace();
                System.out.println("파일을 생성할 수 없습니다.");
            }
        }
    }
    public static TodoListDao getInstance() {
        return toDoListDao;
    }

    ArrayList<ToDoListDto> toDoListDB = new ArrayList<>();

    public boolean toDoListAddDtos( ToDoListDto toDoListDto ) {
        toDoListDB.add(toDoListDto);
        fileSave();
        return true;
    }

    public ArrayList<ToDoListDto> toDoListDBInstance (){
        return toDoListDB;
    }

    public void fileSave() {
        String outStr = "";
        for(int i = 0; i < toDoListDB.size(); i ++) {
            ToDoListDto toDoListDto = toDoListDB.get(i);
            outStr += toDoListDto.getContent() + "," + toDoListDto.getDeadLine() +
                    "," + toDoListDto.isFinished() + "\n";
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(src);
            fileOutputStream.write(outStr.getBytes());
            System.out.println("toDoList 업데이트 성공");
        } catch ( FileNotFoundException e ) {
            e.printStackTrace();
            System.out.println("파일이 없습니다.");
        } catch ( IOException e ) {
            e.printStackTrace();
        }
    }

    public void fileLoad() {
        try {
            FileInputStream fileInputStream = new FileInputStream(src);
            File file = new File(src);
            byte[] bytes = new byte[(int) file.length()];
            fileInputStream.read(bytes);
            String inStr = new String(bytes);
            String[] objStr = inStr.split("\n");
            for (int i = 0; i < objStr.length ; i ++ ) {
                String obj = objStr[i].trim();
                String[] filed = obj.split(",");
                String content = filed[0];
                LocalDate deadLine = LocalDate.parse(filed[1]);
                boolean isFinished = Boolean.parseBoolean(filed[2]);
                ToDoListDto toDoListDto = new ToDoListDto(content,deadLine,isFinished);
                toDoListDB.add(toDoListDto);
            }
        } catch ( FileNotFoundException e ) {
            e.printStackTrace();
            System.out.println("파일을 불러오지 못했습니다.");
        } catch ( IOException e) {
            e.printStackTrace();
        }
    }

    public void fileDelete(int num) {
        try {
            if (num > 0 && num <= toDoListDB.size()) {
                toDoListDB.remove(num - 1);
                System.out.println("삭제 완료");
                fileSave();
            } else if( num > toDoListDB.size() || num <= 0) {
                System.out.println("유효하지 않은 범위입니다");
            }
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }
}
