package filetransfer_java;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class client {

  public final static int port = 55555;      //port at which the client connects
  public final static String ip = "127.0.0.1";  // localhost
  public final static String file_recieved = "C:\\Users\\fiqbal.bscs12seecs\\Documents\\filetransfer_java\\ds.txt";  // you may change this, I give a
                                                        
  public final static int FILE_SIZE = 6022386; // file size should be greater than the file to be downloaded
                                              
  
  public static void main (String [] args ) throws IOException {
    int bytesRead;
    int current = 0;
    FileOutputStream fos = null;
    BufferedOutputStream bos = null;
    Socket client_socket = null;
    try {
    	client_socket = new Socket(ip, port);
        System.out.println("Connecting...");

      // receive file
      byte [] mybytearray  = new byte [FILE_SIZE];
      InputStream is = client_socket.getInputStream();
      fos = new FileOutputStream(file_recieved);
      bos = new BufferedOutputStream(fos);
      bytesRead = is.read(mybytearray,0,mybytearray.length);
      current = bytesRead;			//size of file to be read

      do {
         bytesRead =is.read(mybytearray, current, (mybytearray.length-current));
         if(bytesRead >= 0) current += bytesRead;
      } while(bytesRead > -1);

      bos.write(mybytearray, 0 , current);
      bos.flush();
      System.out.println("File " + file_recieved
          + " downloaded (" + current + " bytes read)");
    }
    finally {
      if (fos != null) fos.close();
      if (bos != null) bos.close();
      if (client_socket != null) client_socket.close();
    }
  }

}
