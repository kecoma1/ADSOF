package pr3.traffic.ITV;

import java.util.LocalDate;

/**
 * Class that defines an ITV
 * @author Kevin de la Coba Malam and Marcos Aarón Bernuy
 */
public class ITV {
   private LocalDate date;
   private Garage garage;
   private String comments;

   /**
    * Constructor of the ITV class
    * @param garage Garage where the ITV was done
    * @param comments Comments on the ITV
    */
   public ITV(Garage garage, String comments) {
        this.date = LocalDate.now();
        this.garage = garage;
        this.comments = comments;
   }

   /**
    * Getter of the date
    * @return Date of the ITV
    */
   public LocalDate getDate() { return this.date; }

   /**
    * Getter of the garage
    * @return Garage where the ITV was done
    */
   public Garage getGarage() { return this.garage; }

   /**
    * Getter of the Comments
    * @return String Comments on the ITV
    */
   public String getComments() { return this.comments; }

   
}