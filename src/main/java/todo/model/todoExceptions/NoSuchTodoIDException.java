package todo.model.todoExceptions;

public class NoSuchTodoIDException extends Exception{
    public NoSuchTodoIDException(){
        super("No such Todo ID in Todo List found.");
    }
}
