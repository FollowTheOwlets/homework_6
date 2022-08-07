import exeptions.AccessDeniedException;
import exeptions.UserNotFoundException;

public class User {
    private final String login;
    private final String password;
    private final int age;
    private String email;

    public User(String login, String password, int age, String email) {
        if (age < 0) {
            age = 0;
        }
        this.login = login;
        this.password = password;
        this.age = age;
        this.email = email;
    }

    public boolean checkLoginAndPassword(String login, String password) {
        return this.login.equals(login) && this.password.equals(password);
    }

    public boolean checkAge() {
        return this.age > 18;
    }

    @Override
    public String toString() {
        return this.login + "  " + this.age;
    }


}
