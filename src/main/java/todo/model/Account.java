package todo.model;

public class Account {

    private User user;
    private static User[] accounts;

    public Account() {

    }

    public void registerUser(String userName, String password) {
        user = new User (userName, password);

    }

    public void loginUser() {

    }

    public void deleteUser() {

    }

}
