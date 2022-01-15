package todo.model.todoExceptions;

public class InvalidTodoDueDateException extends Exception{
    public InvalidTodoDueDateException() {
        super("Invalid due date.");
    }
}
