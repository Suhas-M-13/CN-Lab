//import java.util.*;
//
//class Token {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int bucketSize, outputRate, n, tokens, remainingTokens, sent, accumulated;
//        System.out.print("Enter the size of the bucket: ");
//        bucketSize = in.nextInt();
//        System.out.print("Enter the output rate: ");
//        outputRate = in.nextInt();
//        System.out.print("Enter the number of packets: ");
//        n = in.nextInt();
//        int[] packets = new int[n];
//
//        remainingTokens = bucketSize;
//
//        List<String[]> tableRows = new ArrayList<>();
//
//        for (int i = 0; i < n; i++) {
//            System.out.print("Enter the size of packet " + (i + 1) + ": ");
//            packets[i] = in.nextInt();
//
//            accumulated = bucketSize - remainingTokens;
//
//            // Check if the packet can be accommodated in the current token bucket
//            if (packets[i] <= remainingTokens) {
//                remainingTokens -= packets[i];
//                sent = Math.min(remainingTokens, outputRate);
//                remainingTokens += sent;
//
//                String[] row = {Integer.toString(i + 1), Integer.toString(packets[i]),
//                        Integer.toString(accumulated), Integer.toString(sent),
//                        Integer.toString(remainingTokens)};
//                tableRows.add(row);
//            } else {
//                String[] row = {Integer.toString(i + 1), Integer.toString(packets[i]),
//                        "Rejected", "-", "-"};
//                tableRows.add(row);
//            }
//        }
//
//        // Print the table header
//        System.out.println("Packet | Size | Sent | Remaining Tokens");
//
//        // Print the table rows
//        for (String[] row : tableRows) {
//            System.out.printf("%-7s|%-6s|%-5s|%-18s%n", row);
//        }
//    }
//}
import java.util.Scanner;

public class Token {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int token = 0, rate = 5, capacity = 100;
        System.out.print("Enter the number of packets :");
        int n = sc.nextInt();
        System.out.println("Enter the packets");
        int a[] = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        for (int i = 0; i < n; i++) {
            token = Math.min(token + rate, capacity);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }

            if (token > a[i]) {
                token -= a[i];
                System.out.println("Request granted remaining tokes are " + token);
            } else {
                System.out.println("Request denied");
            }
        }
    }
}