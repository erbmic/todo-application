package todo.model.userExceptions;

public class WrongPasswordException extends Exception{
    public WrongPasswordException(){
        super("Wrong password.");
    }
}
