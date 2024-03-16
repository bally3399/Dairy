package data.model;

import java.time.LocalDate;

public class Entry {
    private int id;
    private String title;
    private String body;
    private  LocalDate dateCreated = LocalDate.now();

    public Entry(String title, String body) {
        this.title = title;
        this.body = body;
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

    public void setBody(String body) {
        this.body = body;
    }

    public void setId(int id) {
        this.id = id;

    }

    public String toString(){
        return String.format("Time: %s\t\nTitle: %s\t\nBody: %s\t", dateCreated, title, body);
    }
}

