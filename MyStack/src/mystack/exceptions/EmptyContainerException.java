package mystack.exceptions;

public class EmptyContainerException extends Exception {

    @Override
    public String getMessage() {
        return "The container is empty!!!";
    }
}
