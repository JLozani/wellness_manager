import java.util.ArrayList;

public class FoodItem extends FoodComponent {
   public FoodItem(String name) {
      super(name);
      
      nutrition = new ArrayList<Double>();
   }
   
   public FoodItem(String name, ArrayList<Double> nutrition) {
      super(name, nutrition);
   }
   
   public String toString() {
      String temp = "b," + getName();
      
      for(Double item : nutrition) {
         temp += String.format(",%.1f", item);
      }
      
      return temp;
   }
}