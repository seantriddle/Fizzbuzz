import java.util.Scanner;
import java.util.ArrayList;


public class STRFizzBuzz
{
  //static String[] fzbzArray = new String[501];
  static final int arraySize = 3000;
  static ArrayList<String> fzbzArray = new ArrayList<String>(arraySize);
  
  public static void main(String[] args)
  {
    Scanner inputScanner = new Scanner(System.in);
    STRFizzBuzz fzbz1 = new STRFizzBuzz();               //for loop fizzbuzz
    STRFizzBuzz fzbz2 = new STRFizzBuzz();               //recursive fizzbuzz
    
    while (true){
      System.out.println("Solution 1 or 2?");
      
      try
      {
        int inputFromScanner = inputScanner.nextInt();
        
        if (inputFromScanner != 1 && inputFromScanner != 2)
        {
          System.out.println("please enter a 1 or a 2.");
        }
        
        else if (inputFromScanner == 1)
        {
          long startTime = System.nanoTime();                    //starts timer
          fzbz1.runFizzbuzz1();
          long elapsedTime = System.nanoTime() - startTime;      //ends timer
          
          System.out.println(fzbzArray);
          System.out.println("Total execution time: "
                               + elapsedTime);
          break;
        }
        
        else if (inputFromScanner == 2)
        {
          
          long startTime = System.nanoTime(); //starts timer
          fzbz2.runFizzbuzz2(1, arraySize);
          long elapsedTime = System.nanoTime() - startTime; //ends timer
          
          System.out.println(fzbzArray);
          System.out.println("Total execution time: "
                               + elapsedTime);
          break; 
        }
        else
          System.out.println("Error");
      }
      
      catch (Exception e)
      {
        System.out.println("please enter a 1 or a 2. \n" + e);
      }
    }
    
  }
  
  //for loop fizzbuzz [ fizzbuzz1 ]
  
  public void runFizzbuzz1()
  {
    for (int i = 1; i < arraySize; i++)
    {
      if (i%3 == 0 && i%5 != 0)                 //if divisible by 3 and not 5, fizz
        fzbzArray.add("Fizz");

      else if (i%3 != 0 && i%5 == 0)            //if divisible by 5 and not 3, buzz
        fzbzArray.add("Buzz");

      else if (i%3 == 0 && i%5 == 0)            //if divisible by both 3 and 5, fizzbuzz
        fzbzArray.add("Fizzbuzz");
 
      else                                      //                 /\
        fzbzArray.add(Integer.toString(i));     // if none of the above, print just the number
    }
  }
  
  
  //recursive fizzbuzz [ fizzbuzz2 ]
  
  public void runFizzbuzz2(int start, int finish) //returns a number, typically where the stack starts to overflow
  {
    if (start < finish)
    {
      final int mod3 = start%3;
      final int mod5 = start%5;
      
      if (mod3 == 0 && mod5 == 0)    //functionally the same as above, but should be faster due to not needing to calculate the modulus 3 x 2 times, instead only doing it twice
        fzbzArray.add("Fizzbuzz");   //less comparisons as well, by comparing both mod3 and mod5 first, then only checking mod5 once, then mod3 once

      else if (mod5 == 0)
        fzbzArray.add("Buzz");
      
      else if  (mod3 == 0)
        fzbzArray.add("Fizz");
      
      else
        fzbzArray.add(Integer.toString(start));
      
      runFizzbuzz2(++start, finish);  //recursively runs the function instead of doing it in a loop.
    }                          
  }
}






