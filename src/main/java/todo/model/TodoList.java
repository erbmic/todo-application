package todo.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.ArrayList;
import java.util.List;

public class TodoList {

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "todo")
    private List<ToDo> todos;
    private static long nextId;

    public TodoList() {
        this.todos = new ArrayList<>();
    }

    public List<ToDo> getTodos() {
        return todos;
    }

    public static long getNextId(){
        long act = nextId;
        nextId ++;
        return act;
    }


    public void editTodo() {

    }

    public void deleteTodo() {

    }

    public void findTodo() {

    }

    public void sortTodos() {

    }

    public void filterTodos() {

    }
}
