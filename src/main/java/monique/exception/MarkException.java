package monique.exception;

/**
 * The <code>MarkException</code> class represents an exception that is thrown
 * when an operation related to marking or unmarking tasks fails. It extends from <code>MoniqueException</code>.
 */
public class MarkException extends MoniqueException {

    /**
     * Constructs a new <code>MarkException</code> with a default detail message.
     * The message indicates that an item number related to marking is not allowed.
     */
    public MarkException() {
        super("Mark Exception: Item Number is not allowed");
    }

    /**
     * Provides advice on how to handle this exception.
     * This method prints a message informing the user that they have tried to mark an item that does not exist
     * or unmark an item that is already unmarked.
     */
    @Override
    public void advice() {
        System.out.println("Mark-related Exception. You have tried to mark an item which does not exist, or unmark something that is already unmarked.");
    }
}