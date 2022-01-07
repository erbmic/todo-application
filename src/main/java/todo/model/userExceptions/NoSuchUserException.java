package todo.model.userExceptions;

import java.util.function.Supplier;

public class NoSuchUserException extends Exception {
    public NoSuchUserException(){
        super("User doesn't exist.");
    }
}
