package pr4.races;

/**
 * Class to create a race from a file.
 * @author Kevin de la Coba and Marcos Bernuy.
 */
public class RaceReader {
    
    
    public static List<Fine> read(String filename) throws Exception { 
        try {
            // Creating the necesary objects to read a file
            FileInputStream stream = new FileInputStream(filename);
            InputStreamReader reader = new InputStreamReader(stream);
            BufferedReader buffer = new BufferedReader(reader);
            
            // List to store the Fines
            List<Fine> vehicles = new ArrayList<>();
            
            // Storing each line
            String line;
            while ((line = buffer.readLine()) != null){
                int i = 0;
                String words[];
                words = new String[3];
                
                // Parsing each word in the line
                for (String word : line.split(";")){
                    words[i] = word;
                    i++;
                }
                
                // Storing the lines into a Fine object
                Fine multa = new Fine(words[0], words[1], words[2]);
                arrayFines.add(multa);
            }

            buffer.close();
            return arrayFines;
        } catch(IOException e) { return null; }
    }
}