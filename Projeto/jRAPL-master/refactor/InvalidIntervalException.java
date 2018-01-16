package refactor;

public class InvalidIntervalException extends Exception
{
    public InvalidIntervalException(){
    }
    
    public InvalidIntervalException(String msg){
        super(msg);
    }
}
