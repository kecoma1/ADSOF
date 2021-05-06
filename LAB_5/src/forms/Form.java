package forms;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner; 

/**
 * Class that defines a form. It contains a map of fields.
 * @author Kevin de la Coba and Marcos Aarón Bernuy.
 */
public class Form extends AbstractForm{
    

    /**
     * Method to add a field to the form.
     * @param s String message shown when there's an error.
     * @param f Field.
     * @return This object.
     */
    public Form add(String s, Field<?> f) {
        if (this.getFields().keySet().contains(s)) return this;
        this.getFields().put(s, f);
        return this;
    }

    public Map<String, ? super Comparable> exec() {
        Scanner myObj;
        String input;
        Map<String, ? super Comparable> returnMap = new LinkedHashMap<>();
        for (String key : this.getFields().keySet()) {
            Field<?> f = this.getFields().get(key);
            
            do {
                // Printing the message
                System.out.print(key+" > ");

                // Taking the input
                myObj = new Scanner(System.in);
    
                input = myObj.nextLine();

            } while (!f.validate(input));

            returnMap.put(key, f.getInputTransformer().apply(input));
        }

        return returnMap;
    }
}