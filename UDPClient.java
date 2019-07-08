package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;


public class UDPClient {
    public static void main(String[] args) throws SocketException, UnknownHostException, IOException
    {
        DatagramSocket s = new DatagramSocket(9998);
        int i =2;
        byte[] b = String.valueOf(i).getBytes();
        InetAddress ip = InetAddress.getLocalHost();
        DatagramPacket dg = new DatagramPacket(b, b.length, ip, 9999);
        s.send(dg);
        
        byte[] b1 = new byte[1024];
        DatagramPacket dgp = new DatagramPacket(b1, b1.length);
        s.receive(dgp);
        String str = new String(dgp.getData(),0,dgp.getLength());
        System.out.println("S :"+str);
        
    }
}
