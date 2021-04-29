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

    /**
     * Method to validate an string.
     * @param input Input received in the "terminal".
     */
    public boolean validate(String input) {
        // Transforming the input
        T transformed = this.inputTransformer.apply(input);
        
        for (Predicate<T> key : this.validations.keySet()) {
            if (!key.test(transformed)) {
                System.out.println("Invalid value: "+input);
                
                // Printing asociated error message
                System.out.println(this.validations.get(key));

                return false;
            }
        }
        return true;
    }

    /**
     * Method to get the input transformer of the class.
     * @return Input transformer of the class.
     */
    public Function<String, T> getInputTransformer() {
        return this.inputTransformer;
    }

}
