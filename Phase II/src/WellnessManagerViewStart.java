import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;

public class WellnessManagerViewStart extends JPanel {
   private JButton log, add, exit;
   
   public WellnessManagerViewStart() {
      super();
      
      setLayout(new GridLayout(5, 1, 0, 15));
      
      JLabel heading = new JLabel("Welcome to Wellness Manager");
      JLabel subHeading = new JLabel("Choose an option to get started:");
      log = new JButton("Daily log");
      add = new JButton("Add a food item/recipe");
      exit = new JButton("Exit");
      
      heading.setHorizontalAlignment(SwingConstants.CENTER);
      heading.setVerticalAlignment(SwingConstants.CENTER);
      heading.setFont(new Font(heading.getFont().getName(), heading.getFont().getStyle(), 24));
      
      subHeading.setHorizontalAlignment(SwingConstants.CENTER);
      subHeading.setVerticalAlignment(SwingConstants.CENTER);
      subHeading.setFont(new Font(subHeading.getFont().getName(), subHeading.getFont().getStyle(), 16));
      
      add(heading);
      add(subHeading);
      add(log);
      add(add);
      add(exit);
   }
   
   public void setWellnessActionListener(ActionListener wellnessListener) {
      log.addActionListener(wellnessListener);
      add.addActionListener(wellnessListener);
      exit.addActionListener(wellnessListener);
   }
}