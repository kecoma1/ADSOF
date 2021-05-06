package forms;

import java.io.IOException;
import java.util.Scanner; 
import java.util.Map; 

/**
 * Class that uses the proxy design pattern (this class is the proxy)
 * to protect a form.
 * @author Kevin de la Coba Malam and Marcos Bernuy
 */
public class ProtectedForm extends AbstractForm{

    private static Form form;
    private static String password;
    private static int counter = 3;
    private static boolean proved = false;

    /**
     * Method to protect a form.
     * @param form Form to protect.
     * @param password Password of the form.
     * @return Instance of a protected form.
     */
    public static ProtectedForm protect(Form form, String password){ 
        ProtectedForm.form = form;
        ProtectedForm.password = password;
        return new ProtectedForm();
    }

    public Map<String, ? super Comparable> exec(){
        Scanner myObj;
        String input;

        while (ProtectedForm.counter > 0 && !ProtectedForm.proved) {
            // Printing the message
            System.out.print("Enter password: ");

            // Taking the input
            myObj = new Scanner(System.in);
            input = myObj.nextLine();

            if(!input.equals(ProtectedForm.password)){
                ProtectedForm.counter--;
                System.out.println("Invalid password ("+ProtectedForm.counter+" remaining attempts)");
            } else {
                ProtectedForm.proved = true;
                return ProtectedForm.form.exec();
            }
        }

        if (!ProtectedForm.proved) return null;
        else return ProtectedForm.form.exec();
    }
}