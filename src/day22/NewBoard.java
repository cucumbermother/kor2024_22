package day22;

public class NewBoard {
    private String writer;
    private String content;
    private int password;

    public NewBoard (String writer,int password, String content) {
        this.content = content;
        this.password = password;
        this.writer = writer;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "NewBoard{" +
                "writer='" + writer + '\'' +
                ", content='" + content + '\'' +
                ", password=" + password +
                '}';
    }
}
