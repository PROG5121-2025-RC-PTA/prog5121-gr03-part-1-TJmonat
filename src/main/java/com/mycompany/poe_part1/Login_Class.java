/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poe_part1;
import javax.swing.JOptionPane;
/**
 *
 * @author tsheg
 */
public class Login_Class {
      //ALL THE METHODS CONTAIN PARAMETERS FROM THE METHODS IN THE MAIN CLASS
  
    public static boolean checkUsersName(String usersName,int lengthCheck){//method used to check if the username meets all the requirments 
        if(usersName.contains("_") && lengthCheck<=5 )//the if will test all the conditions
            return true;//the method will return true if the the username is correct
        else 
            return false;//else it will return false
         } 

public static boolean checkPasswordComplexity(String password,int lengthcheckers){ //this method will check the password entered by the user if it meets all the requirements
    //the Method will check if the password enterd meets all the requirements 
    if( password.contains("!") || password.contains("@") || password.contains("#") || password.contains("$") || password.contains("%") || password.contains("^") || password.contains("&") || password.contains("*") || password.contains("-") || password.contains("|") || password.contains(";") || password.contains(">") || password.contains("<") || password.contains("/") || password.contains("?") || password.contains("]") || password.contains("[") || password.contains("}") || password.contains("{") || password.contains("~") || password.contains("`") || password.contains(".") || password.contains("=") ||  password.contains("_") ||  password.contains("/") && lengthcheckers==8 && password.contains("A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z") && password.contains("1,2,3,4,5,6,7,8,9,0"))
    return true;//the method will return true if the the password is correct
    else 
        return false;//else it will return false

    

}
public static boolean checkCellPhoneNumber(int countryCode,int  cellPhoneNumber,int lengthchecker,int validCountryCode, String  callNo){//this method will check for the cellphone and country code recieved from the user
    if( lengthchecker==10 &&   countryCode== validCountryCode )
        return true;//the method will return true if the the cellphone is correct is correct
    else
        return false;//else it will return false
      
}
public static String registerUser(String usersName,int lengthCheck,String password, int lengthcheckers){
  //the following if statements will be false 
    if(!usersName.contains("_")){
       if( lengthCheck!=5){
           if(! password.contains("!") || !password.contains("@") || !password.contains("#") || !password.contains("$") || !password.contains("%") || !password.contains("^") || !password.contains("&") || !password.contains("*") || !password.contains("-") || !password.contains("|") || !password.contains(";") || !password.contains(">") || !password.contains("<") || !password.contains("/") || !password.contains("?") || !password.contains("]") || !password.contains("[") || !password.contains("}") || !password.contains("{") || !password.contains("~") || !password.contains("`") || !password.contains(".") || !password.contains("=") ||  !password.contains("_") ||  !password.contains("/") ){
           if(!password.contains("1,2,3,4,5,6,7,8,9,0")){
               if(!password.contains("A,B,C,D,E,F,G,H,I,J,K,L,O,M,N,P,Q,R,S,T,U,V,W,X,Y,Z")){
                   if( lengthcheckers!=8){
                     return "The above conditions have not been met";  
                   }
                   
               }
           }
       }
       }
   }
 
   else{//else the criterias are true
      return "The criteria's have been met";
   }
      return  null;//needed statement in order for this method to be correct 
        
  }



public static boolean loginUser(String usersName,String  password,String loginUserName,String loginPassword){
   if (usersName.matches(loginUserName) &&  password.matches(loginPassword))
    return true;
   else{
      return false;//else it will return false
   }
}
//This method will return the statements if everything the users inputs are all correct
public static String returnLoginStatus(String usersName,String password,int cellPhoneNumber,int lengthchecker,String loginUserName,String loginPassword,int countryCode,int validCountryCode){
  if( usersName.equals(loginUserName)){//this if will double check the username
      
  if(password.equals(loginPassword)){//this if will double check the password
  if( lengthchecker==10 ){//this if will double check the length of the cellphone number
  if( countryCode== validCountryCode){//this if will double check the country code
      JOptionPane.showMessageDialog(null, "A successful Login");//message to be displayed if all the information is corect
return "A successful login";//the return status
  }
  }
  }
  }

else 
      //message to be shown if the users input is incorrect
      JOptionPane.showMessageDialog(null, "A failed login:\n Please re try the login process,reading all the requirements needed for eacg criteria");
 return "A Failed Login";//the return status
        
  }
}
