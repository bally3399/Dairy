package data.model;

import java.time.LocalDate;

public class Entry {
    private int id;
    private String title;
    private String body;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    private String author;
    private  LocalDate dateCreated = LocalDate.now();

    public Entry(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public Entry() {

    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", author='" + author + '\'' +
                ", dateCreated=" + dateCreated +
                '}';
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setId(int id) {
        this.id = id;

    }

}

