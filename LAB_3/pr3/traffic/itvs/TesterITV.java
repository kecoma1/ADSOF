package pr3.traffic.itvs;
import pr3.traffic.fines.*;
import pr3.traffic.drivers.*;
import pr3.traffic.license.*;
import pr3.traffic.vehicles.*;
import java.time.LocalDate;
import java.util.Arrays;


/**
 * Class to test the ITV implemented
 * @author Kevin de la Coba Malam and Marcos Aarón Bernuy
 */
public class TesterITV{

    /* ============================ Checking the trucks ============================ */

    private void testerTruckItvNotPassed0Years(){
        Person kevin = new Person ("Kevin de la Coba", 30); 
        kevin.setLicense(new License(PermitKind.C1));
        Vehicle truck = new Truck("IvecoDaily", 2021, "5643 KOI", 2, kevin);

		System.out.println("=================\n1.Test: Truck bought in 2021, ITV not passed");
        System.out.println(truck);
        System.out.println("\nLast itv passed: ");
        System.out.println(truck.getLastItv());
        System.out.println("\nRemaining time until fine: "+ truck.timeRemaining());
        System.out.println(truck.checkPassedItv() + " - expected value = true");
    }

    private void testerTruckItvNotPassed2Years(){
        Person kevin = new Person ("Kevin de la Coba", 30); 
        kevin.setLicense(new License(PermitKind.C1));
        Vehicle truck = new Truck("IvecoDaily", 2018, "5643 KOI", 2, kevin);

		System.out.println("=================\n2.Test: Truck bought in 2018, ITV not passed");
        System.out.println(truck);
        System.out.println("\nLast itv passed: ");
        System.out.println(truck.getLastItv());
        System.out.println("\nRemaining time until fine: "+ truck.timeRemaining());
        System.out.println(truck.checkPassedItv() + " - expected value = false");
    }

    private void testerTruckItvPassed2Years(){
        Person kevin = new Person ("Kevin de la Coba", 30); 
        kevin.setLicense(new License(PermitKind.C1));
        Vehicle truck = new Truck("IvecoDaily", 2018, "5643 KOI", 2, kevin);
        
        // Passing the ITV
        Garage garage = new Garage("Garage", "Calle de los albaricoques, 12", "Madrid");
        LocalDate date = LocalDate.now().minusYears(1);
        Itv itv = new Itv(date, garage, "Se cuida bien");
        truck.passItv(itv);
        
		System.out.println("=================\n3.Test: Truck bought in 2018, ITV passed 3 years ago");
        System.out.println(truck);
        System.out.println("\nLast itv passed: ");
        System.out.println(truck.getLastItv());
        System.out.println("\nRemaining time until fine: "+ truck.timeRemaining());
        System.out.println(truck.checkPassedItv() + " - expected value = true");
    }

    private void testerTruckItvPassed6Years(){
        Person kevin = new Person ("Kevin de la Coba", 30); 
        kevin.setLicense(new License(PermitKind.C1));
        Vehicle truck = new Truck("IvecoDaily", 2016, "5643 KOI", 2, kevin);
        
        // Passing the ITV
        Garage garage = new Garage("Garage", "Calle de los albaricoques, 12", "Madrid");
        LocalDate date = LocalDate.now().minusYears(1);
        Itv itv = new Itv(date, garage, "Se cuida bien");
        truck.passItv(itv);
        
		System.out.println("=================\n4.Test: Truck bought in 2013, ITV passed 1 year ago");
        System.out.println(truck);
        System.out.println("\nLast itv passed: ");
        System.out.println(itv);
        System.out.println("\nRemaining time until fine: "+ truck.timeRemaining());
        System.out.println(truck.checkPassedItv() + " - expected value = true");
    }

