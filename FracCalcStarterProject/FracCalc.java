//Author: Ramya Nagarajan 
//Date: 11/23/15
 
import java.util.*;
public class FracCalc {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in); 
        String equation = userInput.nextLine(); 
        while (equation!="quit") {
             
            String returnVal = produceAnswer(equation); 
            System.out.println(returnVal); 
            userInput = new Scanner(System.in);
            equation = userInput.nextLine(); 
        }
        
        // TODO: Read the input from the user and call produceAnswer with an equation

    }
    
    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //        
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    public static String produceAnswer(String input) { 
      //sets return values from functions defined below into appropriate variables  
      //Checkpoint 1 Below: 
      //String fract1 = fraction1(input);
      //String operator = operator(input); 
      //String fract2 = fraction2(input); 
      //only returns fraction 2 as per assignment
      //return fract2; 
      
     //Below is for chekpoint 2 only 
     
     String fract2 = fraction2(input); 
     String fract2Line = checkpoint2V2(fract2); 
     return fract2Line; 
     
     
    }
    //parses fraction 1
    public static String fraction1(String input) {
       int fract1End = input.indexOf(" "); //last index of fraction 1
       String fract1 = input.substring(0,fract1End);
       return fract1; 
    }
    //parses/searches for the operator
    public static String operator(String input) {
        int operatorIndex = input.indexOf(" ") + 1;   
        String operator = Character.toString(input.charAt(operatorIndex));  
        return operator; 
    }
    //parses for fraction 2
    public static String fraction2(String input) {
        int fract2Start = input.indexOf(" ") + 3;  
        int fract2End = input.length(); 
        String fract2 = input.substring(fract2Start, fract2End); 
        return fract2; 
    }
    
    public static String checkpoint2V1(String fract2) {
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
            denom = fract2.substring(slash+1, length); 
            if (fract2.indexOf("_") != -1) {
                num = fract2.substring((underscore+1),slash); 
            }
            else {
                num = fract2.substring(0,slash); 
            }
            
        }
        String fullLine = "whole:" + whole + " numerator:" + num + " denominator:" + denom;
        return fullLine; 
    }
    
    
    public static String checkpoint2V2(String fraction) {
        int length = fraction.length();
        String denom = "1"; 
        String num = "0"; 
        String wholeNum = "0"; 
        //if numerator is not equal to 0
        if (fraction.indexOf("/")!=-1) {
            denom = fraction.substring((fraction.indexOf("/") + 1),length);
   
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
        int denomInt = stringToInt(denom); 
        int numInt = stringToInt(num); 
        int wholeNumInt = stringToInt(wholeNum); 
        return "whole:" + wholeNumInt + " numerator:" + numInt + " denominator:" + denomInt; 
    }
     public static int stringToInt(String number) {
       int numberInt; 
       if ((Character.toString(number.charAt(0)) == "-")) {
           numberInt = Integer.parseInt(number) * (-1); 
        }
        else {
            numberInt = Integer.parseInt(number); 
        }
        return numberInt; 
    }
    
   
        
        
}
    // TODO: Fill in the space below with any helper methods that you think you wi}
