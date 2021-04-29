package forms;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner; 

/**
 * Class that defines a form. It contains a map of fields.
 * @author Kevin de la Coba and Marcos Aarón Bernuy.
 */
public class Form {
    
    private Map<String, Field<?>> fields = new LinkedHashMap<>();

    /**
     * Method to add a field to the form.
     * @param <T> Type of the returning value of the form.
     * @param s String message shown when there's an error.
     * @param f Field.
     * @return This object.
     */
    public Form add(String s, Field<?> f) {
        if (this.fields.keySet().contains(s)) return this;
        this.fields.put(s, f);
        return this;
    }

    /**
     * Method to execute all the fields.
     */
    public Map<String, String> exec() {
        Scanner myObj;
        String input;
        Map<String, String> returnMap = new LinkedHashMap<>();
        for (String key : this.fields.keySet()) {
            Field<?> f = this.fields.get(key);
            
            do {
                // Printing the message
                System.out.print(key+" > ");

                // Taking the input
                myObj = new Scanner(System.in);
    
                input = myObj.nextLine();

            } while (!f.validate(input));

            returnMap.put(key, f.getInputTransformer().apply(input).toString());
        }

        return returnMap;
    }
}