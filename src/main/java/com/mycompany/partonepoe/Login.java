
package com.mycompany.partonepoe;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author kvmaq-Khanya Maqaqa
 */
public class Login {
    //Stored credentials and user setails (set during registration process)
   private String storedUsername;
   private String storedPassword;
   private String storedPhonenumber;
   private String storedName;
   private String storedSurname;
   
   //Regex patterns
   private String patternPassword = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*(),.?\":{}|<>]).{8,}$";
   private String phonePattern = "^\\+27\\d{9}$";
   
   /*
   Constructor- stores the registered credentials and user details 
   
   */
   
    public Login(String username, String password, String phonenumber, String name, String surname){  
        this.storedUsername = username;
        this.storedPassword = password;
        this.storedPhonenumber = phonenumber;
        this.storedName = name;
        this.storedSurname = surname;
    }
      
    /*
    --------------------------------------
    VALIDATION METHODS
    --------------------------------------------
    */
    
    /*
      Checks that the username contains an underscore and 
      is no more than five characters long
    
      will return true if valid, other will return false
    */
    public boolean checkUserName(String username){ 
        if(username.length() <= 5 && username.contains("_")){
            System.out.println("Username successfully captured");
            return true;
        }else{
            System.out.println("Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.");
            return false;
        }
    }
    /*
    Checks that the password meets complexity requirements:
     -at least 8 charaters
     -one uppercase
     -one digit
     -one special character
    */
    public boolean checkPasswordComplexity(String password){
        Pattern pattern = Pattern.compile(patternPassword);
        Matcher matcher = pattern.matcher(password);
        if(matcher.matches()){
            System.out.println("Password successfully captured.");
            return true;
        }else{
            System.out.println("Password is not correctly formatted; please ensure that the password contains at least eigth characters,a capital letter, a number and a special character ");
          return false;
        }
    }
            
   
    /*
    Checks that the phone number starts with +27 and is followed
    by exactly 9 digits (standard SA mobile).
    
    return true if valid, otherwise will return false
    */
    public boolean checkCellPhoneNumber(String phonenumber){
        Pattern pattern = Pattern.compile(phonePattern);
        Matcher matcher = pattern.matcher(phonenumber);
        if(matcher.matches()){
            System.out.println("Cell phone nymber successfully added. ");  
            return true;
        }else{
            System.out.println("Cell phone number incorrectly formatted or does not contain international code(+27)");
            return false;
        }
    }
    
    /*
    ----------------------------------------
    REGISTRATION
    ----------------------------------------
    */
    
   /*
    Validates username, password and phone number entered during registration
    Returns a registration status message
    */
    public String registerUser(String username, String password, String phonenumber){
        
        boolean validUsername = checkUserName(username);
        boolean validPassword = checkPasswordComplexity(password);
        boolean validPhone = checkCellPhoneNumber(phonenumber);
        
        if(!validUsername){
            return "Registration failed: invalid username.";
        }
        if(!validPassword){
            return "Registration failed: invalid password.";
        }
        if(!validPhone){
            return "Registration failed: invaild cell phone number.";
        }
        //Persist valid credential so loginUser() method can compare against them
        this.storedUsername = username;
        this.storedPassword = password;
        this.storedPhonenumber = phonenumber;
        
        return "User successfully registered.";
    }
     
    /*
    ------------------------------------------------------
    LOGIN
    -------------------------------------------------------
    */
    
    /*
    Checks whether the supplied username and password match the stored credentials
    
    returns true if login is successful otherwise will return false on failure
    */
    public boolean loginUser(String username, String password){
        
        if(username.matches(username) && password.matches(password)){
            System.out.println("Username and password match.");
            return true;
        }
        else{
            System.out.println("Username or password incorrect, please try again.");
            return false;
        }
        
    }
    
    public String returnLoginStatus(String username, String password){
        if(loginUser(username, password)){
            return "Welcome "+storedName+" "+storedSurname+" it is great to see you again.";
        }else{
            return "Username or password incorrect, please try again.";
        }
    }
}
