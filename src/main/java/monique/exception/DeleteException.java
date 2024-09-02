package monique.exception;


/**
 * The <code>DeleteException</code> class represents an exception that is thrown
 * when an error related to deleting an item occurs. It extends from <code>MoniqueException</code>.
 */
public class DeleteException extends MoniqueException {
    /**
     * Constructs a new <code>DeleteException</code> with a default detail message.
     * The message indicates that the item number is not allowed.
     */
    public DeleteException() {
        super("Delete Exception: Item Number is not allowed");
    }

    /**
     * Provides advice on how to handle a delete-related exception.
     *
     * @return a string containing advice for handling the delete exception, indicating that the item to be deleted does not exist.
     */
    @Override
    public String advice() {
        return "Delete-related Exception. You have tried to delete an item which does not exist.";
    }
}