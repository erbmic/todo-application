package todo.model.categoryException;

public class InvalidCategoryException extends Exception{
    public InvalidCategoryException(){
        super("Invalid value for Category.");
    }
}
