package filetransfer_java;


import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class server {

  public final static int port = 55555;  //port at which the server connects
  public final static String sending_file = "C:\\Users\\fiqbal.bscs12seecs\\Documents\\filetransfer_java\\blee.txt";  // you may change this

  public static void main (String [] args ) throws IOException {
    FileInputStream fis = null;
    BufferedInputStream bis = null;
    OutputStream os = null;
    ServerSocket server_socket = null;
    Socket sock = null;
    try {
      server_socket = new ServerSocket(port);
      while (true) {
        System.out.println("Waiting...");
        try {
          sock = server_socket.accept();
          System.out.println("Accepted connection : " + sock);		//connection established
         
          File myFile = new File (sending_file);
          byte [] mybytearray  = new byte [(int)myFile.length()];
          fis = new FileInputStream(myFile);
          bis = new BufferedInputStream(fis);
          bis.read(mybytearray,0,mybytearray.length);
          os = sock.getOutputStream();
          System.out.println("Sending " + sending_file + "(" + mybytearray.length + " bytes)");
          os.write(mybytearray,0,mybytearray.length);
          os.flush();
          System.out.println("Done.");
        }
        finally {
          if (bis != null) bis.close();
          if (os != null) os.close();
          if (sock!=null) sock.close();
        }
      }
    }
    finally {
      if (server_socket != null) server_socket.close();
    }
  }
}
