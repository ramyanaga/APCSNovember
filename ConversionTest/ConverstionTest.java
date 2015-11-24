
/**
 * Write a description of class ConverstionTest here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*; 
public class ConverstionTest {
    public static void main(String[] args) {
        /*
        int num1 = negativesTest("5"); 
        System.out.println(num1); 
        int num2 = negativesTest("-5");
        System.out.println(num2); 
        int num3 = negativesTest("-4"); 
        System.out.println(num3); 
        int num4 = negativesTest("-1000001"); 
        System.out.println(num4); 
        */
       System.out.println("type stuff"); 
       Scanner sc = new Scanner(System.in); 
       String number = sc.nextLine(); 
       int check = 1; 
       while (check == 1) {
           //continue = true; 
           negativesTest("2"); 
           System.out.println(number); 
           number = sc.nextLine();
           System.out.println("number is: " + number); 
           String numSubstring = number.substring(0,(number.length())); 
           System.out.println("substring is" + numSubstring); 
           if (number.substring(0,number.length()).equals("quit")) {
               System.out.println("in if statement"); 
               check = 0; 
               //System.exit(0); 
               
            }
        }
           
    }
        
   
    
    public static int negativesTest(String num1) {
       int num1Int; 
       if ((Character.toString(num1.charAt(0)) == "-")) {
           num1Int = Integer.parseInt(num1) * (-1); 
        }
        else {
            num1Int = Integer.parseInt(num1); 
        }
        return num1Int*2; 
    }
            
    // instance variables - replace the example below with your own
}
