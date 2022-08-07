package exeptions;

public class AccessDeniedException extends  RuntimeException{
    public AccessDeniedException(){
        super("Доступ ограничен из-за возраста");
    }
}
