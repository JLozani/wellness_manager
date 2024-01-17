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

public class WellnessManagerViewAddExerciseEntry extends JPanel {
   private JButton back, save;
   private JTextField nameText, timeText;
   
   public WellnessManagerViewAddExerciseEntry() {
      super();
      
      setLayout(new GridLayout(4, 1, 0, 15));
      
      JPanel headerPanel = new JPanel(new GridLayout(1, 3));
      JPanel backPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
      JPanel titlePanel = new JPanel();
      JPanel namePanel = new JPanel();
      JPanel timePanel = new JPanel();
      JPanel buttonPanel = new JPanel();
      JLabel heading = new JLabel("Add Exercise");
      JLabel name = new JLabel("Name: ");
      JLabel time = new JLabel("Time: ");
      nameText = new JTextField();
      timeText = new JTextField();
      back = new JButton("Daily log");
      save = new JButton("Save exercise");
      
      heading.setHorizontalAlignment(SwingConstants.CENTER);
      heading.setVerticalAlignment(SwingConstants.CENTER);
      heading.setFont(new Font(heading.getFont().getName(), heading.getFont().getStyle(), 24));
      
      name.setFont(new Font(name.getFont().getName(), name.getFont().getStyle(), 16));
      time.setFont(new Font(time.getFont().getName(), time.getFont().getStyle(), 16));
      
      nameText.setColumns(15);
      nameText.setHorizontalAlignment(SwingConstants.CENTER);
      nameText.setFont(new Font(nameText.getFont().getName(), nameText.getFont().getStyle(), 16));
      
      timeText.setColumns(15);
      timeText.setHorizontalAlignment(SwingConstants.CENTER);
      timeText.setFont(new Font(timeText.getFont().getName(), timeText.getFont().getStyle(), 16));
      
      backPanel.add(back);
      
      titlePanel.add(heading);
      
      headerPanel.add(backPanel);
      headerPanel.add(titlePanel);
      headerPanel.add(new JLabel());
      
      namePanel.add(name);
      namePanel.add(nameText);
      
      timePanel.add(time);
      timePanel.add(timeText);
      
      buttonPanel.add(save);
      
      add(headerPanel);
      add(namePanel);
      add(timePanel);
      add(buttonPanel);
   }
   
   public String getExerciseEntry() {
      return String.format("e,%s,%.1f", nameText.getText(), Double.parseDouble(timeText.getText()));
   }
      
   public void setWellnessActionListener(ActionListener wellnessListener) {
      back.addActionListener(wellnessListener);
      save.addActionListener(wellnessListener);
   }
}