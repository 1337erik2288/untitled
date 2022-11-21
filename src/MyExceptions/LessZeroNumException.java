package MyExceptions;

public class LessZeroNumException extends Exception{
    public LessZeroNumException(){
        super();
    }
    public LessZeroNumException(String description){
        super(description);
    }
}
