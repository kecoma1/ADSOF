package forms;

public class ProtectedForm extends AbstractForm{

    private static Form form;
    private static String password;

    public static void protect(Form form, String password){ 
        this.form = form;
        this.password = password;
    }

    public abstract Map<String, ? super Comparable> exec(){
        Scanner myObj;
        String input;
        int counter = 2;

        do {
                // Printing the message
                System.out.print(key+" Enter password: ");

                // Taking the input
                myObj = new Scanner(System.in);
    
                input = myObj.nextLine();

                if(!input.equals(password)){
                    System.out.println("Invalid password ("+counter+" remaining attempts)");
                    counter--;
                } else {
                    form.exec();
                }

            } while (!input.equals(password) || counter <= 0);
    }
}