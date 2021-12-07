package todo.model;

import java.util.*;

public class Account {

    static User user;
    private static final List<User> userAccounts = new ArrayList<>();

    private static final Account accountInstance = new Account();

    private Account() {}

    public static Account getAccountInstance() {
        return accountInstance;
    }

    public void registerUser(String userName, String password) {
        user = new User(userName, password);
        userAccounts.add(user);

    }

    public boolean loginUser(String userName, String password) {

//        List<User> listUser = userAccounts.stream()
//                .filter(userAccounts -> userAccounts.equals(userName))
//                .findAny()
//                .orElse(null);
//
//
//        if (userAccounts.stream().filter(userAccounts -> userName.equals(userAccounts.getUserName())).findAny().orElse(null)) {
//
//        }



        if (Objects.equals(userAccounts, userName) && Objects.equals(userAccounts, password)) {
            return true;
        } else {
            return false;
        }
    }

    public void deleteUser() {

    }

}
