package pr3.traffic.license;
import pr3.traffic.drivers.*;
import pr3.traffic.vehicles.*;

public class TesterLicense {
	private void testYoungerThan18CannotHavePermitA() {
		Person ann = new Person("Ann Smith", 17);
		License c = new License(PermitKind.A);
		System.out.println("Test: YoungerThan18CannotHavePermitA");
		System.out.println(c);
		System.out.println(ann.setLicense(c) +" - expected false");		// should return false, since Ann is not 18 years old		
	}
	
	private void testYoungerThan23CannotHavePermitC1() {
		Person ann = new Person("Ann Smith", 19);
		License c = new License(PermitKind.A, PermitKind.C1);
		System.out.println("=================\nTest: YoungerThan23CannotHavePermitC1");
		System.out.println(c);			
		System.out.println(ann.setLicense(c) +" - expected false");		// should return false, since Ann is not 23 years old
	}
	
	private void testLicenseForVehicleKind() {
		Person ann = new Person("Ann Smith", 24);
		ann.setLicense(new License(PermitKind.A, PermitKind.C1));
		Car c = new Car("Fiat 500x", 2019, "1245 HYN", true, ann);
		System.out.println("=================\nTest: LicenseForVehicleKind");
		System.out.println(c);		// Ann is not the driver, since it has motorbyke and truck permits
		ann.getLicense().addPermit(PermitKind.B);
		c.setDriver(ann);
		System.out.println(c);		// Now she is
		System.out.println(ann.getLicense());		// license
	}

	private void testOlderThan23CanHavePermitC1() {
		Person p = new Person("Person", 24);
		License c = new License(PermitKind.C1);
		System.out.println("=================\nTest: OlderThan23CanHavePermitC1");
		System.out.println(c);			
		System.out.println(p.setLicense(c) +" - expected true");	// True
	}

	private void testSameThan23CanHavePermitC1() {
		Person p = new Person("Person", 23);
		License c = new License(PermitKind.C1);
		System.out.println("=================\nTest: SameThan23CanHavePermitC1");
		System.out.println(c);			
		System.out.println(p.setLicense(c) +" - expected true");	// True
	}
	
	private void testOlderThan18CanHavePermitAandB(){
		Person john = new Person ("John Travolta", 19);
		License c = new License(PermitKind.A, PermitKind.B);
		System.out.println("=================\nTest: OlderThan18CanHavePermitAandB");
		System.out.println(c);
		System.out.println(john.setLicense(c) +" - expected true");
	}

	private void testSameThan18CanHavePermitAandB(){
		Person john = new Person ("John Travolta", 18);
		License c = new License(PermitKind.A, PermitKind.B);
		System.out.println("=================\nTest: SameThan18CanHavePermitAandB");
		System.out.println(c);
		System.out.println(john.setLicense(c) +" - expected true");
	}

	private void testRemovePoints(){
		License l = new License(PermitKind.A);
		System.out.println("=================\nTest: RemovePoints");
		System.out.println((l.getPoints() == 12)+" - expected true");
		l.removePoints(5); // Removing 5 points
		System.out.println((l.getPoints() == 12-5)+" - expected true");
		l.removePoints(5); // Removing 5 points
		System.out.println((l.getPoints() == 12-5-5)+" - expected true");
		l.removePoints(5); // Removing 5 points
		System.out.println((l.getPoints() == 0)+" - expected true");
	}

	private void testSuspendLicense() {
		License l = new License(PermitKind.A);
		System.out.println("=================\nTest: SuspendLicense");
		System.out.println(l.getSuspended()+" - expected false");
		l.removePoints(5); // Removing 5 points
		System.out.println(l.getSuspended()+" - expected false");
		l.removePoints(5); // Removing 5 points
		System.out.println(l.getSuspended()+" - expected false");
		l.removePoints(5); // Removing 5 points
		System.out.println(l.getSuspended()+" - expected false");
		l.removePoints(1); // Removing 5 points
		System.out.println(l.getSuspended()+" - expected true");
	}

	private void testSuspendedLicenseCannotSetLicense() {
		License l = new License(PermitKind.A);
		System.out.println("=================\nTest: SuspendedLicenseCannotSetLicense");
		System.out.println(l.getSuspended()+" - expected false");
		l.removePoints(12); 
		System.out.println(l.getSuspended()+" - expected false");
		l.removePoints(5); // Removing 5 points	
		System.out.println(l.getSuspended()+" - expected true");
		Person p = new Person("a", 25);
		System.out.println(p.setLicense(l)+" - expected false");
	}
	public static void main(String[] args) {
		TesterLicense tap3 = new TesterLicense();
		tap3.testYoungerThan18CannotHavePermitA();
		tap3.testYoungerThan23CannotHavePermitC1();
		tap3.testLicenseForVehicleKind();
		tap3.testOlderThan18CanHavePermitAandB();
		tap3.testSameThan18CanHavePermitAandB();
		tap3.testOlderThan23CanHavePermitC1();
		tap3.testSameThan23CanHavePermitC1();
		tap3.testRemovePoints();
		tap3.testSuspendLicense();
		tap3.testSuspendedLicenseCannotSetLicense();
	}	

}
