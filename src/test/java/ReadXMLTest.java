import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.jupiter.api.Test;
import todo.model.ToDo;
import todo.model.TodoList;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class ReadXMLTest {

    private List<ToDo> todo;

    private static final String xmlInputFileName="data.xml";
    private static final Logger LOGGER = Logger.getLogger(TodoList.class.getName());

    private final TodoList todolistos = new TodoList();

    @Test
    public  void test() {
//        TodoList todos = getTodos();

//        TodoList todos = todolistos.readToDos();
        todolistos.readToDos();

//        ToDo todos

//        System.out.println(Arrays.toString(new String[]{todos.toString()}));

    }

    private static ToDo getTodos() {
        ObjectMapper mapper = new XmlMapper();
        LOGGER.info(" - - - - Read from file " + xmlInputFileName + " - - - - ");
        try (InputStream in = new FileInputStream(xmlInputFileName)) {
            return mapper.readValue(in, ToDo.class);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

//    private static TodoList getTodos() {
//        ObjectMapper mapper = new XmlMapper();
//        LOGGER.info(" - - - - Read from file " + xmlInputFileName + " - - - - ");
//        try (InputStream in = new FileInputStream(xmlInputFileName)) {
//            return mapper.readValue(in, TodoList.class);
//        } catch (IOException ex) {
//            throw new RuntimeException(ex);
//        }
//    }

}
