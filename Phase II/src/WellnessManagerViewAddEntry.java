import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.*;

import java.sql.Timestamp;

public class WellnessManagerViewAddEntry extends JPanel {
   private JButton back, save;
   private JTextField nameText, amountText;
   
   public WellnessManagerViewAddEntry() {
      super();
      
      setLayout(new GridLayout(4, 1, 0, 15));
      
      JPanel headerPanel = new JPanel(new GridLayout(1, 3));
      JPanel backPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
      JPanel titlePanel = new JPanel();
      JPanel namePanel = new JPanel();
      JPanel amountPanel = new JPanel();
      JPanel buttonPanel = new JPanel();
      JLabel heading = new JLabel("Add Food");
      JLabel name = new JLabel("    Name: ");
      JLabel amount = new JLabel(" Amount: ");
      nameText = new JTextField();
      amountText = new JTextField();
      back = new JButton("Daily log");
      save = new JButton("Save");
      
      heading.setHorizontalAlignment(SwingConstants.CENTER);
      heading.setVerticalAlignment(SwingConstants.CENTER);
      heading.setFont(new Font(heading.getFont().getName(), heading.getFont().getStyle(), 24));
      
      name.setFont(new Font(name.getFont().getName(), name.getFont().getStyle(), 16));
      amount.setFont(new Font(amount.getFont().getName(), amount.getFont().getStyle(), 16));
      
      nameText.setColumns(15);
      nameText.setHorizontalAlignment(SwingConstants.CENTER);
      nameText.setFont(new Font(nameText.getFont().getName(), nameText.getFont().getStyle(), 16));
      
      amountText.setColumns(15);
      amountText.setHorizontalAlignment(SwingConstants.CENTER);
      amountText.setFont(new Font(amountText.getFont().getName(), amountText.getFont().getStyle(), 16));
      
      backPanel.add(back);
      
      titlePanel.add(heading);
      
      headerPanel.add(backPanel);
      headerPanel.add(titlePanel);
      headerPanel.add(new JLabel());
      
      namePanel.add(name);
      namePanel.add(nameText);
      
      amountPanel.add(amount);
      amountPanel.add(amountText);
      
      buttonPanel.add(save);
      
      add(headerPanel);
      add(namePanel);
      add(amountPanel);
      add(buttonPanel);
   }
   
   public String getEntry() {
      return String.format("f,%s,%.1f", nameText.getText(), Double.parseDouble(amountText.getText()));
   }
      
   public void setWellnessActionListener(ActionListener wellnessListener) {
      back.addActionListener(wellnessListener);
      save.addActionListener(wellnessListener);
   }
}