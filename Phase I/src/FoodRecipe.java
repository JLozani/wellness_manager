import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;
import java.util.Set;

public class FoodRecipe extends FoodComponent {
   public FoodRecipe(String name) {
      super(name);
      
      items = new HashMap<FoodComponent, Double>();
   }
   
   public FoodRecipe(String name, HashMap<FoodComponent, Double> items) {
      super(name, items);
      
      calcNutrition(items.keySet());
   }
   
   public HashMap<FoodComponent, Double> getChildren() { return items; }
   
   public void add(FoodComponent item, double amount) {
      items.put(item, amount);
   }
   
   public void remove(FoodComponent item) {
      items.remove(item);
   }
   
   private void calcNutrition(Set<FoodComponent> items) {
      ArrayList<Double> tempValues = null;
      ArrayList<Double> tempNutrition = new ArrayList<Double>(Arrays.asList(1.0, 1.0, 1.0, 1.0));
      
      for(FoodComponent item : items) {
         if(item instanceof FoodRecipe) {
            calcNutrition(item.getChildren().keySet());
         } else {
            tempValues = item.getNutrition();
            
            for(int i = 0; i < 4; i++) {
               tempNutrition.set(i, tempNutrition.get(i) * tempValues.get(i));
            }
         }
      }
      
      nutrition = tempNutrition;
   }
   
   public String toString() {
      String temp = "r," + getName();
      
      for(Map.Entry<FoodComponent, Double> entry : items.entrySet()) {
         temp += String.format(",%s,%.1f", entry.getKey().getName(), entry.getValue());
      }
      
      return temp;
   }
}