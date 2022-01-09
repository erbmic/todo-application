package todo.model.userExceptions;

public class InvalidCredentialsException extends Exception{
    public InvalidCredentialsException(){
        super("Invalid user name or password");
    }
}
