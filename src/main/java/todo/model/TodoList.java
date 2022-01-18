package todo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import todo.model.todoExceptions.AddTodoException;
import todo.model.todoExceptions.NoSuchTodoIDException;
import java.util.*;
import java.time.LocalDate;
import java.util.stream.Collectors;

public class TodoList {

    private long nextId ;
    private CatList catList;
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "todo")
    private List<ToDo> todos;
    @JsonIgnore
    private List<ToDo> todosFiltered;

    public TodoList() {
        this.nextId = 1;
        this.catList = new CatList();
        this.todos = new ArrayList<>();
        this.todosFiltered = new ArrayList<>();
    }

    public CatList getCatList(){return catList;}
    public List<ToDo> getTodos() {
        return todos;
    }

    public long getNextId(){return this.nextId;}
    public List<ToDo> getTodosFiltered(){return this.todosFiltered;}
    public void setTodosFiltered(List<ToDo> todos){this.todosFiltered = todos;}

    private long generateNextId(){
        long act = nextId;
        nextId ++;
        return act;
    }

    public ToDo addTodo(ToDo todo) throws AddTodoException{
        todo.setId(generateNextId());
        if (todos.add(todo)){
            sortTodos();
            markOverDue();
            catList.filterCats(todos);
            Account.saveXml();
            return todo;
        } else {
            throw new AddTodoException();
        }
    }

    public ToDo editTodo(ToDo todo) throws NoSuchTodoIDException {
        int index = todos.indexOf(todo);
        if (index >= 0) {
            todos.set(index, todo);
            sortTodos();
            markOverDue();
            catList.filterCats(todos);
            Account.saveXml();
            return todo;
        } else {
            throw new NoSuchTodoIDException();
        }
    }

    public void deleteTodo(String todoID) throws NoSuchTodoIDException{
        todos.remove(getTodo(todoID));
        sortTodos();
        catList.filterCats(todos);
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
            throw new NoSuchTodoIDException();
        }
        throw new NoSuchTodoIDException();
    }

    public List<ToDo> getTodosOfCat(String category) {
          return  todos.stream()
                  .filter(todo -> todo.getCategory().equals(category))
                  .collect(Collectors.toList());
    }

    public void toggleDone(String todoID) throws NoSuchTodoIDException{
        ToDo todo = getTodo(todoID);
        todo.setCompleted(!todo.getCompleted());
        Account.saveXml();
    }

    public void sortTodos() {
        Collections.sort(todosFiltered, new Comparator<ToDo>() {
            @Override
            public int compare(ToDo t1, ToDo t2) {
                if (t1.getDueDate() == null) return 1;
                if (t2.getDueDate() == null) return -1;
                return t1.getDueDate().compareTo(t2.getDueDate());
            }
        });
    }

    public void filterTodos(String category) {
        if (category.equals("displayAll")) {
            todosFiltered = todos;
        } else {
            todosFiltered = todos.stream()
                    .filter(todo -> todo.getCategory().equals(category))
                    .collect(Collectors.toList());
        }
        sortTodos();
    }

    public void markOverDue() {
        LocalDate today = LocalDate.now();
        for (ToDo todo : todos) {
            if (todo.getDueDate() == null) {
                todo.setOverDue(false);
            } else if (todo.getDueDate().compareTo(today) < 0) {
                todo.setOverDue(true);
            } else {
                todo.setOverDue(false);
            }
        }
    }

}
