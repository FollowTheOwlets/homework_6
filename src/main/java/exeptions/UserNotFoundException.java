package exeptions;

public class UserNotFoundException extends  RuntimeException{
    public UserNotFoundException(){
        super("Неверный логин или пароль!");
    }
}
