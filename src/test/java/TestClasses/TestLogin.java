/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package TestClasses;

import com.mycompany.partonepoe.Login;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author kvmaq
 */
public class TestLogin {
    //Covers all assertEquals and assertTrue/assertFalse cases from the assignment specifications
    private Login login;
    
    @BeforeEach
    public void setUp(){
    //Create a Login object with known valid credentials for login tests
      login = new Login("kyl_1", "Ch&&sec@ke99!","+27839868976",'Kyle', "Smith");
    }
   
    //Username tests
    @Test
    public void testUserNameCorrectlyFormatted(){
     //"kyl_1" has underscore, 5 charcters so it should return true
     assertTrue(login.checkUserName("kyl_1"),"Username 'kyl_1' should be correctly formatted.");
    }
    
    @Test
    public void testUsernameIncorrectlyFormatted(){
        //"kyle!!!!!" has no underscore, more than 5 characters so it should return false
        assertFalse(login.checkUserName("kyle!!!!!"),"Username 'kyle!!!!!' should be incorrectly formatted.");
    }
    
    @Test
    public void testUsernameIncorrectlyFormattedMessage(){
        //When username is valid, registerUser should ultimately succeed
        assertFalse(login.checkUserName("kyl_1"));
    }
    
    //Password Test
    @Test
    public void testpasswordMeetsComplexityRequirements(){
        //"Ch&&sec@ke99!" has uppercase, number, special char, >8 characters so is true "
        assertTrue(login.checkPasswordComplexity("Ch&&sec@ke99!"), "Password 'Ch&&sec@ke99!' should meet complexity requirements.");
    }
    
    @Test
    public void testPasswordDoesNotMeetComplexityRequirement(){
    //"password" has no uppercase, no number, no special char so is false  
    assertFalse(login.checkPasswordComplexity("password"), "Password 'password' should not meet complexity requirments.");
    }
    
    //Cellphone number tests
    @Test
    public void testCellPhoneCorrectlyFormatted(){
        //"+27839868976" has valid SA format so is true
        assertTrue(login.checkCellPhoneNumber("+27839868976"), "Phone number '+27839868976' should be correctly formatted");
    }
    @Test
    public void testCellPhoneIncorrectlyFormatted(){
        //"08966553" has missing international code, too short so is false 
        assertFalse(login.checkCellPhoneNumber("08966553"), "Phone number '08966553' should be incorrectly formatted.";
    }
    
    //Login tests
    @Test
    public void testLoginSuccessful(){
        //Correct credentials loginUser should return true  
        assertTrue(login.loginUser("kyl_1", "Ch&&sec@ke99!"), "Login with correct credentials should succeed.");
    }
    
    @Test
    public void  testLoginFailed(){
        //Wrong password logUser should return false
        assertFalse(login.loginUser("kyl_1", "wrongpassword"), "Login with incorrect credentials should fail.");
    }
    
    //Return Login Message tests
    @Test
    public void testRegisterUserSuccess(){
        Login freshLogin = new Login("","","Kyle","Smith");
        String result = freshLogin.registerUser("kyl_1","Ch&&sec@ke99!","+27839868976");
        assertEquals("User successfully registered.", result,"registerUser should return success message for valid inputs.");
    }
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
