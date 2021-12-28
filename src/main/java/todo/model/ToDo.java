package todo.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.time.LocalDate;

public class ToDo {

    @JacksonXmlProperty(isAttribute = true)
    private long id;
    private String title;
    private Boolean done;
    private Boolean important;
//    private LocalDate dueDate;
    @JacksonXmlProperty(isAttribute = true)
    private Category category;

//    private enum Category {
//        house, job
//    }

    public ToDo() {
    }

    public ToDo(long id, String title, Boolean done, Boolean important, Category category) {
        this.id = id;
        this.title = title;
        this.done = done;
        this.important = important;
        this.category = category;
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

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    public Boolean getImportant() {
        return important;
    }

    public void setImportant(Boolean important) {
        this.important = important;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
