import java.util.*;

public class CRC {
    static int poly = 0x1021;

    static String crc(String data) {
        int crc = 0xffff;
        for (char c : data.toCharArray()) {
            int ascii = (int) c;
            crc ^= (ascii << 8) & 0xffff;
            for (int i = 0; i < 8; i++) {
                if ((crc & 0x8000) != 0)
                    crc = (crc << 1) ^ poly;
                else crc = crc << 1;
                crc &= 0xffff;
            }
        }
        return Integer.toString(crc);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the msg :");
        String input = sc.nextLine();
        String crc = crc(input);
        System.out.println(input + crc);
        System.out.print("Enter output :");
        String output = sc.nextLine().trim();
        String outmsg = output.substring(0, output.length() - 5);
        String outcrc = output.substring(output.length() - 5);
        String result = crc(outmsg);
        if (result.equals(outcrc)) System.out.println(outmsg);
        else System.out.println("no");
    }

}

//import java.util.Scanner;
//
//public class CRC {
//    static String calCRC(String data, String poly, boolean error) {
//        StringBuffer rem = new StringBuffer(data);
//        if (!error)
//            for (int i = 0; i < poly.length() - 1; i++)
//                rem.append("0");
//        for (int i = 0; i < rem.length() - poly.length() + 1; i++)
//            if (rem.charAt(i) == '1')
//                for (int j = 0; j < poly.length(); j++)
//                    rem.setCharAt(i + j, (rem.charAt(i + j) == poly.charAt(j)) ? '0' : '1');
//        return rem.substring(rem.length() - poly.length() + 1);
//    }
//
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        System.out.print("Enter the data to be sent in bits : ");
//        String data = in.next();
//        String poly = "10000100010001010";
//        String encoded = data + calCRC(data, poly, false);
//        System.out.println("Encoded data : " + encoded);
//        System.out.print("Enter the data that was received : ");
//        String received = in.next();
//        String recString = calCRC(received, poly, true);
//        if (Integer.parseInt(recString, 2) == 0)
//            System.out.println("Data is correct.");
//        else
//            System.out.println("Data is incorrect.");
//    }
//}