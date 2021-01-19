

//LOCAL HOST
package server;

import java.io.*;
import java.net.*;


public class Server {

    //sets up variables for the input/output stream and socket
    private Socket socket = null;
    private ServerSocket server = null;
    private DataInputStream input = null;
    private DataOutputStream output = null;
    
    //constructor with port
    public Server(int port){
        try{
            server = new ServerSocket(port);
            System.out.println("Server Started");
            System.out.println("Waiting for client");
            //connects user
            socket = server.accept();
            System.out.println("Client is connected");
            
            //takes input from client
            input = new DataInputStream(
                    new BufferedInputStream(socket.getInputStream()));
            
            String line ="";
            
            while(!line.equals("Over")){
            try{
                line = input.readUTF();
                System.out.println(line);
            }
            catch(Exception e){
            System.out.println(e);
            }
        }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
    public static void main(String[] args) {
        Server server = new Server(5000);
    }
    
}
