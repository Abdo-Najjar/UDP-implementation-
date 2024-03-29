package UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServerSide {
    public static void main(String[] args)throws Exception
    {
        DatagramSocket ds = new DatagramSocket(9999);
        byte[] b1 = new byte[1024];
        DatagramPacket dp = new DatagramPacket(b1, b1.length);
        ds.receive(dp);
        String str = new String(dp.getData(),0,dp.getLength());
        int num = Integer.parseInt(str);
        System.out.println("C :"+num);
        
        int result = num*num;
        byte[] b2 = String.valueOf(result).getBytes();
        InetAddress ip = InetAddress.getLocalHost();
        DatagramPacket dp1 = new DatagramPacket(b2, b2.length,ip ,dp.getPort());
        ds.send(dp1);
    }
    
}
