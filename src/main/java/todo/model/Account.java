package todo.model;

import java.util.*;

public class Account {

    private static final Account accountInstance = new Account();
    private static final List<User> userAccounts = new ArrayList<>();

    private Account() {
    }

    public static Account getAccountInstance() {
        return accountInstance;
    }

    public User registerUser(String userName, String password) {
        User user = new User(userName, password);
        userAccounts.add(user);

        return user;
    }

    public boolean loginUser(User user) {

        return userAccounts.contains(user);

//        List<User> listUser = userAccounts.stream()
//                .filter(userAccounts -> userAccounts.equals(userName))
//                .findAny()
//                .orElse(null);
//
//
//        if (userAccounts.stream().filter(userAccounts -> userName.equals(userAccounts.getUserName())).findAny().orElse(null)) {
//
//        }

    }

    public void deleteUser() {

    }

}
