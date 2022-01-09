package todo.model.userExceptions;

public class UserAlreadyExistsException extends Exception{
    public UserAlreadyExistsException(){
        super("A user with this user name already exists.");
    }
}
