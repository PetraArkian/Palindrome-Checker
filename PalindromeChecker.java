/**PalindromeChecker.java
 * @author Samantha Lincroft
 * @date 10/18/17
 * 
 * A class that uses stacks to check whether a string is a palindrome
 * */

import javafoundations.*;

public class PalindromeChecker{
  
  
  /** 
   * @method main() 
   * @param args reads a string from the command line to test whether it is a palindrome 
   * */
  public static void main(String[] args){
    
    //run on input from the command line
    try{
      System.out.println("\n" + args[0] + " is a palindrome? " + checkPalindrome(args[0]));
    }
    catch(ArrayIndexOutOfBoundsException ex){ //if no argument was passed in from the command line prompt the user to input a string with their terminal command
      System.out.println("Please input a string to check as a palindrome");
    }
    
    String[] TenPalindromes = {"asantaatnasa" , "airanaria" , "aviddiva" , "bombardadrabmob" , "ostonebenotso"
      , "toidiot", "wontipanicinapitnow" , "kinikinik" , "fleetomeremoteelf", "qwertyuiopoiuytrewq"};
    String[] TenNotPalindromes = {"turtlesallthewaydown" , "hijodelaluna" , "infinateseries" , "notapalindrome", "palindrome" 
      , "johngreen" , "holmsey" , "nerdfighter" , "dftba" , "zzzzza"};
    
    for(int i=0; i<10; i++){
       System.out.println("\n" + TenPalindromes[i] + " is a palindrome? " + checkPalindrome(TenPalindromes[i]));
       System.out.println("\n" + TenNotPalindromes[i] + " is a palindrome? " + checkPalindrome(TenNotPalindromes[i]));
    }
    
    
  }
  
  /**
   * @method checkPalindrome uses two stacks to check whether a string is a palindrome. 
   * @param str the string that is being checked as a palindrome
   * @return true if the string is a palindrome, false if it is not
   * */
  public static boolean checkPalindrome(String str){
    
    System.out.println("\nTesting whether " + str + " is a palindrome"); 
    
    char[] charArr = str.toCharArray();
    Stack<Character> forward = new ArrayStack<Character>();
    Stack<Character> backward = new ArrayStack<Character>();
    
    for(int i=0; i<str.length(); i++){ //push everything onto the forward stack
      forward.push(charArr[i]);
    }
    
    
    for(int i=0; i<str.length()/2; i++){ //take the top half and reverse it onto the backward stack
      backward.push(forward.pop());
    }
    
    if(forward.size()>backward.size()){ //if there is an odd number of terms get rid of the middle one (it doesn't have to match anything)
      forward.pop();
    }
    
    System.out.println("forward stack: \n" + forward);
    System.out.println("backward stack: \n" + backward);
    
    while(!forward.isEmpty()){
      if(forward.pop()!=backward.pop()) return false;
    }
    
    return true;
    
    
  }
  
}