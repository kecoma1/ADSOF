package pr3.traffic.itvs;

import java.time.LocalDate;

/**
 * Class that defines an ITV
 * @author Kevin de la Coba Malam and Marcos Aarón Bernuy
 */
public class Itv {
   private LocalDate date;
   private Garage garage;
   private String comments;

   /**
    * Constructor of the ITV class
    * @param garage Garage where the ITV was done
    * @param comments Comments on the ITV
    */
   public Itv(LocalDate date, Garage garage, String comments) {
        this.date = date;
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