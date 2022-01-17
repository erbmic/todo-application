package todo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import todo.model.todoExceptions.InvalidTodoDueDateException;
import todo.model.todoExceptions.InvalidTodoTitleException;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Scanner;

public class ToDo {

    @JacksonXmlProperty(isAttribute = true)
    private long id;
    private String title;
    private boolean done;
    private boolean important;
    @JsonIgnore
    private boolean overDue;
    @JacksonXmlProperty(isAttribute = true)
    private String category;
    private LocalDate dueDate;
    private String description;

    public ToDo(){}

    // Constructor for a new ToDo
    public ToDo(String title, String done, String important, String category, String dueDate, String description)
            throws InvalidTodoTitleException, InvalidTodoDueDateException{
        this.title = processTitle(title);
        this.done = processDone(done);
        this.important = processImportant(important);
        this.category = category;
        this.dueDate = processDueDate(dueDate);
        this.description = description;
    }

    // Constructor for a existing ToDo
    public ToDo(String id, String title, String done, String important, String category, String dueDate, String description)
            throws NumberFormatException, InvalidTodoTitleException, InvalidTodoDueDateException {
        this.id = Long.parseLong(id);
        this.title = processTitle(title);
        this.done = processDone(done);
        this.important = processImportant(important);
        this.category = category;
        this.dueDate = processDueDate(dueDate);
        this.description = description;
    }

    private static String processTitle(String title) throws InvalidTodoTitleException {
        if (!title.isEmpty()) {
            return title;
        }
        throw new InvalidTodoTitleException();
    }

    private static boolean processDone(String done){
        if (done == null){
            return false;
        }
        return true;
    }

    private static boolean processImportant(String important){
        if (important == null){
            return false;
        }
        return true;
    }

    private static LocalDate processDueDate(String dueDate) throws InvalidTodoDueDateException {
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean getDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public boolean getImportant() {
        return important;
    }

    public void setImportant(boolean important) {
        this.important = important;
    }

    public boolean getOverDue(){return this.overDue;}

    public void setOverDue(boolean overDue){this.overDue = overDue;}

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDate getDueDate() {
        return this.dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ToDo toDo = (ToDo) o;
        return id == toDo.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
