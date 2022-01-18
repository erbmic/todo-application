package todo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CatList {

    private Set<String> cats = new HashSet<>();
    @JsonIgnore
    private Set<String> catsFiltered =new HashSet<>();

    public CatList() {
        cats.add("Home");
        cats.add("People");
        cats.add("School");
        cats.add("Shopping");
        cats.add("Work");
    }

    public Set<String> getCats(){return this.cats;}
    public Set<String> getCatsFiltered(){return this.catsFiltered;}

    public void filterCats(List<ToDo> todos){
        catsFiltered = todos.stream()
                .map(ToDo::getCategory)
                .collect(Collectors.toSet());
    }

    private void addCategory() {

    }

    private void editCategory() {

    }

    private void deleteCategory() {

    }
}
