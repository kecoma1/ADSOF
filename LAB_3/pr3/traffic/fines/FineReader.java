package pr3.traffic.fines;
import java.util.*;
import java.io.*;

/**
 * Class that defines the FineReader
 * @author Kevin de la Coba and Marcos Bernuy
 */
public class FineReader{

    public static List<Fine> read(String filename) throws IOException{
        
        FileInputStream stream = new FileInputStream(filename);
        InputStreamReader reader = new InputStreamReader(stream);
        BufferedReader buffer = new BufferedReader(reader);
        List<Fine> arrayFines = new ArrayList<>();

        String line;
        while ((line = buffer.readLine()) != null){
            int i = 0;
            String words[];
            words = new String[3];
            for (String word : line.split(";")){
                words[i] = word;
                i++;
            }
            Fine multa = new Fine(words[0], words[1], words[2]);
            arrayFines.add(multa);
        }
        buffer.close();
        return arrayFines;
    }
}