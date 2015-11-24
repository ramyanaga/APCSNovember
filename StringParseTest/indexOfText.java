
/**
 * Write a description of class indexOfText here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import java.lang.*;
public class indexOfText
{
    // instance variables - replace the example below with your own
    public static void main(String[]args) {
        System.out.println("Enter crap here"); 
        Scanner userInput = new Scanner(System.in); 
        String equation = userInput.nextLine();   
        String returnVal = produceAnswer(equation); 
        System.out.println(returnVal); 
        //produceAnswer(equation); 
        
    }
     public static String produceAnswer(String input) { 
      /*String fract1 = fraction1(input);
      System.out.println("fract1 is " + fract1); 
      String operator = operator(input); 
      System.out.println("operator is "+ operator); 
      String fract2 = fraction2(input); 
      System.out.println("fract 2 is " + fract2); 
      //return fract2; 
      */
      
      String fract2 = fraction2(input); 
      String fract2Line = checkpoint2Test(fract2); 
      return fract2Line;
      
     //String operator = operator(input); 
     //return operator; 
      
    }
    public static String fraction1(String input) {
       int fract1End = input.indexOf(" "); 
       String fract1 = input.substring(0,fract1End);
       return fract1; 
    }
    public static String operator(String input) {
        int operatorIndex = input.indexOf(" ") + 1; 
        String operator = Character.toString(input.charAt(operatorIndex)); 
        
        //String operator = input.substring(operatorIndex, operatorIndex+1); 
        return operator; 
    }
    public static String fraction2(String input) {
        int fract2Start = input.indexOf(" ") + 2; 
        int fract2End = input.length(); 
        
        String fract2 = input.substring(fract2Start, fract2End); 
        return fract2; 
    }
    /*
    public static String checkpoint2(String fract2) {
        int underscoreIndex = fract2.indexOf("_"); 
        String whole = fract2.substring(0,underscoreIndex); 
        int slashIndex = fract2.indexOf("/"); 
        String num = ""; 
        if (slashIndex!=-1) {
            String num = fract2.substring((underscoreIndex+1), slashIndex); 
        }
        
        int endDenom = fract2.length(); 
        String denom = fract2.substring((slashIndex+1), endDenom); 
        String fullLine = "whole:" + whole + " numerator:" + num + " denominator:" + denom; 
        return fullLine; 
    }
    */
       
    public static String checkpoint2(String fract2) {
        int underscore = 0;
        int slash = 0; 
        String whole = "0"; 
        String num = "0"; 
        String denom = "1"; 
        
        int length = fract2.length(); 
        if (fract2.indexOf("_")!=-1) {
            underscore = fract2.indexOf("_");         
            whole = fract2.substring(0,underscore); 
          
        }
        else if (fract2.indexOf("/") == -1) {
            whole = fract2.substring(0,length); 
        }
        
        if (fract2.indexOf("/")!=-1) {
            slash = fract2.indexOf("/"); 
            num = fract2.substring((underscore+1), slash); 
            denom = fract2.substring(slash+1, length); 
        }
        String fullLine = "whole:" + whole + " numerator:" + num + " denominator:" + denom;
        return fullLine; 
    }
    /*possible scenarios: 
     * -whole number, numerator != 0, denominator 
     *      -underscore and slash
     * -no whole number, numerator != 0, denominator 
     *      -no underscore, slash
     * -whole number, numerator = 0, denominator
     *      -no underscore, no slash
     */
    
    public static String checkpoint2Test(String fraction) {
        int length = fraction.length();
        String denom = "1"; 
        //int denomInt; 
        String num = "0"; 
        //int numInt; 
        String wholeNum = "0"; 
        //int wholeNumInt; 
        //if numerator is not equal to 0
        if (fraction.indexOf("/")!=-1) {
            denom = fraction.substring((fraction.indexOf("/") + 1),length);
            
            
            //denom = fraction.substring(startDenom, length); 
            fraction = fraction.substring(0,fraction.indexOf("/")); 
            //if numerator is not equal to 0 and fraction has a whole number
            if (fraction.indexOf("_")!=-1) {
                num = fraction.substring((fraction.indexOf("_")+1),(fraction.length())); 
            
                fraction = fraction.substring(0,fraction.indexOf("_")); 
                wholeNum = fraction; 
                
            }
            //if numerator is not equal to 0, but fraction does not have whole number
            else {
                num = fraction.substring(0,fraction.length()); 
                
            }
        }
        //if numerator equals 0, but there is a whole number 
        else {
            wholeNum = fraction; 
        }
        int denomInt = Integer.parseInt(denom); 
        int numInt = Integer.parseInt(num); 
        int wholeNumInt = Integer.parseInt(wholeNum);
        return "wholeNum:" + wholeNumInt + " numerator:" + numInt + " denomerator:" + denomInt; 
    }
    
    
        
                
            
            
        
    
        
            
            
   
}
