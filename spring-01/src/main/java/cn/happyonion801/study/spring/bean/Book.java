package cn.happyonion801.study.spring.bean;

public class Book {
    private String name;
    private String author;
    private User user;

    public Book() {
    }

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
    }

    public Book(String name, String author, User user) {
        this.name = name;
        this.author = author;
        this.user = user;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", user=" + user +
                ", add=" + super.toString() +
                '}';
    }
}
