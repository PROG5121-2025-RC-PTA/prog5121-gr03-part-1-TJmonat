
package finalpoe;

import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.json.JSONObject;
import org.json.JSONArray;


public class PART_3 {
        // Array For Sent Messages
    public static ArrayList<String> sendersSent = new ArrayList<>();
    public static ArrayList<String> recipientsSent = new ArrayList<>();
    public static ArrayList<String> idsSent = new ArrayList<>();
    public static ArrayList<String> messagesSent = new ArrayList<>();
    public static ArrayList<String> hashesSent = new ArrayList<>();

    // Array For Stored Messages
    public static ArrayList<String> sendersStored = new ArrayList<>();
    public static ArrayList<String> recipientsStored = new ArrayList<>();
    public static ArrayList<String> idsStored = new ArrayList<>();
    public static ArrayList<String> messagesStored = new ArrayList<>();
    public static ArrayList<String> hashesStored = new ArrayList<>();

    // For Disregarded Messages
    public static ArrayList<String> sendersDisregard = new ArrayList<>();
    public static ArrayList<String> recipientsDisregard = new ArrayList<>();
    public static ArrayList<String> idsDisregard = new ArrayList<>();
    public static ArrayList<String> messagesDisregard = new ArrayList<>();
    public static ArrayList<String> hashesDisregard = new ArrayList<>();

public static void displayMessageSend(){
    //this will be displayed based on the users choice
    System.out.println("\n-------These are the Send Message-------------");
    for(int i = 0; i < PART_3.sendersSent.size(); i++){
        System.out.println("The Senders Number:"+PART_3.sendersSent.get(i));
        System.out.println("The Reciever:"+PART_3.recipientsSent.get(i));
        System.out.println("The message ID:"+PART_3.idsSent.get(i));
        System.out.println("The Message is:"+PART_3.messagesSent.get(i));
        System.out.println("The message Hash is:"+PART_3.hashesSent);
        System.out.println("---------------------------------------");
    }
       
}
public static void displayDisregardedMessages(){
     //this will be displayed based on the users choice
    System.out.println("\n -----------These are the Disregarded Messages-------------");
    for(int t=0;t<PART_3.sendersDisregard.size();t++){
          System.out.println("The Senders Number:"+PART_3.sendersDisregard.get(t));
        System.out.println("The Reciever:"+PART_3.recipientsDisregard.get(t));
        System.out.println("The message ID:"+PART_3.idsDisregard.get(t));
        System.out.println("The Message is:"+PART_3.messagesDisregard.get(t));
        System.out.println("The message Hash is:"+PART_3.hashesDisregard.get(t));
        System.out.println("---------------------------------------");
    }
}
public static void storedMessages(){
     //this will be displayed based on the users choice
     System.out.println("\n -----------These are the Stored Messages-------------");
    for(int s=0;s<PART_3.sendersStored.size();s++){
          System.out.println("The Senders Number:"+PART_3.sendersStored.get(s));
        System.out.println("The Reciever:"+PART_3.recipientsStored.get(s));
        System.out.println("The message ID:"+PART_3.idsStored.get(s));
        System.out.println("The Message is:"+PART_3.messagesStored.get(s));
        System.out.println("The message Hash is:"+PART_3.hashesStored.get(s));
        System.out.println("---------------------------------------");
    }
}

public static void storeInJsonFile(  ) throws IOException{
 
   JSONArray messageArray=new JSONArray();
  for(int i=0;i< sendersStored.size();i++){
      JSONObject messageObject=new JSONObject();
    
      messageObject.put("Sender:",sendersStored.get(i));
      messageObject.put("Reciever", recipientsStored.get(i) );
      messageObject.put("Message ID:",idsStored.get(i) );
      messageObject.put("Message:", messagesStored.get(i) );
      messageObject.put("Message Hash:",hashesStored.get(i) );
      messageArray.put(messageObject);
      
      
  }
 
  try {FileWriter fileWriter=new FileWriter("MessageArray",true);
    fileWriter.write(messageArray.toString(4));
      System.out.println("Saved to json.json");
  }catch(IOException e){
      e.printStackTrace();
  }//CHAT GPT ASSISTANCE , I COLUD NOT DISPLAY THE ARRAY IN A FILE BUT THIS IS A SAMPLE VISUAL OF HOW IT COULD HAVE BEEN
    System.out.println("----------OutPut For JSON FILE");
  System.out.println(messageArray.toString(4));

}
public static void seachId(){
    //this method will ask the user if they want to search for a specific message send using message id
    int search=JOptionPane.showConfirmDialog(null, "Do you want to search for a particular message and recipient?","Displaying Recipient and Message",JOptionPane.YES_NO_OPTION);
    if(search==JOptionPane.YES_OPTION){//if yes this code is execute
    String idToBeSearched=JOptionPane.showInputDialog("Please Enter the correct id for that specific message \n Make sure it matches the first entered message id");//ask the user for the message id

    boolean found=false;//set boolean to false 
    for(int i=0;i<idsSent.size();i++){
       if(idsSent.get(i).equals(idToBeSearched)) {//if they match this information will be displayed
           System.out.println("-----------------Results Of the Search in the Sent Message Array---------------------");
           System.out.println("ID:"+idToBeSearched);
           System.out.println("Recipient:"+recipientsSent.get(i));
           System.out.println("The Message:"+messagesSent.get(i));
           System.out.println("------------------------------------------");
           found=true;//boolean will be true because it is found
           break;
       }
    }//if they id wasnt found in the sent array it will be checked in the stored array
    if(!found){
          for(int i=0;i<idsStored.size();i++){
       if(idsStored.get(i).equals(idToBeSearched)) {
           System.out.println("-----------------Results Of the Search in the Stored Message Array---------------------");
           System.out.println("ID:"+idToBeSearched);
           System.out.println("Recipient:"+recipientsStored.get(i));
           System.out.println("The Message:"+messagesStored.get(i));
           System.out.println("------------------------------------------");
           found=true;
           break;
    }
            }
}//if they id wasnt found in the stored array it will be checked in the disregard array
     if(!found){
          for(int i=0;i<idsDisregard.size();i++){
       if(idsDisregard.get(i).equals(idToBeSearched)) {
           System.out.println("-----------------Results Of the Search in the Disregarded Message Array---------------------");
           System.out.println("ID:"+idToBeSearched);
           System.out.println("Recipient:"+recipientsDisregard.get(i));
           System.out.println("The Message:"+messagesDisregard.get(i));
           System.out.println("------------------------------------------");
           found=true;
           break;
    }
            }
}//if it wasnt found in all arrays this message will display 
     if(!found){
         System.out.println("Message id not found in any category");
     }
    
     
}
}
public static void searchMssageSend(){//this method will ask the user if they want to search the array using the recipients number 
    int userschoic=JOptionPane.showConfirmDialog(null,"Do you want to search for a  messages sent to a specific number?","Search Array",JOptionPane.YES_NO_OPTION);
    if( userschoic==JOptionPane.YES_OPTION){//if yes the user will have to enter the number which will be used to search through all the arrays 
        String recipientsNumber=JOptionPane.showInputDialog("Enter the recipients number \n Make sure it matches the first entered number");
       
        boolean found=false;
       
        //if they match this information will be displayed
        for(int r=0;r<recipientsSent .size();r++){
            if(recipientsSent.get(r).equals(recipientsNumber)){
                   System.out.println("-----------------Message sent to Recipient---------------------");
                System.out.println("The number is:"+recipientsNumber);
                System.out.println("These are the messages sent to the recipient:"+messagesSent.get(r));
                 System.out.println("------------------------------------------");
                found=true;
                break;
            }
            
        }//if they id wasnt found in the sent array it will be checked in the stored array
        if(!found){
        for(int i=0;i<recipientsStored .size();i++){
            if(recipientsStored.get(i).equals(recipientsNumber)){
                  System.out.println("-----------------Message sent to Recipient---------------------");
                System.out.println("The number is:"+recipientsNumber);
                System.out.println("These are the messages sent to the recipient:"+messagesStored.get(i));
               System.out.println("------------------------------------------");
                found=true;
                break;
            }
            
        }
        }//if they id wasnt found in the stored array it will be checked in the disregard array
        if(!found){
        for(int s=0;s<recipientsDisregard .size();s++){
            if(recipientsDisregard.get(s).equals(recipientsNumber)){
                   System.out.println("-----------------Message sent to Recipient---------------------");
                System.out.println("The number is:"+recipientsNumber);
                System.out.println("These are the messages sent to the recipient:"+messagesDisregard.get(s));
                System.out.println("------------------------------------------");
                found=true;
                break;
            }
            
        }
        }//if it wasnt found in all arrays this message will display 
         if(!found){
         System.out.println("Recipient was found not found in any category");
     }
   
   
    }
    
}
public static void deleteHash( ){//THIS METHOD DOES NOT WORK EFFICIENTLY
    int usersChoice=JOptionPane.showConfirmDialog(null,"Do you want to delete any message?","Search With Hash",JOptionPane.YES_NO_OPTION);//this method will allow the user to delete any message they entered with the message hash
    if(usersChoice==JOptionPane.YES_OPTION){
        String hash=JOptionPane.showInputDialog("Please enter message hash");//the user will be asked to provide the message hash
        boolean found=false;
       //Then the hash will be used to check the arrays till a match is found 
        for(int h=0;h<messagesSent.size();h++){
      String currentHash=hashesSent.get(h);
            if(currentHash.equals(hash)){
               messagesSent.remove(h);
               String removedMessage=messagesSent.get(h);
               System.out.println("The removed message is:\t" + removedMessage);
               found=true;
               break;
           }
        }
        if(!found){
         for(int d=0;d<messagesStored.size();d++){
             String currentHah=hashesStored.get(d);
           if(currentHah.equals(hash)){
               messagesStored.remove(d);
               String removedMessage=messagesStored.get(d);
               System.out.println("The removed message is:\t" + removedMessage);
               found=true;
               break;
               
           }
        }
        }
        if(!found){
          for(int e=0;e<messagesDisregard.size();e++){
              String currentHash=hashesDisregard.get(e);
           if(currentHash.equals(hash)){
               messagesDisregard.remove(e);
               String removedMessage=messagesDisregard.get(e);
               System.out.println("The removed message is:\t" + removedMessage);
               found=true;
               break;
               
           }
        }
        }//if no match was found this message will display
          if(!found){
              System.out.println("Could not delete any message");
          }
          
    }
}


}
