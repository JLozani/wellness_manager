import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class WellnessManagerView extends JFrame {
   private Container content;
   private CardLayout pages;
   private WellnessManagerViewStart start;
   private WellnessManagerViewLog log;
   private WellnessManagerViewAdd add;
   private WellnessManagerViewAddItem addItem;
   private WellnessManagerViewAddRecipe addRecipe;
   
   public WellnessManagerView() {
      super("Wellness Manager");
      
      content = getContentPane();
      
      pages = new CardLayout(20, 20);
      
      start = new WellnessManagerViewStart();
      log = new WellnessManagerViewLog();
      add = new WellnessManagerViewAdd();
      addItem = new WellnessManagerViewAddItem();
      addRecipe = new WellnessManagerViewAddRecipe();
      
      content.setLayout(pages);
      
      content.add("start", start);
      content.add("log", log);
      content.add("add", add);
      content.add("item", addItem);
      content.add("recipe", addRecipe);
      
      setSize(500, 400);
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
   
   public void setWellnessActionListener(ActionListener wellnessListener) {
      start.setWellnessActionListener(wellnessListener);
      log.setWellnessActionListener(wellnessListener);
      add.setWellnessActionListener(wellnessListener);
      addItem.setWellnessActionListener(wellnessListener);
      addRecipe.setWellnessActionListener(wellnessListener);
   }
   
   public void setWellnessWindowAdapter(WindowAdapter wellnessAdapter) {
      this.addWindowListener(wellnessAdapter);
   }
}