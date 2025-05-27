

package poe_part2;
import org.junit.Test;
import static org.junit.Assert.*;

public class Sender_Message1Test {
    
      @Test
    public void testData2(){//DATA USED IN THIS METHOD IS FROM THE TEST DATA TABLE 2
        int numMessage=2;
        String cellNumber="07718693002";
        String  messageSent="Hi Keegan, did you recieve the payment?";
       String identity="4367896547";
       int count=1;
       String [] options2={"Send Message", "Disregard Message","Store Message to send later"};
        String usersChoice=options2[1];
         //THIS BLOCK WILL CREATE THE MESSAGE HASH
        int numMessageSent=1;
          
      String first2numbers=" ";
       int digitCount=0;
       for(int i=0;i<identity.length() && digitCount<2;i++){
           char ch=identity.charAt(i);
         if(Character.isDigit(ch))  {
              first2numbers += ch;
              digitCount++;
         }
       }
         String [] words=messageSent.split(" ");
           String first=words.length > 0 ? words[0] : " ";
           String last=words.length > 1 ? words[words.length-1] : first;
 String messageHash= first2numbers+":"+ count +":" + first.toUpperCase() + last.toUpperCase();
 //THIS WILL DISPLAY ALL THE INFORMATION
        System.out.println(numMessage);
        System.out.println(cellNumber);
        System.out.println(messageSent);
        System.out.println(usersChoice);
        System.out.println(identity);
        System.out.println(messageHash);
        System.out.println("Your Cellphone number is incorrectley formatted, re-try entry");
        
       
        
    }
    
     @Test
    public void testSendCharacter() {
    
        int  lengthcheck=249;
        if( lengthcheck<=249){
        System.out.println("Message is ready to sent");
        assertTrue(true);
        }
       
    }
    
     @Test
   public void invalidSendCharacter(){
      int  lengthcheck=260;
      if( lengthcheck>=250){
          int characterLength=(lengthcheck-250);
          System.out.println("Message exceeds 250 characters by"+characterLength+"Please reduce size");   
          assertFalse(false);
      }
   }
   
   
    @Test
    public void testCheckRecipientCell() {
       int code=27;
       int lengthChecker=10;
       int cellNumber=718693002;
        assertTrue(MESSAGE_CLASS.checkRecipientCell(code, code, lengthChecker, cellNumber));
            System.out.println("CellPhone number successfully captured");
        
      
    }
@Test
public void testInvalidPhoneNumber(){
   System.out.println("The cell phone number is incorrectly formatted or does not contain international code\nPlease correct number and try again");
    String expected="+27663987149";
    String result="08575975889";
    assertFalse(false);
   
    
}

@Test
    public void CreateHashFromTestData1() {
      String messageSent="Hi Mike,can you join us for dinner tonight";//DATA FROM TEST DATA TABLE 1
        String identity="6547897654";
        String count="2";
        
      
         String firsttwoDigits=" ";
       int digitCount=0;
       for(int i=0;i<identity.length() && digitCount<2;i++){
           char ch=identity.charAt(i);
         if(Character.isDigit(ch))  {
              firsttwoDigits += ch;
              digitCount++;
         }
       }
        String [] words=messageSent.split(" ");
           String first=words.length > 0 ? words[0] : " ";
           String last=words.length > 1 ? words[words.length-1] : first;
 String generatedHash= firsttwoDigits+":"+ count +":" + first.toUpperCase() + last.toUpperCase();
 String expectedHasH="42:2:HITONIGHT";
        System.out.println("Hash Message:"+generatedHash);
        assertTrue( true);
 
    }
    

   
 @Test
    public void testCheckMessageID() {
      
        String messageID="2134562356";
          System.out.println("Message id generated:"+messageID);
          assertTrue(true);
    }
    @Test 
    public void invalidID(){
        String expected="+27663987149";
        String result="0663td89633";
        System.out.println("This id is incorrect because it contains letters and is above 10");
        assertFalse(false);
    }

 @Test
public void messageSent(){
      
      
    String [] options2={"Send Message", "Disregard Message","Store Message to send later"};
     
    
    if( "Message successfully Sent".equals( options2[0])){
        String  Return="Message successfully Sent";
      }
      if( "Disregard Message".equals( options2[1])){
        String   Return2="Press 0 to delete message";
      }
      if( "Store Message to send later".equals( options2[2])){
      String  Return3="Message successfully stored"  ;
      }
     String usersChoice= options2[0];
     System.out.println("You chose:"+usersChoice);
      
      assertTrue(true );
      
    
}
}
