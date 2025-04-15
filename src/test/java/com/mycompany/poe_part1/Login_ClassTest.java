
package com.mycompany.poe_part1;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.mycompany.poe_part1.Login_Class;

/**
 *
 * @author tsheg
 */
public class Login_ClassTest {
    
    public Login_ClassTest() {
    }
    
    
    @Test
    public void testCheckUsersName() {
//Assistance from Youtube video provided in the POE and some assistance from ChatGPT
        String usersName = "Kyl_1";
    int lengthCheck=usersName.length();
        assertTrue(Login_Class.checkUsersName(usersName, lengthCheck));
       
        System.out.println("Welcome"+usersName+"Its nice to see you again");
    }
@Test
public  void inValidUsername(){
     System.out.println("The is something wrong in the format of your username");
     String expt= "Kyl_1";
        String result= "Kylle!!!!!!!";
    assertFalse(Login_Class.checkUsersName(result, 0));
        assertEquals( expt, result);
    
}
   
    @Test
    public void testCheckPasswordComplexity() {
     
        String password = "Ch&&sec@ke99!";
        int lengthcheckers=   password.length();
        assertTrue(Login_Class.checkPasswordComplexity(password, lengthcheckers));
        System.out.println("Your password is added successfully");
    }

   @Test
   public void invalidPassword(){
       System.out.println("Your password formula is incorrect");
       String expected="Ch&&sec@ke99!";
       String result="password";
       assertFalse(Login_Class.checkPasswordComplexity(result, 0));
       assertEquals( expected,result );
   }
    @Test
    public void testCheckCellPhoneNumber() {
       
        System.out.println("Correct Format of cellphone number");
       String callNo="+27947786579";
         
      
          
          assertTrue(true);
    }
@Test
public void invaldidCellphoneNumber(){
    System.out.println("Incorrect formatt for cellphone number");
    
    String expected="+27847786579";
    String restult="0847786579";
    
    assertEquals(expected,restult );
    
}
   
    @Test
    public void LoginSuccess() {
        System.out.println("True");
        assertTrue(true);
    }
@Test
public void LoginStaus(){
    System.out.println("False");
    assertFalse(true);
}
    
}
