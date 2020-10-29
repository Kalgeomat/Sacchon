package gr.Pfizer.bootcamp3.team6.restapi.exceptions;

public class DeletedEntityException extends Exception{
    public DeletedEntityException(String message)
    {
        super(message);
    }
}
