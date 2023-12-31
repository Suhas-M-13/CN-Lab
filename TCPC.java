import java.net.*;
import java.util.Scanner;
import java.io.*;

public class TCPC {
    public static void main(String args[]) throws Exception {
        Socket sock = new Socket("127.0.0.1", 4000);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Filename : ");
        String fname = sc.next();
        InputStream istream = sock.getInputStream();
        sc = new Scanner(istream);
        OutputStream oStream = sock.getOutputStream();
        PrintWriter pWrite = new PrintWriter(oStream, true);
        pWrite.println(fname);
        while (sc.hasNextLine()) {
            System.out.println(sc.nextLine());
        }
    }
}

