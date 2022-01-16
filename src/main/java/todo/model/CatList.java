package todo.model;

import java.util.HashSet;
import java.util.Set;

public class CatList {

    private Set<String> cats = new HashSet<>();

    public CatList() {
        cats.add("Home");
        cats.add("People");
        cats.add("School");
        cats.add("Shopping");
        cats.add("Work");
    }

    public Set<String> getCats(){return this.cats;}

    private void addCategory() {

    }

    private void editCategory() {

    }

    private void deleteCategory() {

    }
}
