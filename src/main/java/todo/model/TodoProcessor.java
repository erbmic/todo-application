package todo.model;

import todo.model.todoExceptions.InvalidTodoDueDateException;
import todo.model.todoExceptions.InvalidTodoTitleException;

import java.time.LocalDate;
import java.util.Scanner;

public class TodoProcessor {

    public static String processTitle(String title) throws InvalidTodoTitleException {
        if (title != null && !title.isEmpty()) {
            return title;
        }
        throw new InvalidTodoTitleException();
    }

    public static boolean processDone(String done){
        return done != null && done.toLowerCase().equals("true");
    }

    public static boolean processImportant(String important){
        return important != null && important.toLowerCase().equals("true");
    }

    public static String processCategory(String category){
        if (category != null) {
            return category;
        }
        return "";
    }

    public static LocalDate processDueDate(String dueDate) throws InvalidTodoDueDateException {
        if (dueDate == null) return null;
        if (dueDate.equals("")) return null;
        int year = 0;
        int month = 0;
        int day = 0;
        try(Scanner scan = new Scanner(dueDate)){
            while(scan.hasNext()){
                scan.useDelimiter("-");
                year = scan.nextInt();
                month = scan.nextInt();
                day = scan.nextInt();
            }
            return LocalDate.of(year, month, day);
        } catch (Exception e) {
            throw new InvalidTodoDueDateException();
        }
    }

    public static String processDescription(String description){
        if(description != null){
            return description;
        }
        return "";
    }

}
