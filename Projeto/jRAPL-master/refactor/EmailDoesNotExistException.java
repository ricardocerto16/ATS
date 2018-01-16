package refactor;

public class EmailDoesNotExistException extends Exception
{
    public EmailDoesNotExistException(){
    }
    
    public EmailDoesNotExistException(String msg){
        super(msg);
    }
}
