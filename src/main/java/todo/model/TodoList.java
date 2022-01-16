package todo.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import todo.model.todoExceptions.InvalidTodoDueDateException;
import todo.model.todoExceptions.InvalidTodoTitleException;
import todo.model.todoExceptions.NoSuchTodoIDException;

import java.util.*;
import java.time.LocalDate;

public class TodoList {

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "todo")
    private List<ToDo> todos;
    private List<ToDo> filtered;
    private long nextId;

    public TodoList() {
        this.todos = new ArrayList<>();
        this.todos = new ArrayList<>();
    }

    public List<ToDo> getTodos() {
        return todos;
    }
    public List<ToDo> getFiltered(){return filtered;}
    public long getNextId(){return this.nextId;}

    public long nextId(){
        long act = nextId;
        nextId ++;
        return act;
    }

    public ToDo addTodo(String title, String important, String dueDate, String category, String description)
        throws  InvalidTodoTitleException, InvalidTodoDueDateException {

        long id = nextId();
        String pTitle = processTitle(title);
        boolean pImportant = processImportant(important);
        LocalDate pDueDate = processDueDate(dueDate);

        ToDo todo = new ToDo(id, pTitle, pImportant, category, pDueDate, description);
        todos.add(todo);
        Account.saveXml();
        return todo;
    }

    public ToDo editTodo(String todoID, String title, String done, String important, String dueDate, String category, String description)
        throws NoSuchTodoIDException, InvalidTodoTitleException, InvalidTodoDueDateException{

        ToDo todo = getTodo(todoID);

        String pTitle = processTitle(title);
        boolean pDone = processDone(done);
        boolean pImportant = processImportant(important);
        LocalDate pDueDate = processDueDate(dueDate);

        todo.setTitle(pTitle);
        todo.setDone(pDone);
        todo.setImportant(pImportant);
        todo.setDueDate(pDueDate);
        todo.setCategory(category);
        todo.setDescription(description);

        Account.saveXml();
        return todo;
    }

    public void deleteTodo(String todoID) throws NoSuchTodoIDException{
        todos.remove(getTodo(todoID));
        Account.saveXml();
    }

    public ToDo getTodo(String todoID) throws NoSuchTodoIDException {
        try{
            long id = Integer.parseUnsignedInt(todoID);
            for (ToDo todo : todos) {
                if (todo.getId() == id){
                    return todo;
                }
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        throw new NoSuchTodoIDException();
    }

    public void toggleDone(String todoID) throws NoSuchTodoIDException{
        ToDo todo = getTodo(todoID);
        todo.setDone(!todo.getDone());
        Account.saveXml();
    }

    public void sortTodos() {

    }

    public void filterTodos() {

    }

    private String processTitle(String title) throws InvalidTodoTitleException{
        if (!title.isEmpty()) {
            return title;
        }
        throw new InvalidTodoTitleException();
    }

    private boolean processDone(String done){
        if (done == null){
            return false;
        }
        return true;
    }

    private boolean processImportant(String important){
        if (important == null){
            return false;
        }
        return true;
    }

    private LocalDate processDueDate(String dueDate) throws InvalidTodoDueDateException {
        if (dueDate == null) return null;
        if (dueDate.equals("")) return null;
        int year = 0;
        int month = 0;
        int day = 0;
        try(Scanner scan = new Scanner(dueDate)){
            while(scan.hasNext()){
                scan.useDelimiter("-");
                year = scan.nextInt();
                month = scan.nextInt();
                day = scan.nextInt();
            }
            return LocalDate.of(year, month, day);
        } catch (Exception e) {
            throw new InvalidTodoDueDateException();
        }
    }

}
