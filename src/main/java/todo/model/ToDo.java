package todo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import java.time.LocalDate;
import java.util.Objects;

public class ToDo {

    @JacksonXmlProperty(isAttribute = true)
    private long id;
    private String title;
    private boolean completed;
    private boolean important;
    @JsonIgnore
    private boolean overDue;
    @JacksonXmlProperty(isAttribute = true)
    private String category;
    private LocalDate dueDate;
    private String description;

    public ToDo(){}

    public ToDo(long id, String title, boolean completed, boolean important, String category, LocalDate dueDate, String description) {
        this.id = id;
        this.title =  title;
        this.completed = completed;
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

    public boolean getCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
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
