import java.util.ArrayList;
import java.util.HashMap;

public abstract class FoodComponent {
   private String name;
   protected ArrayList<Double> nutrition;
   protected HashMap<FoodComponent, Double> items;
   
   public FoodComponent(String _name) {
      name = _name;
   }
   
   public FoodComponent(String _name, ArrayList<Double> _nutrition) {
      name = _name;
      nutrition = _nutrition;
   }
   
   public FoodComponent(String _name, HashMap<FoodComponent, Double> _items) {
      name = _name;
      items = _items;
   }
   
   public String getName() { return name; }
   public ArrayList<Double> getNutrition() { return nutrition; }
   
   public Double getCalories() { return nutrition.get(0); }
   public Double getFat() { return nutrition.get(1); }
   public Double getCarb() { return nutrition.get(2); }
   public Double getProtein() { return nutrition.get(3); }
   
   
   public void setName(String _name) { name = _name; }
   public void setNutrition(ArrayList<Double> _nutrition) { nutrition = _nutrition; }
   
   public HashMap<FoodComponent, Double> getChildren() { throw new UnsupportedOperationException(); }
   
   public void add(double nutritionValue) {
      nutrition.add(nutritionValue);
   }
   
   public void add(FoodComponent item, double amount) {
      throw new UnsupportedOperationException();
   }
   
   public void remove(FoodComponent item) {
      throw new UnsupportedOperationException();
   }
   
   public String toString() { return ""; }
}