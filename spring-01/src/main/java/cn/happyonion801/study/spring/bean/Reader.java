package cn.happyonion801.study.spring.bean;

public class Reader {
    private Book book;

    public Reader() {
    }

    public Reader(Book book) {
        this.book = book;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "book=" + book +
                '}';
    }
}
