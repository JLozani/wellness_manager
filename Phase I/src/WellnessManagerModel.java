import java.io.*;
import java.util.*;
import java.sql.*;

public class WellnessManagerModel {
   double weight;
   double calories;
   
   public String fileFoodName;
   public String fileLogName;
   
   ArrayList<FoodComponent> foodList;
   ArrayList<String> logList;
   
   public WellnessManagerModel() {
      fileFoodName = "food.csv";
      fileLogName = "log.csv";
      
      weight = 150.0;
      calories = 2000.0;
      
      foodList = new ArrayList<FoodComponent>();
      logList = new ArrayList<String>();
   }
    
   public void init() {
      readFood();
      readLog();
   }
   
   private void readFood() {
      try {
         BufferedReader csvReader = new BufferedReader(new FileReader(fileFoodName));
         String line;
         
         while ((line = csvReader.readLine()) != null) {
            if(line.substring(0, 1).equals("b")) {
               String[] temp = line.split(",");
               
               ArrayList<Double> tempList = new ArrayList<Double>();
               
               for(int i = 2; i < temp.length; i++) {
                  tempList.add(Double.parseDouble(temp[i]));
               }
               
               foodList.add(new FoodItem(temp[1], tempList));
            } else {
               String[] temp = line.split(",");
               
               HashMap<FoodComponent, Double> tempMap = new HashMap<FoodComponent, Double>();
               
               for(int i = 2; i < temp.length; i = i + 2) {
                  tempMap.put(getFoodComponent(temp[i]), Double.parseDouble(temp[i + 1]));
               }
               
               foodList.add(new FoodRecipe(temp[1], tempMap));
            }
         }
         
         csvReader.close();
      } catch(Exception e) { System.out.println("Error reading food.csv file: " + e.getMessage()); }
   }
   
   private FoodComponent getFoodComponent(String name) {
      for(FoodComponent comp : foodList) {
         if(comp.getName().equals(name)) {
            return comp;
         }
      }
      
      System.out.println("Couldn't find FoodComponent!");
      
      return null;
   }
   
   private void readLog() {
      try {
         BufferedReader csvReader = new BufferedReader(new FileReader(fileLogName));
         String line;
         
         while ((line = csvReader.readLine()) != null) {
            logList.add(line);
         }
         
         csvReader.close();
      } catch(Exception e) { System.out.println("Error reading log.csv file: " + e.getMessage()); }
   }
   
   public void save() {
      saveFood();
      saveLog();
   }
   
   private void saveFood() {
      try{
         PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("food.csv")));
         
         for(FoodComponent item : foodList) {
            pw.print(item.toString() + System.lineSeparator());
            pw.flush();
         }
         
         pw.close();
      } catch(Exception e) { System.out.println("Error writing to food.csv file: " + e.getMessage()); }
   }
   
   private void saveLog() {
      try{
         PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("log.csv")));
         
         for(String line : logList) {
            pw.print(line + System.lineSeparator());
            pw.flush();
         }
         
         pw.close();
      } catch(Exception e) { System.out.println("Error writing to log.csv file: " + e.getMessage()); }
   }
   
   public String getLog(String date) {
      String tempIntake = "Intake log:";
      String tempWeight = "The recorded weight is: 150.0";
      String tempCalories = "The calorie limit is: 2000.0";

      for(String line : logList) {
         if(line.substring(0, 10).equals(date)) {
            if(line.substring(11, 12).equals("f")) {
               String[] tempItem = line.substring(13, line.length()).split(",");
               
               tempIntake += "\n\tName: " + tempItem[0] + "  Amount: " + tempItem[1];
            } else if(line.substring(11, 12).equals("c")) {
               calories = Double.parseDouble(line.substring(13, line.length()));
               tempCalories = "The calorie limit is: " + calories;
            } else {
               weight = Double.parseDouble(line.substring(13, line.length()));
               tempWeight = "The recorded weight is: " + weight;
            }
         } 
      }
      
      return tempWeight + "\n\n" + tempCalories + "\n\n" + tempIntake;
   }
   
   public double getWeight() { return weight; }
   
   public double getCalories() { return calories; }
}