package forms;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Abstract class that defines a form. It only contains the 
 * abstract method exec that should be included in every kind
 * of form.
 * @author Kevin de la Coba Malam and Marcos Aarón Bernuy
 */
public abstract class AbstractForm {

    private Map<String, Field<?>> fields = new LinkedHashMap<>();

    /**
     * Method to execute the form and take the data.
     * @return Map that contains as a key the question of the form and the answer.
     */
    public abstract Map<String, ? super Comparable> exec();

    /**
     * Method to get the fields of the form.
     * @return Fields of the forms.
     */
    public Map<String, Field<?>> getFields() { 
        return this.fields; 
    }
}