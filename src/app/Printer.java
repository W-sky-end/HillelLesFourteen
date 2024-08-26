package app;

import java.util.Scanner;

public interface Printer {

    void print(MessagePrint.Message message);
}

class MessagePrint implements Printer {
    public static class Message {
        private String text;
        private String sender;

        public Message(String text, String sender) {
            this.text = text;
            this.sender = sender;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getSender() {
            return sender;
        }

        public void setSender(String sender) {
            this.sender = sender;
        }

}
    public void print(Message message) {
        if ((message.getText() == null || message.getText().isEmpty()) &&
                (message.getSender() == null || message.getSender().isEmpty())) {
            Printer anonymous = new Printer() {
                @Override
                public void print(Message message) {
                    System.out.println("Empty message from anonymous.");
                }

            };
            anonymous.print(message);
        } else if (message.getSender() == null || message.getSender().isEmpty()) {
            System.out.println("No sender : " + message.getText());
        } else if (message.getText() == null || message.getText().isEmpty()) {
            System.out.println(message.getSender() +" No message.");
        } else {
                System.out.println("Sender : " + message.getSender() + " Message : " + message.getText());
            }
        }


        public static void main (String[]args){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter your message : ");
            String text = scanner.nextLine();
            System.out.println("Enter your name : ");
            String sender = scanner.nextLine();

            Message message = new Message(text, sender);
            MessagePrint print = new MessagePrint();
            print.print(message);


        }
    }


