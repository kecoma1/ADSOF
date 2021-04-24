package pr4.powerups;

public class AttackAll implements IPowerUp {

    public void applyPowerUp(IVehicle v){



        System.out.println("Vehicle: "+v.getName()+" applying power-up: "+this.namePowerUp);
    }

    public String namePowerUp(){
        return "AttackAllPowerUp";
    }
}