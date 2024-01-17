import java.io.*;
import java.util.*;
import java.sql.*;

public class WellnessManagerModel {
   private double weight;
   private double calories;
   
   private String fileFoodName;
   private String fileLogName;
   private String fileExercisesName;
   
   private ArrayList<FoodComponent> foodList;
   private ArrayList<String> logList;
   private ArrayList<Exercise> exercisesList;
   
   public WellnessManagerModel() {
      fileFoodName = "food.csv";
      fileLogName = "log.csv";
      fileExercisesName = "exercise.csv";
      
      weight = 150.0;
      calories = 2000.0;
      
      foodList = null;
      logList = null;
      exercisesList = null;
   }
   
   public void init() {      
      if(foodList == null) {
         foodList = new ArrayList<FoodComponent>();
         logList = new ArrayList<String>();
         exercisesList = new ArrayList<Exercise>();
      } else {
         foodList.clear();
         logList.clear();
         exercisesList.clear();
      }
      
      readFood();
      readLog();
      readExercises();
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
   
   public void readExercises() {
      try {
         BufferedReader csvReader = new BufferedReader(new FileReader(fileExercisesName));
         String line;
         
         while ((line = csvReader.readLine()) != null) {
            String[] temp = line.split(",");
            
            exercisesList.add(new Exercise(temp[1], Double.parseDouble(temp[2])));
         }
         
         csvReader.close();
      } catch(Exception e) { System.out.println("Error reading exercise.csv file: " + e.getMessage()); }
   }
   
   public void save() {
      saveFood();
      saveLog();
      saveExercises();
   }
   
   private void saveFood() {
      try{
         PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(fileFoodName)));
         
         for(FoodComponent item : foodList) {
            pw.print(item.toString() + System.lineSeparator());
            pw.flush();
         }
         
         pw.close();
      } catch(Exception e) { System.out.println("Error writing to food.csv file: " + e.getMessage()); }
   }
   
   private void saveLog() {
      try{
         PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(fileLogName)));
         
         for(String line : logList) {
            pw.print(line + System.lineSeparator());
            pw.flush();
         }
         
         pw.close();
      } catch(Exception e) { System.out.println("Error writing to log.csv file: " + e.getMessage()); }
   }
   
   private void saveExercises() {
      try{
         PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(fileExercisesName)));
         
         for(Exercise exercise : exercisesList) {
            pw.print(exercise.toString() + System.lineSeparator());
            pw.flush();
         }
         
         pw.close();
      } catch(Exception e) { System.out.println("Error writing to exercises.csv file: " + e.getMessage()); }
   }
   
   public String getLog(String date) {
      weight = 150.0;
      calories = 2000.0;
      
      double totalFat = 0;
      double totalCarb = 0;
      double totalProtein = 0;
      double totalCaloriesEaten = 0;
      double totalCaloriesExpended = 0;
      
      String tempIntake = "Intake log:";
      String tempExercises = "Exercises done:";
      String tempWeight = "The recorded weight is: 150.0";
      String tempCalories = "The calorie limit is: 2000.0";
      
      for(String line : logList) {
         if(line.substring(0, 10).equals(date)) {
            if(line.substring(11, 12).equals("c")) {
               calories = Double.parseDouble(line.substring(13, line.length()));
               tempCalories = "The calorie limit is: " + calories;
            } else if(line.substring(11, 12).equals("w")) {
               weight = Double.parseDouble(line.substring(13, line.length()));
               tempWeight = "The recorded weight is: " + weight;
            }
         }
      }

      for(String line : logList) {
         if(line.substring(0, 10).equals(date)) {
            if(line.substring(11, 12).equals("f")) {
               String[] tempItem = line.substring(13, line.length()).split(",");
               Double amount = Double.parseDouble(tempItem[1]);
               
               for(FoodComponent item : foodList) {
                  if(item.getName().equals(tempItem[0])) {
                     totalFat += item.getFat() * amount;
                     totalCarb += item.getCarb() * amount;
                     totalProtein += item.getProtein() * amount;
                     totalCaloriesEaten += item.getCalories() * amount;
                     
                     tempIntake += "\n\tName: " + tempItem[0] + "  Amount: " + amount;
                     
                     break;
                  }
               }
            } else if(line.substring(11, 12).equals("e")) {
               String[] tempItem = line.substring(13, line.length()).split(",");
               Double time = Double.parseDouble(tempItem[1]);
               
               for(Exercise exercise : exercisesList) {
                  if(exercise.getName().equals(tempItem[0])) {
                     totalCaloriesExpended += exercise.getCalories(time, weight);
                     
                     tempExercises += "\n\tName: " + tempItem[0] + "  Time: " + time + "min";
                     
                     break;
                  }
               }
            }
         } 
      }
      
      Double total = totalFat + totalCarb + totalProtein;
      
      if(total != 0) {
         totalFat = Math.round((totalFat / total) * 100.);
         totalCarb = Math.round((totalCarb / total) * 100.);
         totalProtein = 100. - totalFat - totalCarb;
         
         tempIntake += String.format("\n\nBreakdown:\tFats - %.0f%%  Carbs - %.0f%%  Protein - %.0f%%", totalFat, totalCarb, totalProtein);
      }
      
      tempExercises += String.format("\n\nCalories consumed: %.1f\nCalories expended: %.1f\nNet calories: %.1f  (left until limit: %.1f calories)", totalCaloriesEaten, totalCaloriesExpended, totalCaloriesEaten - totalCaloriesExpended, calories - (totalCaloriesEaten - totalCaloriesExpended));
      
      return tempWeight + "\n\n" + tempCalories + "\n\n" + tempIntake + "\n\n" + tempExercises;
   }
   
   public double getWeight() { return weight; }
   
   public double getCalories() { return calories; }
   
   public void setDetails(double _weight, double _calories, String date) {
      setWeight(_weight, date);
      setCalories(_calories, date);
      
      save();
   }
   
   public void setWeight(double _weight, String date) {
      for(String temp : logList) {
         if(temp.substring(11, 12).equals("w") && temp.substring(0, 10).equals(date)) {
            logList.remove(temp);
            
            break;
         }
      }
      
      logList.add(String.format("%s,w,%.1f", date, _weight));
   }
   
   public void setCalories(double _calories, String date) {
      for(String temp : logList) {
         if(temp.substring(11, 12).equals("c") && temp.substring(0, 10).equals(date)) {
            logList.remove(temp);
            
            break;
         }
      }
      
      logList.add(String.format("%s,c,%.1f", date, _calories));
   }
   
   public void addEntry(String entry) {
      logList.add(entry);
   }
   
   public ArrayList<String> getLogList(String date) {
      ArrayList<String> temp = new ArrayList<String>();
      
      for(String log : logList) {
         if(log.substring(0, 10).equals(date)) {
            temp.add(log);
         }
      }
      
      return temp;
   }
   
   public void deleteEntry(String log) {
      logList.remove(log);
   }
   
   public void addItem(String item) {
      String[] itemArray = item.split(",");
      ArrayList<Double> temp = new ArrayList<Double>();
      
      for(int i = 1; i <= 4; i++) {
         temp.add(Double.parseDouble(itemArray[i]));
      }
      
      foodList.add(new FoodItem(itemArray[0], temp));
   }
   
      public void addRecipe(String recipe) {
      String[] recipeArray = recipe.split(",");
      FoodRecipe temp = new FoodRecipe(recipeArray[0]);
      
      for(int i = 1; i < recipeArray.length; i += 2) {
         for(FoodComponent item : foodList) {
            if(item.getName().equals(recipeArray[i])) {
               temp.add(item, Double.parseDouble(recipeArray[i + 1]));
               break;
            }
         }
         
         return;
      }
      
      foodList.add(temp);
   }
}