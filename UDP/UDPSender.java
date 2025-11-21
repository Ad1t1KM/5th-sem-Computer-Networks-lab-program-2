package UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPSender {
    public static void main(String[] args) throws Exception{
        System.out.println("Sender");
        try(
            DatagramSocket ds = new DatagramSocket(); 
            Scanner sc = new Scanner(System.in);
        ){
            System.out.println("Enter the message (type 'exit' to quit): ");
            InetAddress ip = InetAddress.getByName("127.0.0.1");
            while(true) {
                String msg = sc.nextLine();
                if(msg.equalsIgnoreCase("exit")) {
                    System.out.println("Exiting");
                    break;
                }
                DatagramPacket dp = new DatagramPacket(msg.getBytes(), msg.length(),ip,8000);
                ds.send(dp);
            }
        }
    }
}
