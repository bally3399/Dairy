package data.model;


public class Diary {
    private String username;
    private String password;
    private boolean isLocked = true;

    public Diary(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Diary() {

    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setLock(boolean locked) {
        isLocked = locked;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public boolean isLocked(){
        return isLocked;
    }
}
