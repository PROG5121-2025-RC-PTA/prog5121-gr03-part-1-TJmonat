
package poe_part2;

import java.io.IOException;
import javax.swing.JOptionPane;



public class POE_PART2 {

   
    public static void main(String[] args) throws IOException {
    
  username();//We are calling the username method to allow the user to login before chatting
  password();//we are calling the password method to allow the user to input their password 
Sender_Message1.main(args); //we are calling the sender message class which is in the same package to be able to run everything from the sender message class
    }
    
   public static void username(){
        
    String [] username=new String [2];//this will take two users and store their details in an array
    boolean allValid=true;//we initialize the allvalid to be true in order to test whenever it is false
    for(int i=0;i<username.length;i++){//This will loop twice since we have two users who will input 
        username[i]=JOptionPane.showInputDialog("Please enter user name \n Make sure it is less tha 5 characters \n Contains an underScore _",(i+1));//this is where we will prompt the user for entry
        if(username[i].length()<5 && !username[i].contains("_")){//the if statement will check if the users input meets all the requirements 
            JOptionPane.showMessageDialog(null, "Invalid user name, try again");//this statement will display if the users input is invalid 
            allValid=false;//and we will initialize the allvalid to false 
           break;
                                                                }
    
    else {//the else will display if the users input is valid 
        JOptionPane.showMessageDialog(null, "User name captured sucessfully");//this is the statement the user will see
        System.out.println("User name is:"+username[i]+(i+1));//this line will print out the users username
      
          }
                                      }
    
                              }
        
    public static void password(){
          
  
       String [] password= new String [2];//this will take two users input and store them in an array
          boolean allValid=true;//we initialize the allvalid to be true in order to test whenever it is false
       for (int j=0;j<password.length;j++){//This will loop twice since we have two users who will input 
       password[j]=JOptionPane.showInputDialog(null, "Please enter password\n Make sure your password is:\nHas not more than 8 characters\nHas one special case\n Has one Capital Letter\n Has one digit",(j+1));//this is where we will prompt the user for entry
       if(password[j].length()>8 && !password[j].contains(".*[^a-zA-Z0-9].*") && !password[j].contains(".*[A-Z].*") && !password[j].contains(".*[0-9].*")){//the if statement will check if the users input meets all the requirements
           JOptionPane.showMessageDialog(null, "Invalid password entry, Try again");//this statement will display if the users input is invalid 
           allValid=false;//and we will initialize the allvalid to false 
         
       }
       else{//the else will display if the users input is valid 
           JOptionPane.showMessageDialog(null,"Valid password entry");//this is the statement the user will see
           System.out.println("Password is for user:"+(j+1)+password[j]);//this line will print out the users username
                }
   }
   
    }

}
