package todo.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class Account {

    private static final String XML_FILE = System.getProperty("user.home") + File.separator + "data2.xml";
    private static final File FILE = new File(XML_FILE);

    private static final Account accountInstance = new Account().loadXml();
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "user")
    private Set<User> userAccounts = new HashSet<>();

    private Account() {
    }

    public static Account getAccountInstance() {
        return accountInstance;
    }

    public Account loadXml() {
        ObjectMapper mapper = new XmlMapper();
        try (InputStream reader = new FileInputStream(FILE)) {
            return mapper.readValue(reader, Account.class);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public User registerUser(String userName, String password) {

        //check if user exists
        User user = new User(userName, password);
        userAccounts.add(user);

        return user;
    }

    public User loginUser(String userName, String password) {

        //        return userAccounts.contains(user);
        // user zurückgeben

        boolean userExists = userAccounts.stream().anyMatch(user -> user.getUserName().equals(userName));

        if (userExists) {
            User userAccount = findByUserName(userAccounts, userName);
            String userAccountPassword = userAccount.getPassword();

            if (userAccountPassword.equals(password)) {
                System.out.println("login succeeded");
                return userAccount;
            } else {
                System.out.println("wrong password");
                return null;
            }
        } else {
            System.out.println("The user doesnt exist");
            return null;
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
