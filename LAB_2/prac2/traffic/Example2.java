package prac2.traffic;
public class Example2 {
    public static void main(String[] args) {
        Car fiat500x = new Car("Fiat 500x", 2019, "1245 HYN", true);

        Motorcycle moto1 = new Motorcycle("Harley David", 2003, "0987 ETG", false);
        Motorcycle moto2 = new Motorcycle("Torrot Muvi", 2015, "9023 MCV", true);

        Truck camion1 = new Truck("MAN TGA410", 2000, "M-3456-JZ", 3);
        Truck camion2 = new Truck("Iveco Daily", 2010, "5643 KOI", 2);

        Vehicle [] vehicles = { fiat500x, moto1, moto2, camion1, camion2 };

        for (Vehicle v: vehicles)
            System.out.println(v);
    }
}
