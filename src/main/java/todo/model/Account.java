package todo.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import todo.model.userExceptions.InvalidCredentialsException;
import todo.model.userExceptions.NoSuchUserException;
import todo.model.userExceptions.UserAlreadyExistsException;
import todo.model.userExceptions.WrongPasswordException;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

@JacksonXmlRootElement(localName = "account")
public class Account {

    private static final String XML_FILE = System.getProperty("user.home") + File.separator + "data2.xml";
    private static final File FILE = new File(XML_FILE);

    private static Account accountInstance = new Account();
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "user")
    private Set<User> userAccounts;

    private Account() {
        this.userAccounts = new HashSet<>();
    }

    public static Account getAccountInstance() {
        return accountInstance;
    }

    public void loadXml() {
        if (FILE.canRead()) {
            ObjectMapper mapper = new XmlMapper();
            configureMapper(mapper);
            try (FileReader reader = new FileReader(FILE)) {
                accountInstance = mapper.readValue(reader, Account.class);
                userAccounts = accountInstance.userAccounts;
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public static void saveXml() {
        ObjectMapper mapper = new XmlMapper();
        configureMapper(mapper);
        try (FileWriter writer = new FileWriter(FILE)) {
            mapper.writerWithDefaultPrettyPrinter().writeValue(writer, accountInstance);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public User registerUser(String firstName, String lastName, String userName, String password, String passwordC)
            throws InvalidCredentialsException, UserAlreadyExistsException {
        if (!validUserName(userName) || !validPassword(password, passwordC)) throw new InvalidCredentialsException();
        loadXml();
        User user = new User(firstName, lastName, userName, password);
        if (userAccounts.add(user)) {
            user.getTodoList().setTodosFiltered(user.getTodoList().getTodos());
            user.getTodoList().sortTodos();
            Account.saveXml();
            return user;
        } else {
            throw new UserAlreadyExistsException();
        }
    }

    // returns user if login succeeds
    // throws Exceptions if user doesn't exist or if wrong password
    public User loginUser(String userName, String password) throws WrongPasswordException, NoSuchUserException {
        User user = findByUserName(userName);
        if (user.getPassword().equals(password)) {
            user.getTodoList().setTodosFiltered(user.getTodoList().getTodos());
            user.getTodoList().sortTodos();
            return user;
        } else {
            throw new WrongPasswordException();
        }
    }

    public User deleteUser(String userName) throws NoSuchUserException {
        User user = findByUserName(userName);
        if (userAccounts.remove(user)) {
            Account.saveXml();
            return user;
        }
        return null;
    }

    private User findByUserName(String userName) throws NoSuchUserException {
        loadXml();
        return userAccounts.stream()
                .filter(user -> userName.equals(user.getUserName()))
                .findAny()
                .orElseThrow(NoSuchUserException::new);
    }

    // returns true if a given userName is valid
    private boolean validUserName(String userName) {
        return !userName.isEmpty();
    }

    // returns true if a given password is valid
    private boolean validPassword(String password, String passwordC) {
        return !password.isEmpty() && password.equals(passwordC);
    }

    private static void configureMapper(ObjectMapper objectMapper) {
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

}
