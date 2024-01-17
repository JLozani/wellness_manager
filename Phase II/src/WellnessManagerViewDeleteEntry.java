import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.*;

import java.sql.Timestamp;

import java.util.ArrayList;

public class WellnessManagerViewDeleteEntry extends JPanel {
   private JButton back, delete;
   private JComboBox<String> box;
   
   public WellnessManagerViewDeleteEntry() {
      super();
      
      setLayout(new GridLayout(3, 1, 0, 15));
      
      JPanel headerPanel = new JPanel(new GridLayout(1, 3));
      JPanel backPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
      JPanel titlePanel = new JPanel();
      JPanel namePanel = new JPanel();
      JPanel buttonPanel = new JPanel();
      JLabel heading = new JLabel("Delete entry");
      JLabel entries = new JLabel("Entries: ");
      back = new JButton("Daily log");
      delete = new JButton("Delete");
      box = new JComboBox<String>();
      
      heading.setHorizontalAlignment(SwingConstants.CENTER);
      heading.setVerticalAlignment(SwingConstants.CENTER);
      heading.setFont(new Font(heading.getFont().getName(), heading.getFont().getStyle(), 24));
      
      entries.setFont(new Font(entries.getFont().getName(), entries.getFont().getStyle(), 16));
      
      backPanel.add(back);
      
      titlePanel.add(heading);
      
      headerPanel.add(backPanel);
      headerPanel.add(titlePanel);
      headerPanel.add(new JLabel());
      
      namePanel.add(entries);
      namePanel.add(box);
      
      buttonPanel.add(delete);
      
      add(headerPanel);
      add(namePanel);
      add(buttonPanel);
   }
   
   public void setBox(ArrayList<String> logs) {
      for(String log : logs) {
         box.addItem(log);
      }
   }
   
   public String getSelectedLog() {
      String temp = (String)(box.getSelectedItem());
      
      box.removeAllItems();
      
      return temp;
   }
      
   public void setWellnessActionListener(ActionListener wellnessListener) {
      back.addActionListener(wellnessListener);
      delete.addActionListener(wellnessListener);
   }
}