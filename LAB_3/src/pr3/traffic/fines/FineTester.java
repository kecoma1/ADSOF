package pr3.traffic.fines;
import java.util.*;

public class FineTester {
	public static void main(String[] args){

		List<Fine> fines = FineReader.read("../txt/fines_radar1.txt");
		
		for (Fine m : fines) 
			System.out.println(m+"\n------------");
	}
}