    private void testerTruckItvNotPassed6Years(){
        Person kevin = new Person ("Kevin de la Coba", 30); 
        kevin.setLicense(new License(PermitKind.C1));
        Vehicle truck = new Truck("IvecoDaily", 2016, "5643 KOI", 2, kevin);
        
        // Passing the ITV
        Garage garage = new Garage("Garage", "Calle de los albaricoques, 12", "Madrid");
        LocalDate date = LocalDate.now().minusYears(3);
        Itv itv = new Itv(date, garage, "Se cuida bien");
        truck.passItv(itv);

		System.out.println("=================\n5.Test: Truck bought in 2013, ITV passed 3 year ago");
        System.out.println(truck);
        System.out.println("\nLast itv passed: ");
        System.out.println(itv);
        System.out.println("\nRemaining time until fine: "+ truck.timeRemaining());
        System.out.println(truck.checkPassedItv() + " - expected value = false");
    }

    private void testerTruckItvPassed10Years(){
        Person kevin = new Person ("Kevin de la Coba", 30); 
        kevin.setLicense(new License(PermitKind.C1));
        Vehicle truck = new Truck("IvecoDaily", 2013, "5643 KOI", 2, kevin);
        
        // Passing the ITV
        Garage garage = new Garage("Garage", "Calle de los albaricoques, 12", "Madrid");
        LocalDate date = LocalDate.now().minusMonths(11);
        Itv itv = new Itv(date, garage, "Se cuida bien");
        truck.passItv(itv);
        
        System.out.println("=================\n6.Test: Truck bought in 2013, ITV passed 11 months ago");
        System.out.println("\nLast itv passed: ");
        System.out.println(itv);
        System.out.println("\nRemaining time until fine: "+ truck.timeRemaining());
        System.out.println(truck.checkPassedItv() + " - expected value = true");
    }

    private void testerTruckItvNotPassed10Years(){
        Person kevin = new Person ("Kevin de la Coba", 30); 
        kevin.setLicense(new License(PermitKind.C1));
        Vehicle truck = new Truck("IvecoDaily", 2013, "5643 KOI", 2, kevin);
        
        // Passing the ITV
        Garage garage = new Garage("Garage", "Calle de los albaricoques, 12", "Madrid");
        LocalDate date = LocalDate.now().minusYears(2);
        Itv itv = new Itv(date, garage, "Se cuida bien");
        truck.passItv(itv);

        System.out.println("=================\n7.Test: Truck bought in 2013, ITV passed 2 years ago");
        System.out.println("\nLast itv passed: ");
        System.out.println(itv);
        System.out.println("\nRemaining time until fine: "+ truck.timeRemaining());
        System.out.println(truck.checkPassedItv() + " - expected value = false");
    }
    
    private void testerTruckItvPassedMoreThan10Years(){
        Person kevin = new Person ("Kevin de la Coba", 30); 
        kevin.setLicense(new License(PermitKind.C1));
        Vehicle truck = new Truck("IvecoDaily", 2008, "5643 KOI", 2, kevin);
        
        // Passing the ITV
        Garage garage = new Garage("Garage", "Calle de los albaricoques, 12", "Madrid");
        LocalDate date = LocalDate.now().minusMonths(4);
        Itv itv = new Itv(date, garage, "Se cuida bien");
        truck.passItv(itv);
        
        System.out.println("=================\n8.Test: Truck bought in 2008, ITV passed");
        System.out.println("\nLast itv passed: ");
        System.out.println(itv);
        System.out.println("\nRemaining time until fine: "+ truck.timeRemaining());
        System.out.println(truck.checkPassedItv() + " - expected value = true");
    }

    private void testerTruckItvNotPassedMoreThan10Years(){
        Person kevin = new Person ("Kevin de la Coba", 30); 
        kevin.setLicense(new License(PermitKind.C1));
        Vehicle truck = new Truck("IvecoDaily", 2008, "5643 KOI", 2, kevin);
        
        // Passing the ITV
        Garage garage = new Garage("Garage", "Calle de los albaricoques, 12", "Madrid");
        LocalDate date = LocalDate.now().minusMonths(9);
        Itv itv = new Itv(date, garage, "Se cuida bien");
        truck.passItv(itv);

        System.out.println("=================\n9.Test: Truck bought in 2008, ITV passed 9 months ago");
        System.out.println("\nLast itv passed: ");
        System.out.println(itv);
        System.out.println("\nRemaining time until fine: "+ truck.timeRemaining());
        System.out.println(truck.checkPassedItv() + " - expected value = false");
    }

