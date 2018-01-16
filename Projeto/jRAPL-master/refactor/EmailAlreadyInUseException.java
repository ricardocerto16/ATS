package refactor;

public class EmailAlreadyInUseException extends Exception
{
    /** Construtor vazio. */
    public EmailAlreadyInUseException(){
    }
    
    /**
     * Construtor parametrizado.
     * @param msg
     */
    public EmailAlreadyInUseException(String msg){
        super(msg);
    }
}
