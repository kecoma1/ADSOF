package pr3.traffic.fines;
import java.util.Arrays;
import pr3.traffic.drivers.*;
import pr3.traffic.vehicles.*;
import pr3.traffic.license.*;
import pr3.traffic.itvs.*;
import java.time.LocalDate;


public class TesterFines {

	private void NoDriverFine() {
		Person Amon = new Person("Amon", 30);	
		Person Ra = new Person("Ra", 30);	
		Person Horus = new Person("Horus", 30);	

		Amon.setLicense(new License(PermitKind.A, PermitKind.B, PermitKind.C1));
		Ra.setLicense(new License(PermitKind.A, PermitKind.B, PermitKind.C1));
		Horus.setLicense(new License(PermitKind.A, PermitKind.B, PermitKind.C1));


		Vehicle fleet[] = { 
			new Car("Fiat 500x", 2019, "1245 HYN", true, Amon),		
			new Truck("IvecoDaily", 2010, "5643 KOI", 2, Ra),
			new Motorcycle("Harley Davidson", 2003, "0987 ETG", false, Horus)};

		FineProcessor pm = new FineProcessor(Arrays.asList(fleet));
		pm.process(FineReader.read("fines_radar1.txt"));
	}

	private void NoOwnerAndDriverFine() {
		Vehicle fleet[] = { 
			new Car("Fiat 500x", 2019, "1245 HYN", true),		
			new Truck("IvecoDaily", 2010, "5643 KOI", 2),
			new Motorcycle("Harley Davidson", 2003, "0987 ETG", false)};

		FineProcessor pm = new FineProcessor(Arrays.asList(fleet));
		pm.process(FineReader.read("fines_radar1.txt"));
	}

	public static void main(String[] args) {
		Person ann = new Person("Ann Smith", 30);		 		// Ann 			
		Person anthony = new Person("Anthony Johnson", 27);
		Company fdinc = new Company("Fast Delivery Inc", ann);	// Ann es responsible for FDINC
		
		ann.setLicense(new License(PermitKind.B, PermitKind.C1));
		anthony.setLicense(new License(PermitKind.A));
		
		Vehicle fleet[] = { 
				new Car("Fiat 500x", 2019, "1245 HYN", true, ann), 	// Ann's car, who drives it		
				new Truck("IvecoDaily", 2010, "5643 KOI", 2, fdinc), // FDINC's car
				new Motorcycle("Harley Davidson", 2003, "0987 ETG", false, anthony)};

		/* As we implemented ITV we need that each car passed an itv */
		fleet[0].passItv(new Itv(LocalDate.now(), new Garage("a", "a", "a"), "a"));
		fleet[1].passItv(new Itv(LocalDate.now(), new Garage("a", "a", "a"), "a"));
		fleet[2].passItv(new Itv(LocalDate.now(), new Garage("a", "a", "a"), "a"));
		
		FineProcessor pm = new FineProcessor(Arrays.asList(fleet));
		pm.process(FineReader.read("fines_radar1.txt"));

		TesterFines test = new TesterFines();

		/*=================No Owner nor driver=================*/
		System.out.println("\n==================================\n1.Test: Vehicles don't have an owner\n");
		test.NoOwnerAndDriverFine();

		/*=================No Owner=================*/
		System.out.println("\n==================================\n2.Test: Vehicles just have an owner (this owner is set to be the driver)\n");
		test.NoDriverFine();
	}
}
