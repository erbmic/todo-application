package todo.model;

import java.time.LocalDate;

public class ToDo {

    private static String title;
    private static Boolean done;
    private static Boolean important;
    private static LocalDate dueDate;
    private static Category category;

//    private enum Category {
//        house, job
//    }


    public static String getTitle() {
        return title;
    }

    public static LocalDate getDueDate() {
        return dueDate;
    }

    public static Category getCategory() {
        return category;
    }
}
