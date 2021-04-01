package pr3.traffic.itvs;
import pr3.traffic.itvs.*;
import pr3.traffic.fines.*;
import pr3.traffic.drivers.*;
import pr3.traffic.license.*;
import pr3.traffic.vehicles.*;
import java.time.LocalDate;

/**
 * Class to test the ITV implemented
 * @author Kevin de la Coba Malam and Marcos Aarón Bernuy
 */
public class TesterITV{

    public void testerTruckItvNotPassed2Years(){
        Person kevin = new Person ("Kevin de la Coba", 30); 
        kevin.setLicense(new License(PermitKind.C1));
        Vehicle truck = new Truck("IvecoDaily", 2021, "5643 KOI", 2, kevin);
        
        Garage garage = new Garage("Garage", "Calle de los albaricoques, 12", "Madrid");
        LocalDate date = LocalDate.now().minusYears(3);
        Itv itv = new Itv(date, garage, "Se cuida bien");
        truck.passItv(itv);
        System.out.println(truck);
        System.out.println("\nLast itv passed: ");
        System.out.println(itv);
        System.out.println(truck.checkPassedItv() + "expected value = false");
    }

    public void testerTruckItvNotPassed6Years(){
        Person kevin = new Person ("Kevin de la Coba", 30); 
        kevin.setLicense(new License(PermitKind.C1));
        Vehicle truck = new Truck("IvecoDaily", 2016, "5643 KOI", 2, kevin);
        
        Garage garage = new Garage("Garage", "Calle de los albaricoques, 12", "Madrid");
        LocalDate date = LocalDate.now().minusYears(3);
        Itv itv = new Itv(date, garage, "Se cuida bien");
        truck.passItv(itv);
        System.out.println(truck);
        System.out.println("\nLast itv passed: ");
        System.out.println(itv);
        System.out.println(truck.checkPassedItv() + "expected value = false");
    }

    public void testerTruckItvNotPassed10Years(){
        Person kevin = new Person ("Kevin de la Coba", 30); 
        kevin.setLicense(new License(PermitKind.C1));
        Vehicle truck = new Truck("IvecoDaily", 2010, "5643 KOI", 2, kevin);
        
        Garage garage = new Garage("Garage", "Calle de los albaricoques, 12", "Madrid");
        LocalDate date = LocalDate.now().minusYears(4);
        Itv itv = new Itv(date, garage, "Se cuida bien");
        truck.passItv(itv);
        System.out.println(truck);
        System.out.println("\nLast itv passed: ");
        System.out.println(itv);
        System.out.println(truck.checkPassedItv() + "expected value = false");
    }

    public void testerTruckItvNotPassedMoreThan10Years(){
        Person kevin = new Person ("Kevin de la Coba", 30); 
        kevin.setLicense(new License(PermitKind.C1));
        Vehicle truck = new Truck("IvecoDaily", 2010, "5643 KOI", 2, kevin);
        
        Garage garage = new Garage("Garage", "Calle de los albaricoques, 12", "Madrid");
        LocalDate date = LocalDate.now().minusYears(4);
        Itv itv = new Itv(date, garage, "Se cuida bien");
        truck.passItv(itv);
        System.out.println(truck);
        System.out.println("\nLast itv passed: ");
        System.out.println(itv);
        System.out.println(truck.checkPassedItv() + "expected value = false");
    }

    public void main (){
        this.testerTruckItvNotPassed2Years();
    }
}