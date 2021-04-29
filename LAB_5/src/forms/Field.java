package forms;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Class that defines a field. 
 * It is generic and the constructor receives a functional interface 
 * (Function<T>). 
 * It contains serveral validators which check a condition, they are all in map
 * which contains as a key the validator and as a value the error
 * message if the condition of the validator is not accomplished.
 * @author Kevin de la Coba and Marcos Aarón Bernuy.
 */
public class Field <T> {

    private Function<String, T> inputTransformer;
    private Map<Predicate<T>, String> validations;

    /**
     * Constructor of the class Field.
     * @param transformer UnaryOperator<T>, transforms
     * the input.
     */
    public Field(Function<String, T> transformer) {
        this.inputTransformer = transformer;
        this.validations = new HashMap<>();
    }

    /**
     * Method to add a validation into de field.
     * @param p Predicate to use whenever we are going to validate.
     * @param s Message to show in case it is not validated.
     * @return This object Field.
     */
    public Field<T> addValidation(Predicate<T> p, String s) {
        this.validations.put(p, s);
        return this;
    }
}
