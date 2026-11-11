/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package myassignment1;

import java.util.Scanner;

/**
 *
 * @author Student
 */
public class MyAssignment1{

public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("========== REGISTRATION ==========");

        System.out.print("Enter First Name: ");
        String firstName = input.nextLine();

        System.out.print("Enter Last Name: ");
        String lastName = input.nextLine();

        System.out.print("Enter Username: ");
        String username = input.nextLine();

        System.out.print("Enter Password: ");
        String password = input.nextLine();

        System.out.print("Enter Phone Number (+27): ");
        String phone = input.nextLine();

        login login = new login();


        boolean validUsername = login.checkUserName(username);
        boolean validPassword = login.checkPasswordComplexity(password);
        boolean validPhone = login.checkCellPhoneNumber(phone);


        if (validUsername) {
            System.out.println("Username successfully captured.");
        } else {
            System.out.println("Username incorrectly formatted.");
        }


        if (validPassword) {
            System.out.println("Password successfully captured.");
        } else {
            System.out.println("Password incorrectly formatted.");
        }

        if (validPhone) {
            System.out.println("Phone number successfully captured.");
        } else {
            System.out.println("Phone number incorrectly formatted.");
        }


        if (validUsername && validPassword && validPhone) {
            System.out.println("Registration successful.");
            System.out.println("\n========== LOGIN ==========");
            System.out.print("Enter Username: ");
            String enteredUsername = input.nextLine();
            System.out.print("Enter Password: ");
            String enteredPassword = input.nextLine();
            
            boolean loginStatus = login.loginUser(username, password,enteredUsername,enteredPassword);

            System.out.println( login.returnLoginStatus( loginStatus,firstName, lastName) );


            if (loginStatus) {
                System.out.println("\nWelcome to QuickChat");
                System.out.println("""   
                        Choose an option:
                        
                        1) Send Messages
                        2) Show recently sent messages 
                        3) Quit
                        """);

                System.out.print("Select option: ");
                int option = Integer.parseInt(input.nextLine());

                switch (option) {

                    case 1:
                        System.out.print( "How many messages would you like to send? ");

                        int total = Integer.parseInt(input.nextLine());

                        for (int i = 1; i <= total; i++) {

                            System.out.println("\n========== MESSAGE "+ i+ " ==========" );
                            System.out.print("Enter recipient number: ");
                            String recipient =input.nextLine();
                            System.out.print( "Enter message: ");
                            String messageText =input.nextLine();


                            if (messageText.length() > 250) {
                                System.out.println( "Please enter a message of less than 250 characters.");
                                i--;
                                continue;
                            }
                            Message msg = new Message( i,recipient, messageText);

                            if (msg.checkMessageID()) {
                                System.out.println( "Message ID successfully created.");
                            }
                            System.out.println( msg.checkRecipientCell());
                            System.out.println( "Message Hash: "  + msg.createMessageHash() );
                            System.out.println( msg.sentMessage() );
                            System.out.println( msg.printMessages() );
                        }
                        System.out.println( "\nTotal messages sent: "+ Message.returnTotalMessages());
                        
                        break;

                    case 2:

                     System.out.println("""

                                        STORED MESSAGE MENU

                                        a) Display the sender and recipient of all stored messages.
                                        b) Display the longest stored message.
                                        c) Search for a message ID and display the corresponding recipient and message.
                                        d) Search for all the messages stored for a particular recipient.
                                        e) Delete a message using the message hash.
                                        f) Display a report that lists the full details of all the stored messages.
                                        """);

                        System.out.print("Select option: ");

                        String reportChoice = input.nextLine().toLowerCase();

                                switch(reportChoice) {

                                    case "a":
                                        MessageReport.displaySenderRecipient();
                                        break;

                                    case "b":
                                        MessageReport.displayLongestMessage();
                                        break;

                                    case "c":
                                        System.out.print("Enter Message ID: ");
                                        String id = input.nextLine();
                                        MessageReport.searchMessageID(id);
                                        break;

                                    case "d":
                                        System.out.print("Enter Recipient: ");
                                        String recipientSearch =input.nextLine();
                                        MessageReport.searchRecipient(recipientSearch);
                                        break;

                                    case "e":
                                        System.out.print( "Enter Message Hash: ");
                                        String hash =input.nextLine();
                                        MessageReport.deleteMessage(hash);
                                        break;

                                    case "f":
                                        MessageReport.displayReport();
                                        break;

                                    default:
                                        System.out.println("Invalid selection.");
                                }

                        break;

                    case 3:
                        System.out.println( "Goodbye.");
                        System.exit(0);
                        break;

                    default:

                        System.out.println("Invalid option selected.");
                }
            }

        } else {

            System.out.println( "Registration failed." );
        }

        input.close();
    }
}
