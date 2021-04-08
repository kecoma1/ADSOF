package pr4.races;

/**
 * Class to create a race from a file.
 * @author Kevin de la Coba and Marcos Bernuy.
 */
public class RaceReader {
    
    
    public static List<Fine> read(String filename) throws Exception { 
        try {
            // Creating the necesary objects to read a file
            FileInputStream stream = new FileInputStream(filename);
            InputStreamReader reader = new InputStreamReader(stream);
            BufferedReader buffer = new BufferedReader(reader);
            
            // List to store the Fines
            List<Fine> vehicles = new ArrayList<>();

            // Race to be returned
            Race race;
            
            // Storing each line
            String line;
            while ((line = buffer.readLine()) != null){
                
                // Getting the first line of the txt
                double length = line[0];
                
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
}