    /* ============================ Checking the cars ============================ */

    private void testerCarItvNotPassed0Years(){
        Person kevin = new Person ("Kevin de la Coba", 30); 
        kevin.setLicense(new License(PermitKind.C1));
        Vehicle car = new Car("Lamborghini", 2021, "5643 KOI", true, kevin);

		System.out.println("=================\n1.Test: Car bought in 2021, ITV not passed");
        System.out.println(car);
        System.out.println("\nLast itv passed: ");
        System.out.println(car.getLastItv());
        System.out.println("\nRemaining time until fine: "+ car.timeRemaining());
        System.out.println(car.checkPassedItv() + " - expected value = true");
    }

    private void testerCarItvNotPassed4Years(){
        Person kevin = new Person ("Kevin de la Coba", 30); 
        kevin.setLicense(new License(PermitKind.C1));
        Vehicle car = new Car("Lamborghini", 2016, "5643 KOI", true, kevin);

        // Passing the ITV
        Garage garage = new Garage("Garage", "Calle de los albaricoques, 12", "Madrid");
        LocalDate date = LocalDate.now().minusYears(3);
        Itv itv = new Itv(date, garage, "Se cuida bien");
        car.passItv(itv);

		System.out.println("=================\n2.Test: Car bought in 2016, ITV passed 3 years ago");
        System.out.println(car);
        System.out.println("\nLast itv passed: ");
        System.out.println(car.getLastItv());
        System.out.println("\nRemaining time until fine: "+ car.timeRemaining());
        System.out.println(car.checkPassedItv() + " - expected value = false");
    }

    private void testerCarItvPassed4Years(){
        Person kevin = new Person ("Kevin de la Coba", 30); 
        kevin.setLicense(new License(PermitKind.C1));
        Vehicle car = new Car("Lamborghini", 2016, "5643 KOI", true, kevin);
        
        // Passing the ITV
        Garage garage = new Garage("Garage", "Calle de los albaricoques, 12", "Madrid");
        LocalDate date = LocalDate.now().minusYears(1);
        Itv itv = new Itv(date, garage, "Se cuida bien");
        car.passItv(itv);
        
		System.out.println("=================\n3.Test: Car bought in 2018, ITV passed 1 years ago");
        System.out.println(car);
        System.out.println("\nLast itv passed: ");
        System.out.println(car.getLastItv());
        System.out.println("\nRemaining time until fine: "+ car.timeRemaining());
        System.out.println(car.checkPassedItv() + " - expected value = true");
    }
    
    private void testerCarItvPassedMoreThan10Years(){
        Person kevin = new Person ("Kevin de la Coba", 30); 
        kevin.setLicense(new License(PermitKind.C1));
        Vehicle car = new Car("IvecoDaily", 2008, "5643 KOI", true, kevin);
        
        // Passing the ITV
        Garage garage = new Garage("Garage", "Calle de los albaricoques, 12", "Madrid");
        LocalDate date = LocalDate.now().minusMonths(7);
        Itv itv = new Itv(date, garage, "Se cuida bien");
        car.passItv(itv);
        
        System.out.println("=================\n4.Test: Car bought in 2008, ITV passed 7 months ago");
        System.out.println("\nLast itv passed: ");
        System.out.println(itv);
        System.out.println("\nRemaining time until fine: "+ car.timeRemaining());
        System.out.println(car.checkPassedItv() + " - expected value = true");
    }

    private void testerCarItvNotPassedMoreThan10Years(){
        Person kevin = new Person ("Kevin de la Coba", 30); 
        kevin.setLicense(new License(PermitKind.C1));
        Vehicle car = new Car("IvecoDaily", 2008, "5643 KOI", true, kevin);
        
        // Passing the ITV
        Garage garage = new Garage("Garage", "Calle de los albaricoques, 12", "Madrid");
        LocalDate date = LocalDate.now().minusYears(2);
        Itv itv = new Itv(date, garage, "Se cuida bien");
        car.passItv(itv);

        System.out.println("=================\n5.Test: Car bought in 2008, ITV passed 2 years ago");
        System.out.println("\nLast itv passed: ");
        System.out.println(itv);
        System.out.println("\nRemaining time until fine: "+ car.timeRemaining());
        System.out.println(car.checkPassedItv() + " - expected value = false");
    }

