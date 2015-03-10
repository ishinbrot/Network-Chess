package Implementation;

import java.io.*;
import java.util.*;
import java.net.*;

public class  NetworkChess extends Thread
{
    private final static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    int port=10000;                             // port to send/receive datagrams on
    String remoteIPaddress= ("127.0.0.1");      // IP to send datagrams
    DatagramSocket ds;// = new DatagramSocket(port);
    DatagramSocket theSocket;// = new DatagramSocket();
    byte[] buffer = new byte[65507];                       // array to put datagrams in
    DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
    // constructor, parameter is command line parameters
    public NetworkChess(String IPman) throws Exception
    {
        // get remote IP address and port from command line parameters
        remoteIPaddress =  IPman;           // get IPaddress
        //if (args.length > 1)    port = Integer.parseInt(args[1]);        // get port number
        //System.out.println("chat program: IP address " + InetAddress.getLocalHost().toString() + " port " + port );
        ds = new DatagramSocket(port);
        theSocket = new DatagramSocket();

    }

    // thread run method, receives datagram and display contents as a string
    public void run()
    {
        try
        {
            // open DatagramSocket to receive
            //DatagramSocket ds = new DatagramSocket(port);
            // loop forever reading datagrams from the DatagramSocket
            while (true)
            {
                byte[] buffer = new byte[65507];                       // array to put datagrams in
                DatagramPacket dp = new DatagramPacket(buffer, buffer.length); // DatagramPacket to hold the datagram
                ds.receive(dp);                                     // wait for next datagram
                String s = new String(dp.getData(),0,dp.getLength());        // get contenets as a String
                System.out.println("UDP datagram length " + s.length()+ "  from IP " + dp.getAddress() + " received: " + s );
            }
        }
        catch (SocketException se) {System.err.println("chat error " + se); }
        catch (IOException se) {System.err.println("chat error " + se);}
        System.exit(1);                                                       // exit on error
    }

    //function sends and recives moves from game 
    public String sendAndWait(String s)
    {
        String thing="";//string to hold return value
        // loop waiting for keyboard input, send datagram to remote IP

        
    //sending functionality 
        try
        {
           //  String s = in.readLine();                       // read a String
             System.out.println("Sending to " + remoteIPaddress + " socket " + port + " data: " + s);
            byte[] data = s.getBytes();                                     // convert to byte array
            // DatagramSocket theSocket = new DatagramSocket();                // create datagram socket and the datagram
            DatagramPacket   theOutput = new DatagramPacket(data, data.length, InetAddress.getByName(remoteIPaddress), port);
            theSocket.send(theOutput);                                      // and send the datagram
        }
        catch (Exception e) {System.out.println("Eroor sending datagram " + e);}

    //reciving functionality 
        try
        {
            // open DatagramSocket to receive
            //DatagramSocket ds = new DatagramSocket(port);
            // loop forever reading datagrams from the DatagramSocket

            //byte[] buffer = new byte[65507];                       // array to put datagrams in
            //DatagramPacket dp = new DatagramPacket(buffer, buffer.length); // DatagramPacket to hold the datagram
            ds.receive(dp);                                     // wait for next datagram
            thing = new String(dp.getData(),0,dp.getLength());        // get contenets as a String
            //System.out.println("UDP datagram length " + s.length()+ "  from IP " + dp.getAddress() + " received: " + s );
            dp.setLength(buffer.length);
        }
        catch (SocketException se) {System.err.println("chat error " + se); }
        catch (IOException se) {System.err.println("chat error " + se);}
        //System.exit(1);
        if(thing == "TERMINATE")
        {
            System.exit(1);
        }
        return thing;
    }
    
    
    //function for when game starts to put black into recive mode 
    String blackfirstSend()
    {
        return sendAndWait("black");//sends black and waits for whites first move 
        
    }
    
    
    
    

}
