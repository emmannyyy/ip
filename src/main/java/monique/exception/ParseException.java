package monique.exception;


/**
 * The <code>ParseException</code> class represents an exception that is thrown
 * when there is an error parsing a command, usually due to missing arguments.
 * It extends from <code>MoniqueException</code>.
 */
public class ParseException extends MoniqueException {

    /**
     * The <code>ParseException</code> class represents an exception that is thrown
     * when there is an error parsing a command, usually due to missing arguments.
     * It extends from <code>MoniqueException</code>.
     */
    public ParseException() {
        super("Error parsing, missing arguments");
    }

    /**
     * Provides advice on how to handle this exception.
     * This method returns a message informing the user to re-enter commands using the correct template
     * and suggests entering '/commands' to find out command templates.
     *
     * @return a string containing advice on how to handle the parsing exception.
     */
    @Override
    public String advice() {
        return "Parsing Exception. Please re-enter commands using the correct template. To find out "
               + "command templates, please enter '/commands'";
    }
}
