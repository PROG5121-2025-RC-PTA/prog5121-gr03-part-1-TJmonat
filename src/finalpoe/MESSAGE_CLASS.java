
package finalpoe;

import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

class MESSAGE_CLASS {
  //global variable
    private static String senderNo;
     private static   String number;
       private static String identity ;
    private static  String messageSent ;
   private static String theHash ;
 
   
     public static boolean checkMessageID(int  length, String identity){ //this method will check the id
      if(length==10){//this will check if the users input has 10 digits
        for(int i=0;i<identity.length();i++){//this will loop though all the numbers checking if there is no letter or special case
           if (!Character.isDigit(identity.charAt(i))) {//assistance from chatgpt
               
           }
        }
      return true;}
    return false;}
    
    public static boolean checkRecipientCell(int code,int validCode,int lenghchecker, int  cellNumber){//this message will check cellphone number
        if(lenghchecker==10 && code==validCode)//this if statement will check if the users input has 10 gigits and contains the country code
            return  true;
        else 
            return false;
    }
    public static String messageLengthChecker(int  lengthcheck){//this method checks the message length
    if( lengthcheck > 250)    //this if statement checks if the message is above 250 characters if so then the message below will display
    return "This message exceeds 250 characters ";//THIS STATEMENT WILL RETURN IF THE MESSAGE CHARACTERS EXCEED 250
    
    else
       return "Your message is ready to send";//THIS MESSAGE WILL RETURN OF THE MESSAGE CHARACTER DO NOT EXCEED THE LIMIT
    
    }
   public static String createHash(String identity,int count,String messageSent){//this method creates a hash message 
       
       String first2numbers=" ";//the first two digigts are extracted and are stored here
       int digitCount=0;//
       for(int i=0;i<identity.length() && digitCount<2;i++){//this loop scans the identity string
           char ch=identity.charAt(i);
         if(Character.isDigit(ch))  {
              first2numbers += ch;
              digitCount++;
         }
       }
       
       String [] words=messageSent.split(" ");//this will spilt the words
           String first=words.length > 0 ? words[0] : " ";//this will extract the first word
           String last=words.length > 1 ? words[words.length-1] : first;//this will extract the last word
 
        String theHash=    first2numbers+":"+ count +":" + first.toUpperCase() + last.toUpperCase();//this will display all the words creating the hash message
           //this will add the message hashes to the arrays
        PART_3.hashesSent.add(theHash);
            PART_3.hashesDisregard.add(theHash);
            PART_3.hashesStored.add(theHash);
        return theHash;
   }
    public static String sendMessage(int messageChoice ) throws IOException{//THIS METHOD WILL GIVE THE USER CHOICES BASED ON WHAT THEY WISH TO DO WITH THE MESSAGE
     
        String [] options2={"Send Message", "Disregard Message","Store Message to send later"};//THIS STORES THE MESSAGE OPTIONS IN AN ARRAY
        //THIS MESSAGE WILL BE DISPLAYED TO ALLOW THE USER TO MAKE A CHOICE
        messageChoice=JOptionPane.showOptionDialog(null, "What do you want to do with the message?\n Choose any of the options below", "Message Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options2, options2[0]);
  //this will add everything to their correct array allocations
        switch( messageChoice){
       case 0:
       PART_3.sendersSent.add(senderNo);
      PART_3.recipientsSent.add(number);
      PART_3.idsSent.add(identity);
      PART_3.messagesSent.add(messageSent);
      PART_3.hashesSent.add( theHash);
      break;
  
       case 1:
       PART_3.sendersDisregard.add(senderNo);
       PART_3.recipientsDisregard.add(number);
       PART_3.idsDisregard.add(identity);
       PART_3.messagesDisregard.add(messageSent);
       PART_3.hashesDisregard.add(theHash);
       break;
   
       case 2:
       PART_3.sendersStored.add(senderNo);
       PART_3.recipientsStored.add(number);
       PART_3.idsStored.add(identity);
       PART_3.messagesStored.add(messageSent);
       PART_3.hashesStored.add(theHash);
    
     
   break;
   }//this will display the correct information based on the users choice of the message actions
   switch(messageChoice){
     
    case 0:
    PART_3.displayMessageSend();
  break;
    case 1:
        PART_3.displayDisregardedMessages();
        break;
    case 2:
 PART_3.storedMessages();
 break;
}
        
        if( messageChoice==0 ||  messageChoice==2 ||messageChoice==1){//THIS IF WILL CHECK IF THE USER PICK ANY OF THE OPTIONS IF NOT IT WILL RETURN NO OPTION SELECTED
       return  options2[messageChoice];
   }
   
   else{
        return "NO OPTION SELECTED"; 
   }
   
   } 
   public static String printMessage(String messageSent){//THIS MEETHOD WILL PRINT OUT THE MESSAGE TYPED BY THE USER
      
           System.out.println("The message is:"+messageSent);
        
            return messageSent;
                     
       
    }
   public static int returnTotalMessage(int count,  int numMessage){//THIS METHOD WILL COUNT AND DISPLAY THE NUMBER OF MESSAGES SENT BY THE USER
      if(count<=numMessage){
             System.out.println("The total number of messages sent are:"+ count);
      return count;}
      else {
          return count;
      }
       }
   public static String storedMessage(String messageSent, int choice,  int messageChoice) throws IOException{
  if( messageChoice==0 ||  messageChoice==2 ){
       
       Gson json =new Gson()  ;//this creates a new gson object to a json formetted string
     String jsonOutput=json.toJson(  messageSent);
     
       
       try(FileWriter file = new FileWriter("stored_messages",true)){//this creates a file in append mode so new messages are added
           file.write(jsonOutput + System.lineSeparator());//writes the json and adds a new line to keep each message on a separate line
           System.out.println("Successfuly written Json object file");
           }catch (IOException e){
               e.printStackTrace();//prints the error details if an IOException occures
           }
   return  jsonOutput;   } 
  else{
      System.out.println("Message not stored");
  }
 return null; }    
}
