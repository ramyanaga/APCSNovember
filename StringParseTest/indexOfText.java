
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
        
        System.out.println("Enter crap here:"); 
        Scanner userInput = new Scanner(System.in); 
        String equation = userInput.nextLine();
        int check = 1; 
        while (check == 1) { 
            //String equation = userInput.nextLine()
            String returnValMain = produceAnswer(equation);
            System.out.println(returnValMain); 
            System.out.println("Enter crap here"); 
            equation = userInput.nextLine(); 
            if (equation.substring(0,equation.length()).equals("quit")) {
                System.out.println("Good bye!"); 
                check = 0; 
            }
          
        }
        
        
    }
     public static String produceAnswer(String input) { 
      //checkpoint 1 below
      String fract1 = fraction1(input); 
      String operator = operator(input); 
      String fract2 = fraction2(input); 
      String fract1Line = checkpoint2V2(fract1); 
      String fract2Line = checkpoint2V2(fract2); 
      String returnVal = returnSolution(fract1Line, fract2Line, operator); 
      return returnVal; 
      //return fract2Line;
      //int splitStringReturn = splitString(fract2Line); 
      //return String.valueOf(splitStringReturn); 
      
      
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
        int fract2Start = input.indexOf(" ") + 3; 
        int fract2End = input.length(); 
        String fract2 = input.substring(fract2Start, fract2End); 
        return fract2; 
        //return fract2; 
    }
    
       
   
    /*possible scenarios: 
     * -whole number, numerator != 0, denominator 
     *      -underscore and slash
     * -no whole number, numerator != 0, denominator 
     *      -no underscore, slash
     * -whole number, numerator = 0, denominator
     *      -no underscore, no slash
     */
    
    public static String checkpoint2V2(String fraction) {
        int length = fraction.length();
        String denom = "1"; 
        String num = "0"; 
        String wholeNum = "0"; 
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
        return wholeNumInt+"_"+numInt+"_"+denomInt; 
        //return "wholeNum:" + wholeNumInt + " numerator:" + numInt + " denomerator:" + denomInt; 
    }
    
    public static String returnSolution(String fract1,String fract2, String operator) {
       /*variables: 
        * String operator
        * int length1 
        * int denom1 
        * int num1 
        * int wholeNum1 
        * 
        * int length2
        * int denom2
        * int num2 
        * int wholeNum2
        * String returnVal
        */ 
       String returnVal = ""; 
       int length1 = fract1.length(); 
       int denom1 = Integer.parseInt(fract1.substring((fract1.lastIndexOf("_")+1),length1)); 
       fract1 = fract1.substring(0,(fract1.lastIndexOf("_")));
       length1 = fract1.length(); 
       int num1 = Integer.parseInt(fract1.substring(fract1.lastIndexOf("_")+1,length1));
       fract1 = fract1.substring(0,fract1.lastIndexOf("_"));
       length1 = fract1.length();
       int wholeNum1 = Integer.parseInt(fract1.substring((fract1.lastIndexOf("_")+1),length1));
       
       int length2 = fract2.length(); 
       int denom2 = Integer.parseInt(fract2.substring((fract2.lastIndexOf("_")+1),length2)); 
       fract2 = fract2.substring(0,(fract2.lastIndexOf("_")));
       length2 = fract2.length(); 
       int num2 = Integer.parseInt(fract2.substring(fract2.lastIndexOf("_")+1,length2));
       fract2 = fract2.substring(0,fract2.lastIndexOf("_"));
       length2 = fract2.length();
       int wholeNum2 = Integer.parseInt(fract2.substring((fract2.lastIndexOf("_")+1),length2));
       if ((operator.equals("+") || operator.equals("-"))){
           returnVal = addSubtract(wholeNum1, num1, denom1, wholeNum2, num2, denom2, operator); 
       }
       else if ((operator.equals("*")) || operator.equals("/")){
           returnVal = multiplyDivide(wholeNum1, num1, denom1, wholeNum2, num2, denom2, operator);
       }
       else {
           returnVal = "error";
       }
       /*
        //return returnVal; 
       else if (operator.equals("*")) {
            returnVal = multiplyDivide(wholeNum1, num1, denom1, wholeNum2, num2, denom2, operator); 
       }
       else if (operator.equals("/")) {
           returnVal = multiplyDivide(wholeNum1, num1, denom1, wholeNum2, num2, denom2, operator); 
       }
       else {
           returnVal = "0"; 
       }
       */
       return returnVal;  
           
    }
    
    public static String addSubtract(int wholeNum1, int num1, int denom1, int wholeNum2, int num2, int denom2, String operator) {
        int numSum = 0; 
        int denom = denom1; 
        int wholeNum;
        if (wholeNum1 < 0) {
            num1 = -num1; 
        }
        if (wholeNum2 < 0) {
            num2 = -num2; 
        }
        if (denom1 != denom2) {
            denom = denom1 * denom2; 
            num1 *= denom2;
            num2 *= denom1;
        }
        num1 += (wholeNum1 * denom); 
        System.out.println("num1 after simplification: " + num1); 
        num2 += (wholeNum2 * denom); 
        System.out.println("num2 after simplication: " + num2); 
        
        //needs to be further simplified
        if (operator.equals("+")) {
            numSum = num1 + num2; 
        }
        else {
            numSum = num1 - num2; 
        }
        if (numSum == 0) {
            return "0"; 
        }
        else {
            return numSum + "/" + denom; 
        }
        /*
        wholeNum = numSum/denom; 
        numSum = numSum % denom;
        return numSum + "/" + denom;
        */
    }
    
    
    public static String multiplyDivide(int wholeNum1, int num1, int denom1, int wholeNum2, int num2, int denom2, String operator) {
        int finalNum;
        int finalDenom; 
        if (wholeNum1 < 0) {
            num1 = -num1; 
        }
        if (wholeNum2 < 0) {
            num2 = -num2; 
        }
        num1 += wholeNum1 * denom1; 
        num2 += wholeNum2 * denom2; 
        //shouldn't use wholeNum1 and wholeNum2 after this point in method
        if (operator.equals("*")) {
            finalNum = num1 * num2; 
            finalDenom = denom1 * denom2; 
        }
        else {
            finalNum = num1 * denom2; 
            finalDenom = denom1 * num2; 
        }
        if (finalNum == 0) {
            return "0"; 
        }
        else {
            return finalNum + "/" + finalDenom;
        }
    }
       
       
       
    /*Recycling Bin: 
     *  public static String checkpoint2V1(String fract2) {
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
     * 
     */
        
                
            
            
        
    
        
            
            
   
}
