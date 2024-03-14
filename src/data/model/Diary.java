package data.model;

import java.util.ArrayList;
import java.util.List;

public class Diary {
    private String username;
    private String password;
    public boolean isLocked = true;
    private final List<Entry> entries = new ArrayList<>();
    private final List<Diary> diaries = new ArrayList<>();
    private int counter = 101;

    public Diary(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

}
