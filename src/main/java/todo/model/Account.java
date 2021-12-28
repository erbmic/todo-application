package todo.model;

import java.util.*;

public class Account {

    private static final Account accountInstance = new Account();
    private static final Set<User> userAccounts = new HashSet<>();

    private Account() {
    }

    public static Account getAccountInstance() {
        return accountInstance;
    }

    public User registerUser(String userName, String password) {

        //check if user exists
        User user = new User(userName, password);
        userAccounts.add(user);

        return user;
    }

    public boolean loginUser(String userName, String password) {

        //        return userAccounts.contains(user);
        // user zurückgeben

        boolean userExists = userAccounts.stream().anyMatch(user -> user.getUserName().equals(userName));

        if (userExists) {
            User userAccount = findByUserName(userAccounts, userName);
            String userAccountPassword = userAccount.getPassword();

            if (userAccountPassword.equals(password)) {
                System.out.println("login succeeded");
                return true;
            } else {
                System.out.println("wrong password");
                return false;
            }
        } else {
            System.out.println("The user doesnt exist");
            return false;
        }
    }

    // https://stackoverflow.com/questions/17526608/how-to-find-an-object-in-an-arraylist-by-property
    public static User findByUserName(Set<User> userAccounts, String userName) {
        return userAccounts.stream().filter(user -> userName.equals(user.getUserName())).findFirst().orElse(null);

//        for(userAccounts : userName) {
//            if(carnet.getCodeIsIn().equals(codeIsIn)) {
//                return carnet;
//            }
//        }
//        return null;
    }

    public void deleteUser() {

    }

}
