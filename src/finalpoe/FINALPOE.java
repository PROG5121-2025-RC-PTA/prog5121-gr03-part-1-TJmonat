
package finalpoe;

import java.io.IOException;
import javax.swing.JOptionPane;


public class FINALPOE {
//Making thses variables global because they will be used throughout the program
    private static String senderNo; 
   private static int messageChoice;
   
   public static void main(String[] args) throws IOException {
    JOptionPane.showMessageDialog(null, "WELCOME TO CHATTY CHAT APP");//Welcoming the user to the chat app
 username();//We are calling the username method to allow the user to login before chatting
password();//we are calling the password method to allow the user to input their password 
senderNumber();// we are calling the senders number method to display everything inside the method
 Sender_Message1.main(args); //we are calling the sender message class which is in the same package to be able to run everything from the sender message class
  
  
    }
    
   public static void username(){
        System.out.println("------------------------------------");//to make the program neat
      
   while(true){//This loop will loop every time the user inuts incoreect data
     String userName=JOptionPane.showInputDialog(null,"Please enter a user name \n ~Make sure it contains an UnderScore \n ~It is no longer than 5 characters");//prompting the user for entry
 if(userName==null){
   break;  //this will end the loop
 }
 int lenghth=userName.length();
 if( lenghth!=5 &&  !userName.contains("_")){
     JOptionPane.showMessageDialog(null,"Re-try user name enrty");
 }
 else{
     JOptionPane.showMessageDialog(null,"User name is captured");
     System.out.println("The user name is:"+userName);//this will print out the input
     break;//this will end the loop
 }
 }
   }
        
    public static void password(){
           while(true){//This loop will loop every time the user inuts incoreect data
       
 String  password=JOptionPane.showInputDialog(null, "Please enter password\n Make sure your password is:\nHas not more than 8 characters\nHas one special case\n Has one Capital Letter\n Has one digit",(+1));
 //this block will check if the users input meets all the needed requirements 
      if( password==null){
            break;//this will end the loop
        }
     int theLength=password.length();
        if( theLength!=8  && !password.contains(".*[^a-zA-Z0-9].*") && !password.contains(".*[A-Z].*") && !password.contains(".*[0-9].*")){
           JOptionPane.showMessageDialog(null, "Try entry format");
        }
        else{
            JOptionPane.showMessageDialog(null,"Password captured correctly");//message to be displayed if the data is incorrect
            System.out.println("The pasword is:"+ password);//this will print out the input
            break;//this will end the loop
        }
        }
  
   
   
    }
      public static void senderNumber() throws IOException{
  while (true) {
             senderNo = JOptionPane.showInputDialog(null, "Please enter your cellphone number as the sender of the message \n Please make sure your number is not more than 10 digits");
//This block of code will add the senders number to the three arrays which are send, stored and disregarded
             PART_3.sendersSent.add(senderNo);
PART_3.sendersDisregard.add(senderNo);
PART_3.sendersStored.add(senderNo);
             
if(messageChoice==0){ 
}//this block will check if the users input meets all the needed requirements 
 if (senderNo == null) {
     break;//this will end the loop
                       }
 int lengthView = senderNo.length();
if (lengthView > 10 ||lengthView <10 ) {
     JOptionPane.showMessageDialog(null, "Number formatt is incorrect try again!");
    } else {
     int sendersNumber = Integer.parseInt(senderNo);
      JOptionPane.showMessageDialog(null, "Number added succcesfully");
     System.out.println("The Senders Number is:+27"+sendersNumber );//this will print out the input
                break;//this will end the loop
            }
        }

    }

    
    
}