    /* ============================ Checking the motorcyles ============================  */

    private void testerMotorcycleItvNotPassed0Years(){
        Person kevin = new Person ("Kevin de la Coba", 30); 
        kevin.setLicense(new License(PermitKind.C1));
        Vehicle mot = new Motorcycle("Ducati", 2021, "5643 KOI", true, kevin);

		System.out.println("=================\n1.Test: Motorcycle bought in 2021, ITV not passed");
        System.out.println(mot);
        System.out.println("\nLast itv passed: ");
        System.out.println(mot.getLastItv());
        System.out.println("\nRemaining time until fine: "+ mot.timeRemaining());
        System.out.println(mot.checkPassedItv() + " - expected value = true");
    }

    private void testerMotorcycleItvNotPassed4Years(){
        Person kevin = new Person ("Kevin de la Coba", 30); 
        kevin.setLicense(new License(PermitKind.C1));
        Vehicle mot = new Motorcycle("Ducati", 2016, "5643 KOI", true, kevin);

        // Passing the ITV
        Garage garage = new Garage("Garage", "Calle de los albaricoques, 12", "Madrid");
        LocalDate date = LocalDate.now().minusYears(3);
        Itv itv = new Itv(date, garage, "Se cuida bien");
        mot.passItv(itv);

		System.out.println("=================\n2.Test: Motorcycle bought in 2016, ITV passed 3 years ago");
        System.out.println(mot);
        System.out.println("\nLast itv passed: ");
        System.out.println(mot.getLastItv());
        System.out.println("\nRemaining time until fine: "+ mot.timeRemaining());
        System.out.println(mot.checkPassedItv() + " - expected value = false");
    }

    private void testerMotorcycleItvPassed4Years(){
        Person kevin = new Person ("Kevin de la Coba", 30); 
        kevin.setLicense(new License(PermitKind.C1));
        Vehicle mot = new Motorcycle("Ducati", 2016, "5643 KOI", true, kevin);
        
        // Passing the ITV
        Garage garage = new Garage("Garage", "Calle de los albaricoques, 12", "Madrid");
        LocalDate date = LocalDate.now().minusYears(1);
        Itv itv = new Itv(date, garage, "Se cuida bien");
        mot.passItv(itv);
        
		System.out.println("=================\n3.Test: Motorcycle bought in 2018, ITV passed 1 years ago");
        System.out.println(mot);
        System.out.println("\nLast itv passed: ");
        System.out.println(mot.getLastItv());
        System.out.println("\nRemaining time until fine: "+ mot.timeRemaining());
        System.out.println(mot.checkPassedItv() + " - expected value = true");
    }
    
    private void testerMotorcycleItvPassedMoreThan10Years(){
        Person kevin = new Person ("Kevin de la Coba", 30); 
        kevin.setLicense(new License(PermitKind.C1));
        Vehicle mot = new Motorcycle("Ducati", 2008, "5643 KOI", true, kevin);
        
        // Passing the ITV
        Garage garage = new Garage("Garage", "Calle de los albaricoques, 12", "Madrid");
        LocalDate date = LocalDate.now().minusMonths(7);
        Itv itv = new Itv(date, garage, "Se cuida bien");
        mot.passItv(itv);
        
        System.out.println("=================\n4.Test: Motorcycle bought in 2008, ITV passed 7 months ago");
        System.out.println("\nLast itv passed: ");
        System.out.println(itv);
        System.out.println("\nRemaining time until fine: "+ mot.timeRemaining());
        System.out.println(mot.checkPassedItv() + " - expected value = true");
    }

