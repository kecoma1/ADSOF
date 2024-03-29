package pr4.races;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import pr4.vehicles.*;
import pr4.components.*;
import pr4.exceptions.RaceException;
import pr4.exceptions.InvalidComponentException;

/**
 * Class to create a race from a file.
 * @author Kevin de la Coba and Marcos Bernuy.
 */
public class RaceReader {
    
    /**
     * Method to read a file and create a race
     * @param filename File to be created
     * @return Race created
     * @throws RaceException Race exception
     * @throws IOException Exception thrown when the file is read
     */
    public static Race read(String filename) throws RaceException, IOException { 
        // Creating the necesary objects to read a file
        FileInputStream stream = new FileInputStream(filename);
        InputStreamReader reader = new InputStreamReader(stream);
        BufferedReader buffer = new BufferedReader(reader);
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        
        // Storing each line
        String line;

        // Reading the length
        line = buffer.readLine();
        double length = Double.parseDouble(line);

        // Reading participants
        while ((line = buffer.readLine()) != null){
            // Components
            boolean bananaDispenser = false;
            boolean engine = false;
            boolean window = false;
            boolean wheels = false;
            
            String[] split = line.split(" ");
            String quantityStr = split[0];
            String maxSpeedStr = split[2];
            int quantity = Integer.parseInt(quantityStr);
            double maxSpeed = Double.parseDouble(maxSpeedStr);

            int i = 0;
            int j = 0;

            if (length <= maxSpeed) throw new RaceException("The race length is too short");
            
            // Making a loop to create all the Cars expected
            if (split[1].equals("Car")){
                for (String s : split) {
                    i++;
                    if (i <= 3) continue;

                    // Checking which components have the car
                    if (s.equals("BananaDispenser")) bananaDispenser = true;
                    else if (s.equals("Engine")) engine = true;
                    else if (s.equals("Window")) window = true;
                    else if (s.equals("Wheels")) wheels = true;
                }

                // Creating the requested vehicles
                while(j<quantity) {
                    Car c = new Car(maxSpeed, 0.0);
                    
                    // Adding components
                    try {
                        if (engine) c.addComponent(new Engine(c));
                    } catch(InvalidComponentException e) {
                        System.out.println(e.getError());
                    }
                    
                    try {
                        if (window) c.addComponent(new Window(c));
                    } catch(InvalidComponentException e) {
                        System.out.println(e.getError());
                    }

                    try {
                        if (bananaDispenser) c.addComponent(new BananaDispenser(c));
                    } catch(InvalidComponentException e) {
                        System.out.println(e.getError());
                    }

                    try {
                        if (wheels) c.addComponent(new Wheels(c));
                    } catch(InvalidComponentException e) {
                        System.out.println(e.getError());
                    }

                    vehicles.add(c);
                    j++;
                }
            }

            // Making a loop to create all the Trucks expected
            if (split[1].equals("Truck")){
                for (String s : split) {
                    i++;
                    if (i <= 3) continue;

                    // Checking which components have the car
                    if (s.equals("BananaDispenser")) bananaDispenser = true;
                    else if (s.equals("Engine")) engine = true;
                    else if (s.equals("Window")) window = true;
                    else if (s.equals("Wheels")) wheels = true;
                }

                // Creating the requested vehicles
                while(j<quantity){
                    Truck t = new Truck(maxSpeed, 0.0);
                    
                    // Adding components
                    try {
                        if (engine) t.addComponent(new Engine(t));
                    } catch(InvalidComponentException e) {
                        System.out.println(e.getError());
                    }
                    
                    try {
                        if (window) t.addComponent(new Window(t));
                    } catch(InvalidComponentException e) {
                        System.out.println(e.getError());
                    }                  

                    try {
                        if (bananaDispenser) t.addComponent(new BananaDispenser(t));
                    } catch(InvalidComponentException e) {
                        System.out.println(e.getError());
                    }

                    try {
                        if (wheels) t.addComponent(new Wheels(t));
                    } catch(InvalidComponentException e) {
                        System.out.println(e.getError());
                    }

                    vehicles.add(t);
                    j++;
                }
            }

            //Making a loop to create all the Motorcycles expected
            if (split[1].equals("Motorcycle")){
                for (String s : split) {
                    i++;
                    if (i <= 3) continue;

                    // Checking which components have the car
                    if (s.equals("BananaDispenser")) bananaDispenser = true;
                    else if (s.equals("Engine")) engine = true;
                    else if (s.equals("Window")) window = true;
                    else if (s.equals("Wheels")) wheels = true;
                }

                // Creating the requested vehicles
                while(j<quantity){
                    Motorcycle m = new Motorcycle(maxSpeed, 0.0);
                    
                    // Adding components
                    try {
                        if (engine) m.addComponent(new Engine(m));
                    } catch(InvalidComponentException e) {
                        System.out.println(e.getError());
                    }

                    try {
                        if (window) m.addComponent(new Window(m));
                    } catch(InvalidComponentException e) {
                        System.out.println(e.getError());
                    }

                    try {
                        if (bananaDispenser) m.addComponent(new BananaDispenser(m));
                    } catch(InvalidComponentException e) {
                        System.out.println(e.getError());
                    }

                    try {
                        if (wheels) m.addComponent(new Wheels(m));
                    } catch(InvalidComponentException e) {
                        System.out.println(e.getError());
                    }

                    vehicles.add(m);
                    j++;
                }
            }
        }
        buffer.close();

        if (vehicles.size() < 2) throw new RaceException("There are not enough vehicles in the race");
        else if (vehicles.size() > 10) throw new RaceException("There are too many vehicles in the race");

        return new Race(length, vehicles);
    }
}