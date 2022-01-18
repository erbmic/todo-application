package todo.model.todoExceptions;

public class AddTodoException extends Exception{
    public AddTodoException () {
        super("Unable to add todo to list.");
    }
}
