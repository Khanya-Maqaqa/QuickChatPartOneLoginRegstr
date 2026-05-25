

package com.mycompany.partonepoe;

import java.util.Scanner;

/**
 *
 * @author kvmaq - Khanya Maqaqa
 */
public class PartOnePoe {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        /*
        ------------------------------------------------------------
        User Registration
        -------------------------------------------------------------
        */
        System.out.println("===============================");
        System.out.println("  CREATE ACCOUNT-USER DETAILS");
        System.out.println("===============================");
        
        System.out.println("Enter Your Name");
        String name = s.nextLine();
        
        System.out.println("Enter Your Surname");
        String surname = s.nextLine();
        
        System.out.println("Enter Your a Username");
        String username = s.nextLine();
        
        System.out.println("Enter Your a Password");
        String password = s.nextLine();
        
        System.out.println("Enter Your Phone Number - USE +27********* Format");
        String phonenumber = s.nextLine();
       
        System.out.println("***************************************");
        System.out.println("QUICK CHAT - CONNETING WITH THE WORLD");
        System.out.println("***************************************");
        
        //Create Login object with all registration details
        Login logObj = new Login(username, password, phonenumber, name, surname);
        
            //User Attempt registration - this also prints individual validation messages
                String registrationResult = logObj.registerUser(username, password, phonenumber);
                System.out.println(registrationResult);
                
                //Only proceed to login if registration succeeded
                if(!registrationResult.equals("User successfully registered.")){
                    System.out.println("Please restart the application and enter valid details. ");
                    s.close();
                    return;
                }
                /*
                ----------------------------------------
                LOGIN
                ------------------------------------------
                */
                System.out.println("\n======= LOGIN =======");
                
                System.out.println("Enter Your Username: ");
                username = s.nextLine();
                
                System.out.println("Enter Your Password: ");
                password = s.nextLine();
                
                //Display login result
                 System.out.println(logObj.loginUser(username, password));
               
                s.close();
                
                
           
              
            
                
        }
    }

