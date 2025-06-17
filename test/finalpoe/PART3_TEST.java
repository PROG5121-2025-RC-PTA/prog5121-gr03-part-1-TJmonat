
package finalpoe;

import java.util.ArrayList;

import org.junit.Test;
import static org.junit.Assert.*;

public class PART3_TEST {
    
   @Test
   public void SendMessageArray(){
    
       ArrayList<String> sendMessage=new ArrayList();
   sendMessage.add("Did you get the cake");
     sendMessage.add(  "It is dinner time");
        System.out.println("These are the sent messages:"+ sendMessage);
   
   }
   @Test
   public void longestMessage(  ){
        
      String[] sendMessages={"Did you get the cake","It is dinner time"};
      String [] storedMessages={"Where are you? You are late! I have asked you to be on time","Ok, I am leaving without you."};
      String [] disregardedMessage={"Yohoooo, i am at your gate."};
      
       String expected="Where are you? You are late! I have asked you to be on time";
     String result="";
       for(String msg: sendMessages){
         if(msg.length()>result.length()){
               result=msg;
          }
       }
     for(String msg:storedMessages){
         if(msg.length()>result.length()){
             result=msg;
         }
     }
     for(String msg: disregardedMessage){
         if(msg.length()>result.length()){
           result=msg;
         }
     }
       System.out.println("The longest Message is:\n"+result);
       assertEquals(expected,  result);
   }
   @Test
   public void messageID(){
    
       
       String [] recipientsNumber={
                  "+27834557896",
                "0838884567",
                "+27838884567",
                "+27838884567"
       };
     String [] messages={
         "Did you get the cake",
         "It is dinner time",
         "Where are you? You are late! I have asked you to be on time",
         "Ok, I am leaving without you.,Yohoooo, i am at your gate."
                      };   
   String search="0838884567";

   for(int j=0;j< recipientsNumber.length;j++){
       if(recipientsNumber[j].matches(search)){
          System.out.println("Message is:"+ messages[j]);
       }
   }
   
   }
    @Test
    public void search(){
     String [] recipientsNumber={
              "+27834557896",
              "0838884567,",
              "+27838884567",
              "+27838884567"
                                   };
     String [] messages={"Did you get the cake"
             ,"It is dinner time",
             "Where are you? You are late! I have asked you to be on time",
             "Ok, I am leaving without you."};
   String searchNumber="+27838884567";
     boolean found=false;
     for(int i=0;i< recipientsNumber.length;i++){
         if(recipientsNumber[i].equals(searchNumber)){
             System.out.println("Messages:"+ messages[i]);
        found=true;
         }
   
     }
     
    }
    @Test
    public void deleteMessage(){//come back
          
        ArrayList<String> allMessages=new ArrayList();
      
        allMessages.add("Ok, I am leaving without you.");
         allMessages.add("Where are you? You are late! I have asked you to be on time");
       
        String storedMessage1="Where are you? You are late! I have asked you to be on time";
        int numMessage=1;
          String [] words=storedMessage1.split("   ");
           String first=words.length > 0 ? words[0] : " ";
           String last=words.length > 1 ? words[words.length-1] : first;
 String messageHash= numMessage +":" + first.toUpperCase() + last.toUpperCase();
    
        
        String storedMessage2="Ok, I am leaving without you.";
        int numMessage2=1;
         String [] words2=storedMessage2.split(" ");
           String first2=words2.length > 0 ? words2[0] : " ";
           String last2=words.length > 1 ? words2[words2.length-1] : first2;
 String messageHash2= numMessage2 +":" + first2.toUpperCase() + last2.toUpperCase();
 String  [] hashes={ messageHash, messageHash2};
 String wantedHash="1:WHERETIME";
   
        for(int i=0;i< allMessages.size();i++){
       
           
            if( !hashes[i].equals(wantedHash)){
                allMessages.remove(i);
                String removedMessage=allMessages.get(i);
              System.out.println("Message:\t"+removedMessage+"\t is successfully removed" );
                     }
        }
     
        
    }
    @Test
    public void displayReport(){
       String message1="Did you get the cake" ;
       int numMessage1=1;
       String recipeint1="+27834557896";
     String [] words=message1.split(" ");
           String first=words.length > 0 ? words[0] : " ";
           String last=words.length > 1 ? words[words.length-1] : first;
 String messageHash1= numMessage1 +":" + first.toUpperCase() + last.toUpperCase();
        System.out.println("________First Send Message___________");
         System.out.println("The message Hash:"+messageHash1);
      System.out.println("The recipient:"+recipeint1);
         System.out.println("Message is:"+ message1);
         System.out.println("______________________________________");
        
         String message2="It is dinner time";
         int numMessage2=2;
         String recipient2="0838884567";
          String [] words2=message2.split(" ");
           String first2=words2.length > 0 ? words2[0] : " ";
           String last2=words2.length > 1 ? words2[words2.length-1] : first;
 String messageHash2=numMessage2 +":" + first2.toUpperCase() + last2.toUpperCase();
        System.out.println("________________Second sent message_____________");
        System.out.println("The seond message hash:"+ messageHash2);
        System.out.println("The recipient:"+recipient2);
        System.out.println("The second message:"+message2);
        System.out.println("__________________________________________________");
       
       
    }
    
}
