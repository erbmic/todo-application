package todo.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.LinkedList;
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

    //method to initially read the xml file
//    public TodoList readToDos() {
//        ObjectMapper mapper = new XmlMapper();
//        LOGGER.info(" - - - - Read from file " + xmlInputFileName + " - - - - ");
//        try (InputStream reader = new FileInputStream(xmlInputFileName)) {
//            return mapper.readValue(reader, TodoList.class);
//        } catch (IOException ex) {
//            throw new RuntimeException(ex);
//        }
//    }

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
