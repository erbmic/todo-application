package todo.model;

public class User {

    private String userName;
    private String password;
    private TodoList toDos;

    //call method readToDos() directly to initially read the xml file
    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
        this.toDos = new TodoList().readToDos();
        System.out.println("read todos");
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

    public TodoList getToDos() {
        return toDos;
    }

    public void setToDos(TodoList toDos) {
        this.toDos = toDos;
    }
}
