package MyExceptions;

public class StepZeroException extends Exception{
    public StepZeroException(){
        super();
    }
    public StepZeroException(String description){
        super(description);
    }
}
