
import java.util.Scanner;




public class Walkthrough {
    
       private static int column_count=0;       
         private static  String[]  columns_names; 
    
    
    public static void main(String[] args) {
        // TODO code application logic here
    //create new table
    //request user input:
  Scanner scanner = new Scanner(System.in);
   System.out.print("""
                    what action do you want to perform ?
                    1. Create Table
                    2. Insert Data 
                    3. Select Data
                    0. Exit 
                    Enter value to select: """); 
   String planner=scanner.nextLine();
   
    while(!planner.equals("0")){
        switch(planner){
                   case "1" -> create();
                   case "2" -> insert();
                   case "3" -> select();
                   default -> System.out.print("Invalid Choice\n");
        }
     
             System.out.print("""
                              what action do you want to perform ?
                              1. Create Table
                              2. Insert Data 
                              3. Select Data
                              0. Exit 
                              Enter value to select: """);
   
   
    planner=scanner.nextLine();
    }
   
    
    }
    
    
public static void create(){
    Scanner scanner = new Scanner(System.in);
     System.out.print("Enter Table Name you want to create: ");
     String table_name= scanner.nextLine();
     System.out.print("Enter the number of colums for the table: ");
     String table_data="";
     
      String str="";
      try {  
          str=scanner.nextLine();
          column_count = Integer.parseInt(str);
          columns_names=new String[column_count];

        } catch (NumberFormatException e) {
            System.out.println("Invalid "+str+" cannot be converted to an integer");
            
        }
           //collect use data settings
            for(int i=1;i<=column_count;i++){
                if(i<column_count){
                     System.out.println("ENTER NAME AND ATTRIBUTES OF COLUMN "+i +" Format:  column_name datatype constraint");
                     String input=scanner.nextLine();
                     table_data+=(input)+", ";
                     columns_names[i-1]=input;
                     
                }else{
                      System.out.println("ENTER NAME AND ATTRIBUTES OF COLUMN "+i +" Format:  column_name datatype constraint");
                      String input=scanner.nextLine();
                     table_data+=(input);
                     columns_names[i-1]=input;
                }     
             } 
            if(table_data.length()>1)
             Trans.create(table_name, table_data);
    
    
    }
    public static void insert(){
       Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name of the table to insert data to:");
        String table_name=scanner.nextLine();
        if(!Trans.exist(table_name)){
        System.out.println(table_name+ "Does not Exist");
        }else{
        String[]  values;
        
          
     
        
        
      
        values=new String[column_count];

       
//loop to get user input

        for (int i=1;i<=column_count;i++){
             System.out.println(table_name+ "Enter "+columns_names[i-1]);
        values[(i-1)]=scanner.nextLine();
        
        }
        
  
        Trans.write ( table_name,  values);
        }
    }
    
    
    
public static void select(){
         
      Scanner scanner = new Scanner(System.in);
      
      System.out.print("Enter the table name you want data from:");
        String table_name=scanner.nextLine();
        
        
          System.out.print("Column Names: ");
           for (String columns_name : columns_names) {
               System.out.print(columns_name + ", ");
           }
       System.out.println(); 
        String column_select;
        System.out.print("Which column do you want Data from: ");
        column_select=scanner.nextLine();
        System.out.print("Specify a condition (press enter to skip): ");
        String condition=scanner.nextLine();
        String[]  results=new String[ Trans.read( table_name, column_select,condition ).length];
        results=Trans.read( table_name, column_select,condition );
        
           for (String result : results) {
               System.out.println(result);
           }  
     }
    
    
}
