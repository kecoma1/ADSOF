package pr4.powerups;

import java.util.List;

import pr4.vehicles.IVehicle;
import pr4.vehicles.Vehicle;

/**
 * Class that defines the Attack all power up.
 * @author Kevin de la Coba and Marcos Aarón Bernuy.
 */
public class AttackAll implements IPowerUp {

    public void applyPowerUp(IVehicle v){
        Vehicle vehicle = (Vehicle) v;
        List<Vehicle> participants = vehicle.getRace().getParticipants();
        
        System.out.println("Vehicle: "+v.getName()+" applying power-up: "+this.namePowerUp());

        for (Vehicle participant: participants) { // Attacking all the participants
            double random = 1 + (int)(Math.random() * ((2 - 1) + 1));
            
            if (!participant.equals(vehicle))
                if (random == 1.0) { // Attack
                    vehicle.attack(participant);
                }
        }
    }

    public String namePowerUp(){
        return "AttackAllPowerUp";
    }
}