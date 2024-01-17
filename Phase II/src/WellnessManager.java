public class WellnessManager {
   private WellnessManagerView theView;
   private WellnessManagerModel theModel;
   private WellnessManagerController theController;
   
   public WellnessManager() {
      theModel = new WellnessManagerModel();
      theView = new WellnessManagerView();
      theController = new WellnessManagerController(theView, theModel);
   }
   
   public static void main(String[] args) {
      WellnessManager wellnessManager = new WellnessManager();
   }
}