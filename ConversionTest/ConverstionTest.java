
/**
 * Write a description of class ConverstionTest here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ConverstionTest {
    public static void main(String[] args) {
        int num1 = negativesTest("5"); 
        System.out.println(num1); 
        int num2 = negativesTest("-5");
        System.out.println(num2); 
        int num3 = negativesTest("-4"); 
        System.out.println(num3); 
        int num4 = negativesTest("-1000001"); 
        System.out.println(num4); 
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
