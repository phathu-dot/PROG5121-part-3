package myassignment1;

public class MessageReport {

    public static void displaySenderRecipient() {

        for(Message msg :
            Message.storedMessages) {
                System.out.println("Sender: User");
                System.out.println( "Recipient: " + msg.getRecipient());
                System.out.println();
        }
    }

    public static void displayLongestMessage() {

        Message longest = null;

        for(Message msg :Message.storedMessages) {
            
            if(longest == null|| msg.getMessage().length() > longest.getMessage().length()) {
                longest = msg;
            }
        }

        if(longest != null) {
            System.out.println( "Longest Message:");
            System.out.println(longest.getMessage());
        }
    }

    public static void searchMessageID( String id) {

        for(Message msg : Message.storedMessages) {

            if(msg.getMessageID().equals(id)) {

                System.out.println("Recipient: " + msg.getRecipient());
                System.out.println("Message: " + msg.getMessage());
                return;
            }
        }

        System.out.println("Message not found.");
    }

    public static void searchRecipient(String recipient) {

        boolean found = false;

        for(Message msg : Message.storedMessages) {

            if(msg.getRecipient().equals(recipient)) {

                System.out.println( msg.getMessage());

                found = true;
            }
        }

        if(!found) {
            System.out.println("No messages found.");
        }
    }

    public static void deleteMessage(
            String hash) {

        for(int i = 0; i < Message.storedMessages.size(); i++) {

            if(Message.storedMessages.get(i).getMessageHash().equals(hash)) {

                Message.storedMessages.remove(i);
                System.out.println("Message deleted.");
                return;
            }
        }

        System.out.println("Hash not found.");
    }

    public static void displayReport() {

        System.out.println("\n===== MESSAGE REPORT =====");

        for(Message msg : Message.storedMessages) {
            System.out.println( "\nMessage ID: " + msg.getMessageID());
            System.out.println( "Hash: " + msg.getMessageHash());
            System.out.println( "Recipient: " + msg.getRecipient());
            System.out.println("Message: " + msg.getMessage());
        }
    }
}