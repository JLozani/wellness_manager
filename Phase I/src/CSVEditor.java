import java.io.*;
import java.util.*;
import java.sql.*;

public class CSVEditor {
   double weight;
   double calories;
   
   public String fileFoodName;
   public String fileLogName;
   
   ArrayList<FoodComponent> foodList;
   ArrayList<String> logList;
   
   public CSVEditor() {
      fileFoodName = "food.csv";
      fileLogName = "log.csv";
      
      foodList = new ArrayList<FoodComponent>();
      foodList = new ArrayList<String>();
   }
   
   public void write(){
      try{
         PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("food.csv")));
         
         pw.append(System.lineSeparator()+"b," + c);
      
         pw.flush();
         pw.close();
      }catch(FileNotFoundException fnef){
      
         System.out.println("File was not found.\n An error of type: " + fnef+" occured");
      
      
      
      }catch(IOException ioe){
         System.out.println("An error of type: " + ioe +" occured");
      
      
      
      }
   
   
   }
   public void displayInfo(){
   
      for(int i=0; i < food.size();i++ ){
         System.out.println(food.get(i));
      
      }
   
   }
   
   
   
   public void weightReader(){
      String temp1 = null;
      ArrayList<String> logI = new ArrayList<String>();
      ArrayList<String> weight = new ArrayList<String>();
      
      try{
         BufferedReader csvReader = new BufferedReader(new FileReader("log.csv"));
         String line;
         if((line = csvReader.readLine()) == null){
            System.out.print("The log is empty, please make an entry");
         
         }else{
            System.out.println(line);
            logI.add(line);
            while ((line = csvReader.readLine()) != null) {
               logI.add(line);
               
            } 
         }
      
         for(int i=1;i < logI.size(); i++){
            
            
            temp1 = logI.get(i);
            
            
            String[] el = logI.get(i).split(",");
            String temp = el[3];
            
            
            
            if(temp.equals("w")){
               weight.add(temp1);
            
            
            }
         }
         
         
         int s = weight.size();
         
         System.out.println(s);
         
         s--;
         
         String tempW = weight.get(s);
         String[] wL = tempW.split(","); 
         weightLast = Double.parseDouble(wL[4]);
         System.out.println(weightLast);    
         
      
      
      }catch(FileNotFoundException fnfe){
         System.out.println("File was not found.\n An error of type: " + fnfe+" occured");
      
      
      
      }catch(IOException ioe){
         System.out.println("An error of type: " + ioe +" occured");
      
      }
         
   
   
   }
   public void weightWriter(){
      try{
         FileWriter fw = new FileWriter("log.csv", true); 
         BufferedWriter bw = new BufferedWriter(fw); 
         PrintWriter pw = new PrintWriter(bw);
         Timestamp timestamp = new Timestamp(System.currentTimeMillis());
      
         String timeStamp = ""+timestamp;
         String[] timeStampArray = timeStamp.split(" ");
         
         String timeStamp1 = timeStampArray[0];
         String[] timeStampArray1 = timeStamp1.split("-");
         
         pw.append(System.lineSeparator()+timeStampArray1[0]+","+timeStampArray1[1]+","+timeStampArray1[2]+","  + weightLast);
      
         pw.flush();
         pw.close();
      }catch(FileNotFoundException fnef){
      
         System.out.println("File was not found.\n An error of type: " + fnef+" occured");
      
      
      
      }catch(IOException ioe){
         System.out.println("An error of type: " + ioe +" occured");
      
      
      
      }
   
   
   }  
      
      
   
   public void weightWriter(double w){
      try{
         FileWriter fw = new FileWriter("log.csv", true); 
         BufferedWriter bw = new BufferedWriter(fw); 
         PrintWriter pw = new PrintWriter(bw);
         Timestamp timestamp = new Timestamp(System.currentTimeMillis());
      
         String timeStamp = ""+timestamp;
         String[] timeStampArray = timeStamp.split(" ");
         String timeStamp1 = timeStampArray[0];
         String[] timeStampArray1 = timeStamp1.split("-");
         
         pw.append(System.lineSeparator()+timeStampArray1[0]+","+timeStampArray1[1]+","+timeStampArray1[2]+",w," + w);
      
         pw.flush();
         pw.close();
      }catch(FileNotFoundException fnef){
      
         System.out.println("File was not found.\n An error of type: " + fnef+" occured");
      
      
      
      }catch(IOException ioe){
         System.out.println("An error of type: " + ioe +" occured");
      
      
      
      }
   
   
   }
   public void calorieWriter(double c){
      try{
         FileWriter fw = new FileWriter("log.csv", true); 
         BufferedWriter bw = new BufferedWriter(fw); 
         PrintWriter pw = new PrintWriter(bw);
         Timestamp timestamp = new Timestamp(System.currentTimeMillis());
      
         String timeStamp = ""+timestamp;
         String[] timeStampArray = timeStamp.split(" ");
         String timeStamp1 = timeStampArray[0];
         String[] timeStampArray1 = timeStamp1.split("-");
         
         pw.append(System.lineSeparator()+timeStampArray1[0]+","+timeStampArray1[1]+","+timeStampArray1[2]+",c," + c);
      
         pw.flush();
         pw.close();
      }catch(FileNotFoundException fnef){
      
         System.out.println("File was not found.\n An error of type: " + fnef+" occured");
      
      
      
      }catch(IOException ioe){
         System.out.println("An error of type: " + ioe +" occured");
      
      
      
      }
   
   
   }
   public void intakeWriter(String c, double amount){
      
      try{
         FileWriter fw = new FileWriter("log.csv", true); 
         BufferedWriter bw = new BufferedWriter(fw); 
         PrintWriter pw = new PrintWriter(bw);
         Timestamp timestamp = new Timestamp(System.currentTimeMillis());
      
         String timeStamp = ""+timestamp;
         String[] timeStampArray = timeStamp.split(" ");
         String timeStamp1 = timeStampArray[0];
         String[] timeStampArray1 = timeStamp1.split("-");
         
         pw.append(System.lineSeparator()+timeStampArray1[0]+","+timeStampArray1[1]+","+timeStampArray1[2]+",f," + c+ "," + amount);
      
         pw.flush();
         pw.close();
      }catch(FileNotFoundException fnef){
      
         System.out.println("File was not found.\n An error of type: " + fnef+" occured");
      
      
      
      }catch(IOException ioe){
         System.out.println("An error of type: " + ioe +" occured");
      
      
      
      }
   
   
   } 
   
   public void infoRetreat(String date){
      String temp1 = null;
      ArrayList<String> logI = new ArrayList<String>();
      
      
      try{
         BufferedReader csvReader = new BufferedReader(new FileReader("log.csv"));
         String line;
         if((line = csvReader.readLine()) == null){
            System.out.print("The log is empty, please make an entry");
         
         }else{
            System.out.println(line);
            logI.add(line);
            while ((line = csvReader.readLine()) != null) {
               logI.add(line);
               
            }
         }
         for(int i=1;i < logI.size(); i++){
            
            
            temp1 = logI.get(i);
            
            
            String[] el = logI.get(i).split(",");
            String date1 = ""+el[0]+el[1]+el[2];
            String temp = el[3];
            
            
            
            if(temp.equals("f") && date1.equals(date)){
               
               dailyI.add(temp1);
            
            
            }
         }   
         System.out.print(dailyI);
      }catch(FileNotFoundException fnef){
      
         System.out.println("File was not found.\n An error of type: " + fnef+" occured");
      
      
      
      }catch(IOException ioe){
         System.out.println("An error of type: " + ioe +" occured");
      
      
      
      }    
      
   }
}