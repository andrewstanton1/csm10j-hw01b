import java.util.*; 
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Hw01b
{   
    public static void main(String[] args)  throws FileNotFoundException, IOException   //main function starts

    {   
        boolean end = true;                         //value is true until user wants to end program
        String fileName = "stocks.txt";             //default file name
        Scanner number = new Scanner(System.in);    //takes initial user choice
        
        do                                          //loop for user options begins
        {
            System.out.println("Enter '1' to get max, min and avg of a stock");
            System.out.println("Enter '2' to get stock ticker with highest price");         //the following are user choices
            System.out.println("Enter '3' to get stock ticker with lowest price");          
            System.out.println("Enter 'c' to change the stockfile name");
            System.out.println("Enter 'q' to quit");
            System.out.print("\nYour choice: ");
            String choice = number.next();          //takes user input choice
       
         switch (choice)                            //switch statement begins
             {
              case "1":
                  
                 Scanner ticker = new Scanner(System.in);
                 System.out.print("\nEnter a stock ticker: ");
                 String that = ticker.next();                       //user enters name of stock ticker      
                 System.out.println();
                 String Case = that.toUpperCase();                  //changes user input to captials letters                   
                  System.out.println(fileName);
                 GetStocksStats(fileName, Case);                    //calls method to search file for stock ticker entered
           
               break;
                
               case "2":
                 String high = null, high1 = null;                              //variable to hold prices
                 double expensive = 0;
                 int b = -1;                                                    //value used to identify case
                 GetStocksHighLow(fileName, high, high1, expensive, b);         //calls method to search file for highest price stock
                    
               break;
                
                
               case "3":                                                             
                 String low = null, low1 = null;                                //variables to hold prices
                 double affordable = 0;
                 int c = 0;                                                     //value used to identify case
                  
                 GetStocksHighLow(fileName, low, low1, affordable, c);          //calls method to search file for lowest price stock
                   
               break;
                  
               case "c":
               case "C":
                 Scanner name = new Scanner(System.in);
                 System.out.print("\nEnter a stock filename: ");  //takes new file name                
                 fileName = name.next();                                       
        
                 System.out.println("Filename change Succuessful\n");

               break;
                
               case "q":
               case "Q":
                end = false;                                                    //changes end value to false to end loop
                System.out.println("\n" + "Goodbye" + "\n");
                    break;  
                
            default:
                System.out.println("\nThat is not a valid option. Please try again.\n");
            }
        } while(end);       //loop ends
    }
                          
    public static void GetStocksStats(String fileName, String Case1) throws FileNotFoundException       //method to find user entered
    {                                                                                                   //stock ticker along with values
                File file = new File(fileName);         //takes file name
        try (Scanner scan = new Scanner(file)) 
        {
            double max = 0, min = 0;
            String cash;                    //variables to hold max, min, and average stock prices
            double avg = 0;
            int i = 0;
            while(scan.hasNext())           //beings searching file
            {
                String search = scan.next();
                
                if (search.equals(Case1))   //ticker is found
                {
                    i++;                    //keeps count of the number of times ticker is found
                    
                    cash = scan.next();     //gets price of ticker
                    
                    double value = Double.parseDouble(cash);    //converts ticker into double
                    
                    if (i == 1)
                        min = value;
                    
                    if (max <= value)                   //holds values as file as searched
                        max = value;
                    
                    if (min >= value)
                        min = value;
                    
                    avg += value;
                    
                }
            }
            scan.close();
            if(max == 0)                                //if ticker is not found
                             System.out.println(Case1 + " was not found.\n");
                        else
                          {
                              System.out.print(Case1 + " min: $" + min + " ");
                              System.out.print("max: $" + max + " ");            //outputs info about ticker
                              System.out.printf("avg: $" + "%.2f%n", avg/i);
                              System.out.println();
                          }
        }
    }
                
        
        
    public static void GetStocksHighLow(String fileName, String StockName, String StockPricestr, double fprice, int key) throws FileNotFoundException
    {
            File file = new File(fileName);     //takes filename
           
            String stockTicker = null;
        try (Scanner scan = new Scanner(file)) 
        {
            if(key == 0)                          //identifies case(finds minimum stock price)
            {
                while(scan.hasNext())           //begins searching file
                {
                    key++;                        
                    
                    StockName = scan.next();            //ticker name
                    StockPricestr = scan.next();            //ticker price
                    double change = Double.parseDouble(StockPricestr);      //change ticker price to double
                    
                    if(key == 1)                  //when first stock is found, assign price variable
                    {
                        fprice = change;
                        stockTicker = StockName;
                    }
                    
                    
                    if(fprice > change)              //updates price variable when a cheaper stock price is found
                    {
                        fprice = change;
                        stockTicker = StockName;     //tracks stock name
                    }
                }
                System.out.println("\n" + stockTicker + " has the lowest price of $" + fprice + "\n");
                scan.close();
            }
            if(key == -1)                       //identifies case(finds max stock price)
            {
                while(scan.hasNext())           //begins searching file
                {
                    StockName = scan.next();              //stock name
                    StockPricestr = scan.next();          //stock price
                    double change = Double.parseDouble(StockPricestr);
                    
                    if(fprice < change)         //replaces stock with more expensive stock as file search continues
                    {
                        fprice = change;
                        stockTicker = StockName;//tracks stock name
                    }
                   
                }
                System.out.println("\n" + stockTicker + " has the highest price of $" + fprice + "\n");
                scan.close();
            }
        }
    } 
}
