
package poe_part2;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.JOptionPane;

import java.io.IOException;

public class Sender_Message1 {

 public   static void main(String[] args) throws IOException {
          JOptionPane.showMessageDialog(null, "Welcome to Chatty Chat");//this statement will display after the user successfully logins in to welcom them
     
      
      
  String message=JOptionPane.showInputDialog(null,"Please enter number of messages you want to send\n If You Are not sending any Message \n Please press 0");//this line will display instructions to tell the user what to do
      int numMessage=Integer.parseInt(message);//sice the user will be entering digits we have to convert String to Int
  String [] options={"Send Messages","See Recently sent Message","Quit"};//these are the options to be displayed to the user which they then have to choose from
      int choice=JOptionPane.showOptionDialog(null, "Welcome to Chatty Chat Menu \n Please choose one of the follwing options:", "Selection menu", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
   //This will allow the user to pick String choices and convert them to int
    
 //These will be our Global variables
 String identity;
 int cellNumber;
 String messageSent = "";
 int count = 0;
 int messageChoice = 0;

   

//This while loop will work as long as the user chose to send a message 
 while( choice == 0){
//this block of code askes the user for message id
      while(true){ //this while loop will loop as long as the user inputs values that are below or above 10
   identity=JOptionPane.showInputDialog(null, "Please enter a ten digit id for your messages","ID required");//This message will display to ask the user to input their id
  if(identity==null){//IF THE IDENTITY INPUT IS EMPTY THIS LOOP WILL LOOP
      break;//BREAKING THE LOOP
  }
  
        int length=identity.length();//THIS WILL CHECK THE LENGHTH OF THE ID
        if(MESSAGE_CLASS.checkMessageID(length, identity)){//THIS IF WILL CHECK IF THE USER MET THE CONDITIONS IN THE MESSAGE_CLSASS
            JOptionPane.showMessageDialog(null, "Id captured");//IF THE USER MET ALL THE CONDITIONS THIS WILL BE DISPLAYED
            System.out.println("Message id:"+identity);//THIS STATEMENT WILL PRINT OUT THE ID
         break;                                       }
               else{
            JOptionPane.showMessageDialog(null,"Re-try entry");//if the user did not meet the given conditions this will display 
                   }
              }
 
    
   
  // this block of code asks the user to enter the recipients cellphone number 
      while (true){//placing a loop to loop everytime the user inputs incorrect information
  String number=JOptionPane.showInputDialog(null,"Please enter recepients number \n +27","Recepients Phone Number");//message to be displayed to the user
 cellNumber =Integer.parseInt(number);//converting the string number to int since we are dealing with digits
int lenghchecker=number.length();//this will check the length of the cell number
int code=+27;//required country code
int validcode=code;
if (MESSAGE_CLASS.checkRecipientCell(code, validcode, lenghchecker, cellNumber)){///THIS IF WILL CHECK IF THE USER MET THE CONDITIONS IN THE MESSAGE_CLSASS
JOptionPane.showMessageDialog(null,"Cellphone number captures successfully");//message to be displayed if the user met all the requirements 
        System.out.println("Recepients cellphone Number:"+"+"+code+ cellNumber);//this will print out the cellphne number
break;//BREAKING THE LOOP
                                                                                }
        else {
    JOptionPane.showMessageDialog(null, "Re-try entry");//message to be displayed if there is an error 
             }
      
             }
      
  
     
     //This block of code asks the user to type in the message they wish to send and checkes if the users message is not above 250 or 50
  JOptionPane.showMessageDialog(null, "Please enter your message \n Ensure your message is no longer than 250 characters");//informs the user on what the requirements are
  for (int i=0;count<numMessage;count++){
 //initialise count to 0 which will be used to count the number of messages the user sends

    messageSent =JOptionPane.showInputDialog(null,"Please enter message" +(count + 1));//asks the user to enter the message
  int  lengthcheck=  messageSent.length();//checks the lenth of the message 
       // this will add the number of messages the user enters
            System.out.println("You have enterd \t"+(count+1)+"\t So far" );//this will print out the number of messages the user has entered so far
       
            if( lengthcheck>250){//this if statement will check if the users message is less than 250 characters
            JOptionPane.showMessageDialog(null, "Please enter a message of less than 250 or 50 characters");//message to be dispkayes if the users message is above 250
                                               }
        else{
        JOptionPane.showMessageDialog(null,"Message sent");//if the message is within the limit this message will display
             }
  }
  
    
     
        String hash=MESSAGE_CLASS.createHash(message, count, messageSent); //calling the hash method from the message class
      System.out.println("Message hash \n"+ hash);//printing the hash message
    
      String messageSentOut=MESSAGE_CLASS.printMessage(messageSent);//this will print out the messages that are sent while the program is running
     int messageCount=MESSAGE_CLASS.returnTotalMessage(count, numMessage);//this will display the number of messages send during this progam
    String messageOutput=display(identity, hash, cellNumber, messageSent);//this will display the display method

break; //BREAKING THE LOOP
}
 //Calling all needed methods
  if(choice==0){//this iff will make the sendMessage to display if the user choose the first option which is to send a message
 String messageAction=MESSAGE_CLASS.sendMessage(messageChoice);//calling the message action method
 MESSAGE_CLASS.storedMessage(messageSent, choice, messageChoice);//this method will store the input message in a json file
  choice2(choice, messageChoice, messageSent);//we call this method to disply the messages that were previouly send
  }
    if(choice==1) {
        JOptionPane.showMessageDialog(null,"Coming Soon");
    }
  
  
  
      

 } 
 
   public static String display( String identity, String hash, int cellNumber ,String messageSent){//this method will give a summary of the information input by the user
        String displayInfor="Message Summary:\n" 
                          +"---------------------" +"\n"
                          + "Message ID:" +identity+ "\n"
                          + "Message Hash: \t" + hash + "\n"
                           + "Recipient number:+27" + cellNumber + "\n"
                          + "Message sent:" + messageSent;
                           JOptionPane.showMessageDialog(null, displayInfor);
     return displayInfor;//this will return the displayInfor
     }

         
      
    public static void choice2(int choice,int messageChoice,String messageSent ) throws IOException{//this method will display the message that the user sents
        int usersChoice=JOptionPane.showConfirmDialog(null,"Do you want to see recentlty send messages ","Message Review",JOptionPane.YES_NO_OPTION);
       
        if(usersChoice==JOptionPane.YES_OPTION){
       String storedMessage=  MESSAGE_CLASS.storedMessage(messageSent, choice, messageChoice);
           JOptionPane.showMessageDialog(null, storedMessage);
       System.out.println("The Stored Message is:"+storedMessage);
        }
    }
   
    
 
     

}

     

