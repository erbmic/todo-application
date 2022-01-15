package todo.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.time.LocalDate;

public class ToDo {

    @JacksonXmlProperty(isAttribute = true)
    private long id;
    private String title;
    private boolean done;
    private boolean important;
    private boolean overDue;
    @JacksonXmlProperty(isAttribute = true)
    private String category;
    private LocalDate dueDate;
    private String description;

    public ToDo(){}

    public ToDo(long id, String title, boolean important, String category, LocalDate dueDate, String description) {
        this.id = id;
        this.title = title;
        this.important = important;
        this.category = category;
        this.dueDate = dueDate;
        this.description = description;
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
}
