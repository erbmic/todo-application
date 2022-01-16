package todo.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import java.util.Objects;

public class User {

    private String firstName;
    private String lastName;
    @JacksonXmlProperty(localName = "userName")
    private String userName;
    @JacksonXmlProperty(localName = "password")
    private String password;
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "todoList")
    private TodoList todoList;
    private CatList catList;

    public User() {
    }

    //call method readToDos() directly to initially read the xml file
    public User(String firstName, String lastName, String userName, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.todoList = new TodoList();
        this.catList = new CatList();
    }

    public String getFirstName(){return firstName;}

    public void setFirstName(String firstName){this.firstName = firstName;}

    public String getLastName(){return lastName;}

    public void setLastName(String lastName){this.lastName = lastName;}

    public String getUserName() {return userName;}

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

    public CatList getCatList() {
        return catList;
    }

    public void setCatList(CatList catList) {
        this.catList = catList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userName.equals(user.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName);
    }
}
