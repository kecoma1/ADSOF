package pr4.exceptions;

/**
 * Class to define a race exception
 * @author Kevin de la Coba and Marcos Aarón Bernuy.
 */
public class RaceException extends Exception {
    
    /**
     * Constructor of the Race exception.
     * @param errMsg Error message.
     */
    public RaceException(String errMsg) {
        super(errMsg);
    }
}
