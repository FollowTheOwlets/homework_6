import exeptions.AccessDeniedException;
import exeptions.UserNotFoundException;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        User[] users = getUsers();

        System.out.println("( login_1, login_2, login_3 ) Введите логин:");
        String login = scan.nextLine();

        System.out.println("( password_1, password_2, password_3 ) Введите пароль:");
        String password = scan.nextLine();

        if (validateUser(users[getUserByLoginAndPassword(users,login, password)])) {
            System.out.println("Доступ предоставлен");
        }
    }

    public static int getUserByLoginAndPassword( User[] users, String login, String password) throws UserNotFoundException {
        for (int i = 0; i < users.length; i++) {
            if (users[i].checkLoginAndPassword(login, password)) return i;
        }
        throw new UserNotFoundException();
    }

    public static boolean validateUser(User user) throws AccessDeniedException {
        if (user.checkAge()) return true;
        throw new AccessDeniedException();
    }

    public static User[] getUsers() {
        return new User[]{
                new User("login_1", "password_1", 15, "aaa@example.com"),
                new User("login_2", "password_2", 14, "bbb@example.com"),
                new User("login_3", "password_3", 45, "ccc@example.com"),
                new User("login_4", "password_4", 34, "ddd@example.com"),
                new User("login_5", "password_5", 19, "eee@example.com"),
        };
    }


}

