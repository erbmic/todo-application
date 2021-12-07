package todo.model;

public class User {

    private String userName;
    private String password;
    private String email;
    private TodoList[] toDos;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public TodoList[] getToDos() {
        return toDos;
    }

    public void setToDos(TodoList[] toDos) {
        this.toDos = toDos;
    }

    public void login() {

    }

    public void register() {

    }

    public void updateProfile() {

    }



}
