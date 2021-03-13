package pr3.traffic.fines;
import java.util.*;
import java.io.*;

public class FineTester {
	public static void main(String[] args){
		/*try{
			FileInputStream stream = new FileInputStream("fines_radar1.txt");
			InputStreamReader reader = new InputStreamReader(stream);
			BufferedReader buffer = new BufferedReader(reader);

			String line;
			while ((line = buffer.readLine()) != null)
				System.out.println( "line read is: " + line);
		}
		catch(IOException ex){
			System.out.println(ex);
		}
		*/

		List<Fine> fines = FineReader.read("fines_radar1.txt");
		
		for (Fine m : fines) 
			System.out.println(m+"\n------------");	
	}
}
