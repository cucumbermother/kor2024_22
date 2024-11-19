package day25.toDoList.model;

import java.time.LocalDate;

public class ToDoListDto {
    private String content;
    private LocalDate deadLine;
    private boolean finished;

    public ToDoListDto(String content, LocalDate deadLine, boolean finished) {
        this.content = content;
        this.deadLine = deadLine;
        this.finished = finished;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public LocalDate getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(LocalDate deadLine) {
        this.deadLine = deadLine;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "toDoListDto{" +
                "content='" + content + '\'' +
                ", deadLine=" + deadLine +
                ", finished=" + finished +
                '}';
    }
}
