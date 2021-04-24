package pr4.powerups;

public class Swap implements IPowerUp{

    public void applyPowerUp(IVehicle v){
        Vehicle opponent = v.getClosestOpponentTo();
        Double pos = opponent.getActualPosition();
        opponent.setActualPosition(v.getActualPosition());
        v.setActualPosition(pos);
        System.out.println("Vehicle: "+v.getName()+" applying power-up: "+this.namePowerUp);
    }

    public String namePowerUp(){
        return "SwapPowerUp";
    }
}