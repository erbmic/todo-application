package todo.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.List;
import java.util.logging.Logger;

public class TodoList {

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "todo")
    private List<ToDo> todos;
    private CatList[] categories;

    private static final String xmlInputFileName = System.getProperty("user.home") + "/data.xml";
    private static final Logger LOGGER = Logger.getLogger(TodoList.class.getName());


    public TodoList() {
    }

    public TodoList(List<ToDo> todos) {
        this.todos = todos;
    }

    public void setTodos(List<ToDo> todos) {
        this.todos = todos;
    }

    public List<ToDo> getTodos() {
        return todos;
    }

    private void sortTodos() {

    }

    private void filterTodos() {

    }

    private void addTodo() {

    }

    private void editTodo() {

    }

    private void deleteTodo() {

    }

    private void findTodo() {

    }
}
