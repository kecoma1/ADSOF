package pr4.races;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import pr4.vehicles.Car;
import pr4.vehicles.Vehicle;

/**
 * Class to create a race from a file.
 * @author Kevin de la Coba and Marcos Bernuy.
 */
public class RaceReader {
    
    /**
     * Method to read a file and create a race
     * @param filename File to be created
     * @return Race created
     */
    public static Race read(String filename) { 
        try {
            // Creating the necesary objects to read a file
            FileInputStream stream = new FileInputStream(filename);
            InputStreamReader reader = new InputStreamReader(stream);
            BufferedReader buffer = new BufferedReader(reader);


            // Race to be returned
            Race race;
            
            // Storing each line
            String line;

            // Reading the length
            line = buffer.readLine();
            int length = Integer.parseInt(line);

            // Reading participants
            while ((line = buffer.readLine()) != null){
                String quantityStr = line.split(" ")[0];
                String maxSpeedStr = line.split(" ")[2];
                int quantity = Integer.parseInt(quantityStr);
                int maxSpeed = Integer.parseInt(maxSpeedStr);

                int i = 0;
                int j = 0;
                Vehicle vehicle;            
                
                // Parsing each word in the line
                for (String word : line.split(" ")){
                    words[i] = word;
                    i++;
                }

                //Making a loop to create all the Cars expected
                if (word[1].equals("Car")){
                    while(j<Integer.parseInt(word[0])){
                        vehicle = new Car(Integer.parseInt(word[2]));
                        vehicles.add(vehicle);
                        j++;
                    }
                }

                //Making a loop to create all the Trucks expected
                if (word[1].equals("Truck")){
                    while(j<Integer.parseInt(word[0])){
                        vehicle = new Truck(Integer.parseInt(word[2]));
                        vehicles.add(vehicle);
                        j++;
                    }
                }

                //Making a loop to create all the Motorcycles expected
                if (word[1].equals("Motorcycle")){
                    while(j<Integer.parseInt(word[0])){
                        vehicle = new Motorcycle(Integer.parseInt(word[2]));
                        vehicles.add(vehicle);
                        j++;
                    }
                }
            }

            race = new Race(length, vehicles);

            buffer.close();
            return race;
        } catch(IOException e) { return null; }
    }

    public void buildCars(int quantity, int maxSpeed, List<Vehicle> participants) {
        for (int i = 0; i < quantity; i++) {
            participants.add(new Car(maxSpeed, 0.0));
        }
    }
}