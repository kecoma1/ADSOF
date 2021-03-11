package pr3.traffic;

public class Example1 {

	public static void main(String[] args) {
		Car fiat500x = new Car("Fiat 500x", 2019, true);
		Car minic = new Car("Mini Copper", 2015, false);
		Car xsara = new Car("Citroen XSara", 1997, true);
		
		Vehicle [] vehicles = { fiat500x, minic, xsara };
		
		for (Vehicle v : vehicles )  
			System.out.println(v);	
	}
}
