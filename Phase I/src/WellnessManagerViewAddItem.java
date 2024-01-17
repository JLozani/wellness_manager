import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Font;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.*;

public class WellnessManagerViewAddItem extends JPanel {
   private JButton back, add;
   private JTextField nameText, caloriesText, fatText, carbText, proteinText;
   
   public WellnessManagerViewAddItem() {
      super();
      
      setLayout(new GridLayout(7, 1, 0, 15));
      
      JPanel headerPanel = new JPanel(new GridLayout(1, 3));
      JPanel backPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
      JPanel titlePanel = new JPanel();
      JPanel namePanel = new JPanel();
      JPanel caloriesPanel = new JPanel();
      JPanel fatPanel = new JPanel();
      JPanel carbPanel = new JPanel();
      JPanel proteinPanel = new JPanel();
      JPanel buttonPanel = new JPanel();
      JLabel heading = new JLabel("New item");
      JLabel name = new JLabel("    Name: ");
      JLabel calories = new JLabel("Calories: ");
      JLabel fat = new JLabel("       Fat: ");
      JLabel carb = new JLabel("     Carb: ");
      JLabel protein = new JLabel(" Protein: ");
      nameText = new JTextField();
      caloriesText = new JTextField();
      fatText = new JTextField();
      carbText = new JTextField();
      proteinText = new JTextField();
      back = new JButton("Back");
      add = new JButton("Add item");
      
      heading.setHorizontalAlignment(SwingConstants.CENTER);
      heading.setVerticalAlignment(SwingConstants.CENTER);
      heading.setFont(new Font(heading.getFont().getName(), heading.getFont().getStyle(), 24));
      
      name.setFont(new Font(name.getFont().getName(), name.getFont().getStyle(), 16));
      calories.setFont(new Font(calories.getFont().getName(), calories.getFont().getStyle(), 16));
      fat.setFont(new Font(fat.getFont().getName(), fat.getFont().getStyle(), 16));
      carb.setFont(new Font(carb.getFont().getName(), carb.getFont().getStyle(), 16));
      protein.setFont(new Font(protein.getFont().getName(), protein.getFont().getStyle(), 16));
      
      nameText.setColumns(15);
      nameText.setHorizontalAlignment(SwingConstants.CENTER);
      nameText.setFont(new Font(nameText.getFont().getName(), nameText.getFont().getStyle(), 16));
      
      caloriesText.setColumns(15);
      caloriesText.setHorizontalAlignment(SwingConstants.CENTER);
      caloriesText.setFont(new Font(caloriesText.getFont().getName(), caloriesText.getFont().getStyle(), 16));
      
      fatText.setColumns(15);
      fatText.setHorizontalAlignment(SwingConstants.CENTER);
      fatText.setFont(new Font(fatText.getFont().getName(), fatText.getFont().getStyle(), 16));
      
      carbText.setColumns(15);
      carbText.setHorizontalAlignment(SwingConstants.CENTER);
      carbText.setFont(new Font(carbText.getFont().getName(), carbText.getFont().getStyle(), 16));
      
      proteinText.setColumns(15);
      proteinText.setHorizontalAlignment(SwingConstants.CENTER);
      proteinText.setFont(new Font(proteinText.getFont().getName(), proteinText.getFont().getStyle(), 16));
      
      backPanel.add(back);
      
      titlePanel.add(heading);
      
      headerPanel.add(backPanel);
      headerPanel.add(titlePanel);
      headerPanel.add(new JLabel());
      
      namePanel.add(name);
      namePanel.add(nameText);
      
      caloriesPanel.add(calories);
      caloriesPanel.add(caloriesText);
      
      fatPanel.add(fat);
      fatPanel.add(fatText);
      
      carbPanel.add(carb);
      carbPanel.add(carbText);
      
      proteinPanel.add(protein);
      proteinPanel.add(proteinText);
      
      buttonPanel.add(add);
      
      add(headerPanel);
      add(namePanel);
      add(caloriesPanel);
      add(fatPanel);
      add(carbPanel);
      add(proteinPanel);
      add(buttonPanel);
   }
   
   public void setWellnessActionListener(ActionListener wellnessListener) {
      back.addActionListener(wellnessListener);
      add.addActionListener(wellnessListener);
   }
}