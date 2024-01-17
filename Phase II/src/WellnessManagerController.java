import java.awt.event.*;
import javax.swing.JButton;

public class WellnessManagerController {
   private WellnessManagerView theView;
   private WellnessManagerModel theModel;
   
   public WellnessManagerController(WellnessManagerView _theView, WellnessManagerModel _theModel) {
      theView = _theView;
      theModel = _theModel;
      
      theView.setWellnessActionListener(new WellnessActionListener());
      theView.setWellnessWindowAdapter(new WellnessWindowAdapter());
      
      init();
   }
   
   private void init() {
      theModel.init();
      theView.setLog(theModel.getLog(theView.getDate()));
      theView.setDetails(theModel.getWeight(), theModel.getCalories());
   }
   
   class WellnessActionListener implements ActionListener {
      public void actionPerformed(ActionEvent event) {
         switch(((JButton)event.getSource()).getText()) {
            case "Home":
               theView.show("start");
               break;
            case "Back":
               theView.show("add");
               break;
            case "Daily log":
               theView.show("log");
               break;
            case "Add food":
               theView.show("entry");
               break;
            case "Add exercise":
               theView.show("exercise");
               break;
            case "Delete entry":
               theView.setBox(theModel.getLogList(theView.getDate()));
               theView.show("delete");
               break;
            case "Save":
               theModel.addEntry(theView.getEntry());
               theView.setLog(theModel.getLog(theView.getDate()));
               theView.show("log");
               break;
            case "Save exercise":
               theModel.addEntry(theView.getExerciseEntry());
               theView.setLog(theModel.getLog(theView.getDate()));
               theView.show("log");
               break;
            case "Delete":
               theModel.deleteEntry(theView.getSelectedLog());
               theView.setLog(theModel.getLog(theView.getDate()));
               theView.setDetails(theModel.getWeight(), theModel.getCalories());
               theView.show("log");
               break;
            case "Go":
               theView.setLog(theModel.getLog(theView.getDate()));
               theView.setDetails(theModel.getWeight(), theModel.getCalories());
               break;
            case "Set":
               theModel.setDetails(theView.getWeight(), theView.getCalories(), theView.getDate());
               init();
               break;
            case "Add a food item/recipe":
               theView.show("add");
               break;
            case "Add new food item":
               theView.show("item");
               break;
            case "Add new food recipe":
               theView.show("recipe");
               break;
            case "Add item":
               theModel.addItem(theView.getItemDetails());
               theView.show("add");
               break;
            case "Add recipe":
               theModel.addRecipe(theView.getRecipeDetails());
               theView.show("add");
               break;
            case "Go to daily log":
               theView.show("log");
               break;
            default:
               theModel.save(); 
               
               System.exit(0);
         }
      }
   }
   
   class WellnessWindowAdapter extends WindowAdapter {
      public void windowClosing(WindowEvent e) {
         theModel.save();
         
         System.exit(0);
      }
   }
}