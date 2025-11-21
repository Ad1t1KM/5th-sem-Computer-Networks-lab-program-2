package UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPReceiver {
    public static void main(String[] args) throws Exception{
        DatagramSocket ds = new DatagramSocket(8000);
        byte[] buffer = new byte[1024];
        System.out.println("Receiver ready:");
        while(true) {
            DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
            ds.receive(dp);
            String msg = new String(dp.getData(),0,dp.getLength());
            System.out.println("Received: "+msg);
            if(msg.equalsIgnoreCase(("exit"))) {
                System.out.println("Receiver exiting");
                break;
            }
        }
        ds.close();
    }
}
