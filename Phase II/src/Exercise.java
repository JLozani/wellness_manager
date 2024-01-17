public class Exercise {
   private String name;
   private double calories;
   
   public Exercise(String _name, double _calories) {
      name = _name;
      calories = _calories;
   }
   
   public String getName() { return name; }
   
   public double getCalories(double time, double weight) {
      return calories * (weight / 100.0) * (time / 60.0);
   }
   
   public String toString() {
      return String.format("e,%s,%.1f", name, calories);
   }
}