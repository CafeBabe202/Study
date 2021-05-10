package cn.happyonion801.study.spring.jdbc.entity;

public class Book {
    private int id;
    private String book_status;
    private String book_name;

    public Book() {
    }

    public Book(int id, String book_status, String book_name) {
        this.id = id;
        this.book_status = book_status;
        this.book_name = book_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBook_status() {
        return book_status;
    }

    public void setBook_status(String book_status) {
        this.book_status = book_status;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", book_status='" + book_status + '\'' +
                ", book_name='" + book_name + '\'' +
                '}';
    }
}
