import java.util.ArrayList;
import java.util.Collection;
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
      
      calcNutrition();
   }
   
   public HashMap<FoodComponent, Double> getChildren() { return items; }
   
   public void add(FoodComponent item, double amount) {
      items.put(item, amount);
      calcNutrition();
   }
   
   public void remove(FoodComponent item) {
      items.remove(item);
      calcNutrition();
   }
   
   private void calcNutrition() {
      nutrition = new ArrayList<Double>(Arrays.asList(0.0, 0.0, 0.0, 0.0));
      
      for(FoodComponent item : items.keySet()) {
         ArrayList<Double> tempNutrition = item.getNutrition();
         
         for(int i = 0; i < 4; i++) {
            nutrition.set(i, nutrition.get(i) + tempNutrition.get(i) * items.get(item));
         }
      }
   }
   
   public String toString() {
      String temp = "r," + getName();
      
      for(Map.Entry<FoodComponent, Double> entry : items.entrySet()) {
         temp += String.format(",%s,%.1f", entry.getKey().getName(), entry.getValue());
      }
      
      return temp;
   }
}