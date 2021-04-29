package forms;

import java.util.HashMap;
import java.util.Map;

/**
 * Class that defines a form. It contains a map of fields.
 * @author Kevin de la Coba and Marcos Aarón Bernuy.
 */
public class Form {
    
    private Map<Field<?>, String> fields = new HashMap<>();

    /**
     * Method to add a field to the form.
     * @param <T> Type of the returning value of the form.
     * @param s String message shown when there's an error.
     * @param f Field.
     * @return This object.
     */
    public Form add(String s, Field<?> f) {
        this.fields.put(f, s);
        return this;
    }
}