    private void testerMotorcycleItvNotPassedMoreThan10Years(){
        Person kevin = new Person ("Kevin de la Coba", 30); 
        kevin.setLicense(new License(PermitKind.C1));
        Vehicle mot = new Motorcycle("Ducati", 2008, "5643 KOI", true, kevin);
        
        // Passing the ITV
        Garage garage = new Garage("Garage", "Calle de los albaricoques, 12", "Madrid");
        LocalDate date = LocalDate.now().minusYears(2);
        Itv itv = new Itv(date, garage, "Se cuida bien");
        mot.passItv(itv);

        System.out.println("=================\n5.Test: Motorcycle bought in 2008, ITV passed 2 years ago");
        System.out.println("\nLast itv passed: ");
        System.out.println(itv);
        System.out.println("\nRemaining time until fine: "+ mot.timeRemaining());
        System.out.println(mot.checkPassedItv() + " - expected value = false");
    }

    /* ============================ Checking the Fines with ITV ============================  */
    private void FineToACarWithoutITV(){
        Person kevin = new Person ("Kevin de la Coba", 30); 
        Person marcos = new Person ("Marcos Aarón Bernuy", 30); 
        kevin.setLicense(new License(PermitKind.C1, PermitKind.A, PermitKind.B));
        marcos.setLicense(new License(PermitKind.C1, PermitKind.A, PermitKind.B));
        Vehicle car = new Car("Lamborghini", 2008, "1245 HYN", true, kevin);
        Vehicle mot = new Motorcycle("Ducati", 2008, "5643 KOI", true, marcos);
        Vehicle truck = new Truck("TractorAmarillo", 2008, "0987 ETG", 2, kevin);
        Vehicle mot2 = new Motorcycle("Ducato", 2008, "ADV2 ADF", true, marcos);

        Vehicle fleet[] = {
            car,
            mot, //Loses 1 + 1
            truck, //Loses 12
            mot2 //2
        };

        // Passing the ITV
        Garage garage = new Garage("Garage", "Calle de los albaricoques, 12", "Madrid");
        LocalDate date = LocalDate.now().minusMonths(3);
        Itv itv = new Itv(date, garage, "Se cuida bien");
        truck.passItv(itv);
        mot2.passItv(itv);

        // ITV BAD
        LocalDate date2 = LocalDate.now().minusYears(10);
        Itv itv2 = new Itv(date2, garage, "Se cuida bien");
        car.passItv(itv2);
        mot.passItv(itv2);

        System.out.println("=================\n1.Test: The Lamborghini and the Ducati didn't pass the ITV.");
        System.out.println("\nRemaining time until fine: "+ car.timeRemaining());
        System.out.println(car.checkPassedItv() + " - expected value = false\n");
        
        FineProcessor pm = new FineProcessor(Arrays.asList(fleet));
		pm.process(FineReader.read("fines_radar1.txt"));
    }


    public static void main (String[] args){
        TesterITV tester = new TesterITV();
        System.out.println("\n==================Testing Trucks==================");
        tester.testerTruckItvNotPassed0Years();
        tester.testerTruckItvNotPassed2Years();
        tester.testerTruckItvPassed2Years();
        tester.testerTruckItvPassed6Years();
        tester.testerTruckItvNotPassed6Years();
        tester.testerTruckItvPassed10Years();
        tester.testerTruckItvNotPassed10Years();
        tester.testerTruckItvPassedMoreThan10Years();
        tester.testerTruckItvNotPassedMoreThan10Years();

        System.out.println("\n==================Testing Cars==================");
        tester.testerCarItvNotPassed0Years();
        tester.testerCarItvNotPassed4Years();
        tester.testerCarItvPassed4Years();
        tester.testerCarItvPassedMoreThan10Years();
        tester.testerCarItvNotPassedMoreThan10Years();
        
        System.out.println("\n==================Testing Motorcycles==================");
        tester.testerMotorcycleItvNotPassed0Years();
        tester.testerMotorcycleItvNotPassed4Years();
        tester.testerMotorcycleItvPassed4Years();
        tester.testerMotorcycleItvPassedMoreThan10Years();
        tester.testerMotorcycleItvNotPassedMoreThan10Years();

        System.out.println("\n==================Testing Fines with ITV==================");
        tester.FineToACarWithoutITV(); 
        return;
    }
}