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

public class WellnessManagerViewLog extends JPanel {
   private JButton back, go, set, add, delete;
   private JTextField day, month, year, weight, calories;
   private JTextArea text;
   
   public WellnessManagerViewLog() {
      super();
      
      setLayout(new GridLayout(4, 1, 0, 10));
      
      Timestamp ts = new Timestamp(System.currentTimeMillis());
      String[] now = ts.toString().split(" ")[0].split("-");
      
      JPanel headerPanel = new JPanel(new GridLayout(1, 3));
      JPanel backPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
      JPanel titlePanel = new JPanel();
      JPanel datePanel = new JPanel();
      JPanel detailPanel = new JPanel(new GridLayout(2, 1));
      JPanel infoPanel = new JPanel();
      JPanel footer = new JPanel();
      JLabel heading = new JLabel("Daily Log");
      JLabel subHeading = new JLabel("Choose a date: ");
      JLabel weightLabel = new JLabel("Weight:");
      JLabel caloriesLabel = new JLabel("Calories:");
      back = new JButton("Home");
      add = new JButton("Add entry");
      delete = new JButton("Delete entry");
      go = new JButton("Go");
      set = new JButton("Set");
      day = new JTextField(now[2]);
      month = new JTextField(now[1]);
      year = new JTextField(now[0]);
      weight = new JTextField("150");
      calories = new JTextField("2000");
      text = new JTextArea();
      JScrollPane scrollPane = new JScrollPane(text);
      
      heading.setHorizontalAlignment(SwingConstants.CENTER);
      heading.setFont(new Font(heading.getFont().getName(), heading.getFont().getStyle(), 24));
      
      subHeading.setVerticalAlignment(SwingConstants.CENTER);
      subHeading.setFont(new Font(subHeading.getFont().getName(), subHeading.getFont().getStyle(), 16));
      
      day.setColumns(4);
      day.setHorizontalAlignment(SwingConstants.CENTER);
      day.setFont(new Font(day.getFont().getName(), day.getFont().getStyle(), 16));
      
      month.setColumns(4);
      month.setHorizontalAlignment(SwingConstants.CENTER);
      month.setFont(new Font(month.getFont().getName(), month.getFont().getStyle(), 16));
      
      year.setColumns(6);
      year.setHorizontalAlignment(SwingConstants.CENTER);
      year.setFont(new Font(year.getFont().getName(), year.getFont().getStyle(), 16));
      
      weightLabel.setFont(new Font(weightLabel.getFont().getName(), weightLabel.getFont().getStyle(), 14));
      
      caloriesLabel.setFont(new Font(caloriesLabel.getFont().getName(), caloriesLabel.getFont().getStyle(), 14));
      
      weight.setColumns(5);
      weight.setHorizontalAlignment(SwingConstants.CENTER);
      weight.setFont(new Font(weight.getFont().getName(), weight.getFont().getStyle(), 14));
      
      calories.setColumns(6);
      calories.setHorizontalAlignment(SwingConstants.CENTER);
      calories.setFont(new Font(calories.getFont().getName(), calories.getFont().getStyle(), 14));
      
      text.setEditable(false);
      
      titlePanel.add(heading);
      
      backPanel.add(back);
      
      headerPanel.add(backPanel);
      headerPanel.add(titlePanel);
      headerPanel.add(new JLabel());
      
      datePanel.add(subHeading);
      datePanel.add(day);
      datePanel.add(month);
      datePanel.add(year);
      datePanel.add(new JLabel(" "));
      datePanel.add(go);
      
      infoPanel.add(weightLabel);
      infoPanel.add(weight);
      infoPanel.add(new JLabel(" "));
      infoPanel.add(caloriesLabel);
      infoPanel.add(calories);
      infoPanel.add(new JLabel(" "));
      infoPanel.add(set);
      
      detailPanel.add(datePanel);
      detailPanel.add(infoPanel);
      
      footer.add(add);
      footer.add(delete);
      
      add(headerPanel);
      add(detailPanel);
      add(scrollPane);
      add(footer);
   }
   
   public String getDate() {
      return String.format("%s,%s,%s", year.getText(), month.getText(), day.getText());
   }
   
   public void setLog(String logText) {
      text.setText(logText);
   }
   
   public void setDetails(double weightValue, double caloriesValue) {
      weight.setText("" + weightValue);
      calories.setText("" + caloriesValue);
   }
   
   public void setWellnessActionListener(ActionListener wellnessListener) {
      back.addActionListener(wellnessListener);
      go.addActionListener(wellnessListener);
      set.addActionListener(wellnessListener);
      add.addActionListener(wellnessListener);
      delete.addActionListener(wellnessListener);
   }
}