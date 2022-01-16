package todo.rest.service;

import todo.model.ToDo;
import todo.model.TodoList;

import java.util.List;

public class TodoService {

    TodoList todoList = new TodoList();

    private final List<ToDo> todos = todoList.getTodos();

    public List<ToDo> getTodos() {
        return todos;
    }

}
