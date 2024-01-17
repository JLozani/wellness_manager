import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Font;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.*;

public class WellnessManagerViewAddRecipe extends JPanel {
   private JButton back, add;
   private JTextField nameText, comp1Text, comp2Text, comp3Text, comp4Text, am1Text, am2Text, am3Text, am4Text;
   
   public WellnessManagerViewAddRecipe() {
      super();
      
      setLayout(new GridLayout(7, 1, 0, 15));
      
      JPanel headerPanel = new JPanel(new GridLayout(1, 3));
      JPanel backPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
      JPanel titlePanel = new JPanel();
      JPanel namePanel = new JPanel();
      JPanel comp1Panel = new JPanel();
      JPanel comp2Panel = new JPanel();
      JPanel comp3Panel = new JPanel();
      JPanel comp4Panel = new JPanel();
      JPanel buttonPanel = new JPanel();
      JLabel heading = new JLabel("New recipe");
      JLabel name = new JLabel("    Name: ");
      JLabel comp1 = new JLabel("Component: ");
      JLabel am1 = new JLabel("Amount: ");
      JLabel comp2 = new JLabel("Component: ");
      JLabel am2 = new JLabel("Amount: ");
      JLabel comp3 = new JLabel("Component: ");
      JLabel am3 = new JLabel("Amount: ");
      JLabel comp4 = new JLabel("Component: ");
      JLabel am4 = new JLabel("Amount: ");
      nameText = new JTextField();
      comp1Text = new JTextField("");
      comp2Text = new JTextField("");
      comp3Text = new JTextField("");
      comp4Text = new JTextField("");
      am1Text = new JTextField("");
      am2Text = new JTextField("");
      am3Text = new JTextField("");
      am4Text = new JTextField("");
      back = new JButton("Back");
      add = new JButton("Add recipe");
      
      heading.setHorizontalAlignment(SwingConstants.CENTER);
      heading.setVerticalAlignment(SwingConstants.CENTER);
      heading.setFont(new Font(heading.getFont().getName(), heading.getFont().getStyle(), 24));
      
      name.setFont(new Font(name.getFont().getName(), name.getFont().getStyle(), 16));
      comp1.setFont(new Font(comp1.getFont().getName(), comp1.getFont().getStyle(), 16));
      comp2.setFont(new Font(comp2.getFont().getName(), comp2.getFont().getStyle(), 16));
      comp3.setFont(new Font(comp3.getFont().getName(), comp3.getFont().getStyle(), 16));
      comp4.setFont(new Font(comp4.getFont().getName(), comp4.getFont().getStyle(), 16));
      am1.setFont(new Font(am1.getFont().getName(), am1.getFont().getStyle(), 16));
      am2.setFont(new Font(am2.getFont().getName(), am2.getFont().getStyle(), 16));
      am3.setFont(new Font(am3.getFont().getName(), am3.getFont().getStyle(), 16));
      am4.setFont(new Font(am4.getFont().getName(), am4.getFont().getStyle(), 16));
      
      nameText.setColumns(15);
      nameText.setHorizontalAlignment(SwingConstants.CENTER);
      nameText.setFont(new Font(nameText.getFont().getName(), nameText.getFont().getStyle(), 16));
      
      comp1Text.setColumns(8);
      comp1Text.setHorizontalAlignment(SwingConstants.CENTER);
      comp1Text.setFont(new Font(comp1Text.getFont().getName(), comp1Text.getFont().getStyle(), 16));
      
      comp2Text.setColumns(8);
      comp2Text.setHorizontalAlignment(SwingConstants.CENTER);
      comp2Text.setFont(new Font(comp2Text.getFont().getName(), comp2Text.getFont().getStyle(), 16));
      
      comp3Text.setColumns(8);
      comp3Text.setHorizontalAlignment(SwingConstants.CENTER);
      comp3Text.setFont(new Font(comp3Text.getFont().getName(), comp3Text.getFont().getStyle(), 16));
      
      comp4Text.setColumns(8);
      comp4Text.setHorizontalAlignment(SwingConstants.CENTER);
      comp4Text.setFont(new Font(comp4Text.getFont().getName(), comp4Text.getFont().getStyle(), 16));
      
      am1Text.setColumns(4);
      am1Text.setHorizontalAlignment(SwingConstants.CENTER);
      am1Text.setFont(new Font(am1Text.getFont().getName(), am1Text.getFont().getStyle(), 16));
      
      am2Text.setColumns(4);
      am2Text.setHorizontalAlignment(SwingConstants.CENTER);
      am2Text.setFont(new Font(am2Text.getFont().getName(), am2Text.getFont().getStyle(), 16));
      
      am3Text.setColumns(4);
      am3Text.setHorizontalAlignment(SwingConstants.CENTER);
      am3Text.setFont(new Font(am3Text.getFont().getName(), am3Text.getFont().getStyle(), 16));
      
      am4Text.setColumns(4);
      am4Text.setHorizontalAlignment(SwingConstants.CENTER);
      am4Text.setFont(new Font(am4Text.getFont().getName(), am4Text.getFont().getStyle(), 16));
      
      backPanel.add(back);
      
      titlePanel.add(heading);
      
      headerPanel.add(backPanel);
      headerPanel.add(titlePanel);
      headerPanel.add(new JLabel());
      
      namePanel.add(name);
      namePanel.add(nameText);
      
      comp1Panel.add(comp1);
      comp1Panel.add(comp1Text);
      comp1Panel.add(new JLabel(" "));
      comp1Panel.add(am1);
      comp1Panel.add(am1Text);
      
      comp2Panel.add(comp2);
      comp2Panel.add(comp2Text);
      comp2Panel.add(new JLabel(" "));
      comp2Panel.add(am2);
      comp2Panel.add(am2Text);
      
      comp3Panel.add(comp3);
      comp3Panel.add(comp3Text);
      comp3Panel.add(new JLabel(" "));
      comp3Panel.add(am3);
      comp3Panel.add(am3Text);
      
      comp4Panel.add(comp4);
      comp4Panel.add(comp4Text);
      comp4Panel.add(new JLabel(" "));
      comp4Panel.add(am4);
      comp4Panel.add(am4Text);
      
      buttonPanel.add(add);
      
      add(headerPanel);
      add(namePanel);
      add(comp1Panel);
      add(comp2Panel);
      add(comp3Panel);
      add(comp4Panel);
      add(buttonPanel);
   }
   
   public String getRecipeDetails() {
      return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s", nameText.getText(), comp1Text.getText(), am1Text.getText(), comp2Text.getText(), am2Text.getText(), comp3Text.getText(), am3Text.getText(), comp4Text.getText(), am4Text.getText());
   }
   
   public void setWellnessActionListener(ActionListener wellnessListener) {
      back.addActionListener(wellnessListener);
      add.addActionListener(wellnessListener);
   }
}