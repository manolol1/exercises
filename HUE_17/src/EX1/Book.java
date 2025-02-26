package EX1;

public class Book extends Article {
    private String author;
    private String title;

    public Book(String author, String title, int code, int price) {
        super(code, price);
        this.author = author;
        this.title = title;
    }

    @Override
    public String toString() {
        return String.format("{author: %s; title: %s; %s}", author, title, super.toString());
    }

    @Override
    public boolean available() {
        return Math.random() < 0.2;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
