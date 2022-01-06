package todo.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.List;

public class User {

    @JacksonXmlProperty(localName = "userName")
    private String userName;
    @JacksonXmlProperty(localName = "password")
    private String password;
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "todoList")
    private TodoList todoList;

    public User() {
    }

    //call method readToDos() directly to initially read the xml file
    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
        this.todoList = new TodoList();
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

    public TodoList getTodoList() {
        return todoList;
    }

    public void setTodoList(TodoList todoList) {
        this.todoList = todoList;
    }

}
