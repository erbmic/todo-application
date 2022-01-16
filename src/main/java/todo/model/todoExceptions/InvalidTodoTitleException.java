package todo.model.todoExceptions;

public class InvalidTodoTitleException extends Exception{
    public InvalidTodoTitleException(){
        super("Invalid value for title");
    }
}
