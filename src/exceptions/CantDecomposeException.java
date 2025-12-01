package exceptions;

public class CantDecomposeException extends Exception {
    public CantDecomposeException(String name, int n){
        super("I can't decompose: "+n+" as a sum of "+name);
    }
}
