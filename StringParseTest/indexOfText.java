
/**
 * Write a description of class indexOfText here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
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
    public static String checkpoint2Test(String fract2) {
        String num = ""; 
        String denom = ""; 
        String wholeNum = ""; 
        int fract2tlength = fract2.length(); 
        //whole number cases
        if (fract2.indexOf("_")!=-1) {
            if (fract2.indexOf("/")!=-1) {
                //wholeNum = Character.toString(fract2.charAt((fract2.indexOf("_") - 1))); 
                wholeNum = fract2.substring(0,(indexOf("_")); 
                //num = Character.toString(fract2.charAt(((fract2.indexOf("/") - 1)))); 
                num = fract2.substring(0, indexOf("
                denom = Character.toString(fract2.charAt(((fract2.indexOf("/") + 1)))); 
            }
        }
        else System.out.println("Doesn't fit scenario"); 
        String fullLine = "whole:" + wholeNum + " numerator:" + num + " denominator:" + denom;
        return fullLine; 
        
    }
                
            
            
        
    
        
            
            
   
}
