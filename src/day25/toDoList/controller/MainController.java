package day25.toDoList.controller;

import day25.boardService9MVC.model.BoardDao;
import day25.toDoList.model.ToDoListDto;
import day25.toDoList.model.TodoListDao;

import java.time.LocalDate;
import java.util.ArrayList;

public class MainController {
    private static final MainController mainController = new MainController();
    private MainController () {}
    public static MainController getInstance() {
        return mainController;
    }

    public boolean checkDto (String content, LocalDate deadLine, Boolean isFinished) {
        ToDoListDto toDoListDto = new ToDoListDto(content, deadLine , isFinished);
        return TodoListDao.getInstance().toDoListAddDtos(toDoListDto);
    }

    public ArrayList<ToDoListDto> gettoDoListDB () {
        ArrayList<ToDoListDto> result = TodoListDao.getInstance().toDoListDBInstance();
        return result;
    }

    public void deleteDoListDB(int num ) {
        TodoListDao.getInstance().fileDelete(num);
    }

}
