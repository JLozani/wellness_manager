import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.ArrayList;

public class WellnessManagerView extends JFrame {
   private Container content;
   private CardLayout pages;
   private WellnessManagerViewStart start;
   private WellnessManagerViewLog log;
   private WellnessManagerViewAdd add;
   private WellnessManagerViewAddItem addItem;
   private WellnessManagerViewAddRecipe addRecipe;
   private WellnessManagerViewAddEntry addEntry;
   private WellnessManagerViewAddExerciseEntry addExerciseEntry;
   private WellnessManagerViewDeleteEntry deleteEntry;
   
   public WellnessManagerView() {
      super("Wellness Manager");
      
      content = getContentPane();
      
      pages = new CardLayout(20, 20);
      
      start = new WellnessManagerViewStart();
      log = new WellnessManagerViewLog();
      add = new WellnessManagerViewAdd();
      addItem = new WellnessManagerViewAddItem();
      addRecipe = new WellnessManagerViewAddRecipe();
      addEntry = new WellnessManagerViewAddEntry();
      addExerciseEntry = new WellnessManagerViewAddExerciseEntry();
      deleteEntry = new WellnessManagerViewDeleteEntry();
      
      content.setLayout(pages);
      
      content.add("start", start);
      content.add("log", log);
      content.add("add", add);
      content.add("item", addItem);
      content.add("recipe", addRecipe);
      content.add("entry", addEntry);
      content.add("exercise", addExerciseEntry);
      content.add("delete", deleteEntry);
      
      setSize(500, 600);
      setVisible(true);
   }
   
   public void show(String pageName) {
      SwingUtilities.invokeLater(
         new Runnable() {
            public void run() {
               pages.show(content, pageName);
            }
         });
   }
   
   public String getDate() {
      return log.getDate();
   }
   
   public void setLog(String logText) {
      log.setLog(logText);
   }
   
   public void setDetails(double weightValue, double caloriesValue) {
      log.setDetails(weightValue, caloriesValue);
   }
   
   public double getWeight() {
      return log.getWeight();
   }
   
   public double getCalories() {
      return log.getCalories();
   }
   
   public String getEntry() {
      return String.format("%s,%s", getDate(), addEntry.getEntry());
   }
   
   public String getExerciseEntry() {
      return String.format("%s,%s", getDate(), addExerciseEntry.getExerciseEntry());
   }
   
   public void setBox(ArrayList<String> logs) {
      deleteEntry.setBox(logs);
   }
   
   public String getSelectedLog() {
      return deleteEntry.getSelectedLog();
   }
   
   public String getItemDetails() {
      return addItem.getItemDetails();
   }
   
   public String getRecipeDetails() {
      return addRecipe.getRecipeDetails();
   }
   
   public void setWellnessActionListener(ActionListener wellnessListener) {
      start.setWellnessActionListener(wellnessListener);
      log.setWellnessActionListener(wellnessListener);
      add.setWellnessActionListener(wellnessListener);
      addItem.setWellnessActionListener(wellnessListener);
      addRecipe.setWellnessActionListener(wellnessListener);
      addEntry.setWellnessActionListener(wellnessListener);
      addExerciseEntry.setWellnessActionListener(wellnessListener);
      deleteEntry.setWellnessActionListener(wellnessListener);
   }
   
   public void setWellnessWindowAdapter(WindowAdapter wellnessAdapter) {
      this.addWindowListener(wellnessAdapter);
   }
}