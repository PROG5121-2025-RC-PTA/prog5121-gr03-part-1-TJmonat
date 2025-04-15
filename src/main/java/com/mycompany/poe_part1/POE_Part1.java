/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poe_part1;

import javax.swing.JOptionPane;
import java.awt.Image;//ChaTGPT Assistane
import javax.swing.ImageIcon;//ChatGPT Assistance

//Assistance from ChatGPT to ass arrays in this program
public class POE_Part1 {
//Assistance from ChatGPT to be able to call the method accountLogin because the method made use of data from the username method and passWord method
    static String [] usersName=new String[5];//stores 5 usernames in an array
    static String[]  password=new String[5];//stores 5 user passwords in an array
    static    int[]   cellPhoneNumber=new int[5];//stores 5 users cellphone number in an array
     public static void main(String[] args) {
      //Assistance from an online YouTube video to change JOption Pane Icon
   
   ImageIcon icon1=new ImageIcon("TT.jpg"); 
     Image scaledIcon1= icon1.getImage().getScaledInstance(60, 60, 0);
     ImageIcon newIcon1=new ImageIcon( scaledIcon1);
     JOptionPane.showMessageDialog(null, "Welcome to Chatty Chat","Welcome",JOptionPane.PLAIN_MESSAGE,newIcon1);
    
     int feedback=JOptionPane.showConfirmDialog(null,"Have you registered?","Registration check",JOptionPane.YES_NO_OPTION);//asking the user if they registered or logged in
    
     if(feedback==JOptionPane.YES_OPTION){//testing the conditions, if its yes the user will go to the login method
        JOptionPane.showMessageDialog(null, "Please Login");
        for(int i=0;i<5;i++){
        accountLogin( i);
        }
     }
     else{
         JOptionPane.showMessageDialog(null,"Please register");//if the uer inputs no the user will start at the username method then move on to the password method the finally the cellphone number method
         for(int i=0;i<5;i++){//this will loop 5 times
           username(i);
      passWord(i);
         phoneNumber(i);
         }
     }
     JOptionPane.showMessageDialog(null, "Please kindly follow the up Coming instructions in order to register ");
     for(int i=0;i<5;i++){//this is the loop for the called methods 
         username(i);
      passWord(i);
         phoneNumber(i);
     }
     
    //Calling all the methods to be displayed
    
   
 
    }
public static void username(int i){  //Method used to ask the user for their username
 while(true){ //Loop used to make the code loop until correct information is presented
   
     JOptionPane.showMessageDialog(null, "Please enter a UserName that contains:\n-Characters not longer than 5 and a underscore");
       usersName [i]=JOptionPane.showInputDialog(null,"Please enter username"+(i+1));
               
           int lengthCheck=usersName[i].length(); // Checks the length of the username characters
     if(Login_Class.checkUsersName(usersName[i],lengthCheck)){ // Assistance from ChatGPT checks if the users input meets all the requirements  
      // Message that will display if the users input meets all the requirements
       JOptionPane.showMessageDialog(null, "Username added successfully");
       System.out.println("User :"+(i+1)+"Your username is:"+ usersName[i]); 
       break; // end of the loop
       
   }
     else{
       JOptionPane.showMessageDialog(null, "Plaese re-try username enrty", "Incorrect user name",JOptionPane.ERROR_MESSAGE); // message that will be displayed is the user inputs incorrect formats of the user name
      
   }
  
     
     
    
   
 }
     
}
public static void passWord(int i){ // method that will be used to ask the user for the password
   while(true){ // this loop will loop untile the user inputs the correct information 
    JOptionPane.showMessageDialog(null, "Please enter password\n Note that your password should contain\n-At least 8 characters\n-Should contain one Capital letter\n-Should contain a number\n-Should contain one special case");
     password[i]=JOptionPane.showInputDialog(null, "Please enter your passowrd", "Password required"+(i+1));
   
  int lengthcheckers=   password[i].length(); // checks the length of the passowrd enterd Assistance from ChatGPT
 if(Login_Class.checkPasswordComplexity(password[i], lengthcheckers)){ // the if will check if the users input all meets all the requirments 
     JOptionPane.showMessageDialog(null, "Your password meets all the requirements and is successfully added");
     System.out.println("User "+ (i+1)+"Your password is:"+password[i]);// message to be displayed if the users input is correct
     break;// this stops the loop
 }
 else{
     JOptionPane.showMessageDialog(null, "Password entered is incorrect please try again","Password Incorrect",JOptionPane.ERROR_MESSAGE);// message that will show if the user inputs the incorrect format
 }
}
}

public static void phoneNumber(int i){ // the method will ask the user for their cellphone number
  while(true){ // This loop is created,that everytime the user inputs incorrect information it will loop
    //the message displayed will tell the user what is needed 
     JOptionPane.showMessageDialog(null, "Your cellPhone number will contain +27");
     int countryCode=+27;
 System.out.println("The country code is:"+countryCode);//This will disiplay the code enterd 
 JOptionPane.showMessageDialog(null, "Please enter valid Cellphone number ", "CellPhone Number Entry",JOptionPane.PLAIN_MESSAGE);//message informing the user on what step to take next 
 String callNo=JOptionPane.showInputDialog(null, "Please enter valid cellPhone number ","Input valid cellphone number",JOptionPane.OK_OPTION);
   int validCountryCode=countryCode;
     int  lengthchecker=  callNo.length();//this will check the length of data presented 
     
       cellPhoneNumber[i]=Integer.parseInt( callNo);//converting callNo into an integer
     if(Login_Class.checkCellPhoneNumber(countryCode, lengthchecker, lengthchecker, validCountryCode, callNo)){ //the if statement will check if the user met the requirements 
         JOptionPane.showMessageDialog(null, "Phone number is successfully added");//message shown if user presented corretly formatted information 
         System.out.println("User "+(i+1)+"Cellphone number is:"+"+"+validCountryCode+ cellPhoneNumber[i]);//this will combine the country code and the cellphone number and display both of them
    break;//the end of the while loop 
     }
     else{
         //message shown if incorrect data is presented 
         JOptionPane.showMessageDialog(null, "Cellphone number format is incorrect\n Please try again", "Incorrect format", JOptionPane.ERROR_MESSAGE);
     }
  
  }  
}
public static void accountLogin(int i){ //this method will now log the user in confirming all the datas enterd before
    while(true){//this loop will loop as long as the users input does not match the information recived in the previous methods
    JOptionPane.showMessageDialog(null, "You are now logging in");//message alterting the user that they are logging in 
    JOptionPane.showMessageDialog(null,"NOTE\nPease ensure that the information recievd here matches the information you input at the first trial");
    String loginUserName=JOptionPane.showInputDialog(null, "Please enter username", "Login with valid username");//asking the user to enter the same data they entered at the first method 
    String loginPassword=JOptionPane.showInputDialog(null, "Please enter your Password");//asking the user to enter the same password entered in the passWord method else it will continue to loop untile data matches
    String lastName=JOptionPane.showInputDialog(null, "Pleas enter your last name");//asking the user for their last name 
   
   
    if(usersName[i].matches(loginUserName) && password[i].matches(loginPassword) ){//this if statement will check if the data in the accountLogin method and the userName and passWord match
      //this message will be displayed if the users entry is correct 
      ImageIcon icon2=new ImageIcon("smiler.jpg"); 
     Image scaledIcon2= icon2.getImage().getScaledInstance(60, 60, 0);
     ImageIcon newIcon2=new ImageIcon( scaledIcon2);
      
      JOptionPane.showMessageDialog(null, "Welcome"+loginUserName+" "+lastName+" "+"It is nice to see you again", "Welcome",JOptionPane.YES_OPTION, newIcon2);
   break;//end of the loop
    }
    
    else{
        //message asking the user to correctly input the data
       JOptionPane.showMessageDialog(null, "Please Re-Try your entry and make sure that the details match the first ones enterd", "Incorrect Information",    JOptionPane.ERROR_MESSAGE);
    }
    }
    
}
}
