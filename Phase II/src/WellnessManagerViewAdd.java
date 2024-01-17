import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import java.awt.Font;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.*;

public class WellnessManagerViewAdd extends JPanel {
   private JButton back, item, recipe, log;
   
   public WellnessManagerViewAdd() {
      super();
      
      setLayout(new GridLayout(5, 1, 0, 15));
      
      JPanel headerPanel = new JPanel(new GridLayout(1, 3));
      JPanel backPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
      JPanel titlePanel = new JPanel();
      JLabel heading = new JLabel("Add food");
      JLabel subHeading = new JLabel("Choose an option:");
      back = new JButton("Home");
      item = new JButton("Add new food item");
      recipe = new JButton("Add new food recipe");
      log = new JButton("Go to daily log");
      
      heading.setHorizontalAlignment(SwingConstants.CENTER);
      heading.setVerticalAlignment(SwingConstants.CENTER);
      heading.setFont(new Font(heading.getFont().getName(), heading.getFont().getStyle(), 24));
      
      subHeading.setHorizontalAlignment(SwingConstants.CENTER);
      subHeading.setVerticalAlignment(SwingConstants.CENTER);
      subHeading.setFont(new Font(subHeading.getFont().getName(), subHeading.getFont().getStyle(), 18));
      
      backPanel.add(back);
      
      titlePanel.add(heading);
      
      headerPanel.add(backPanel);
      headerPanel.add(titlePanel);
      headerPanel.add(new JLabel());
      
      add(headerPanel);
      add(subHeading);
      add(item);
      add(recipe);
      add(log);
   }
   
   public void setWellnessActionListener(ActionListener wellnessListener) {
      back.addActionListener(wellnessListener);
      item.addActionListener(wellnessListener);
      recipe.addActionListener(wellnessListener);
      log.addActionListener(wellnessListener);
   }
}