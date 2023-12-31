//import java.util.*;
//
//class Leaky {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int bucketSize, outputRate, remainingCapacity, n, sent, accumulated;
//        System.out.print("Enter the size of the bucket: ");
//        bucketSize = in.nextInt();
//        System.out.print("Enter the output rate: ");
//        outputRate = in.nextInt();
//        System.out.print("Enter the number of packets: ");
//        n = in.nextInt();
//        int[] packets = new int[n];
//
//        remainingCapacity = 0;
//
//        List<String[]> tableRows = new ArrayList<>();
//
//        for (int i = 0; i < n; i++) {
//            System.out.print("Enter the size of packet " + (i + 1) + ": ");
//            packets[i] = in.nextInt();
//
//            accumulated = remainingCapacity;
//
//            // Check if the packet can be accommodated in the current bucket capacity
//            if (packets[i] <= bucketSize - accumulated) {
//                remainingCapacity += packets[i];
//                sent = Math.min(remainingCapacity, outputRate);
//                remainingCapacity -= sent;
//
//                String[] row = {Integer.toString(i + 1), Integer.toString(packets[i]),
//                        Integer.toString(accumulated), Integer.toString(sent),
//                        Integer.toString(remainingCapacity)};
//                tableRows.add(row);
//            } else {
//                String[] row = {Integer.toString(i + 1), Integer.toString(packets[i]),
//                        "Rejected", "-", "-"};
//                tableRows.add(row);
//            }
//        }
//
//        // Print the table header
//        System.out.println("Packet | Size | Accumulated | Sent | Remaining");
//
//        // Print the table rows
//        for (String[] row : tableRows) {
//            System.out.printf("%-7s|%-6s|%-13s|%-5s|%-10s%n", row);
//        }
//    }
//}
import java.util.Scanner;

public class Leaky {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int buckcap, buckrem = 0, rate, sent, recv = 0;
        System.out.print("Enter the number of packets :");
        int n = sc.nextInt();
        System.out.print("Enter the rate :");
        rate = sc.nextInt();
        System.out.print("Enter the bucket capacity :");
        buckcap = sc.nextInt();
        System.out.println("Enter the packets");
        int a[] = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        System.out.println("C\tP\tA\tS\tR");
        for (int i = 0; i < n; i++) {
            if (a[i] != 0) {
                if (buckrem + a[i] > buckcap) {
                    recv = -1;
                } else {
                    recv = a[i];
                    buckrem += a[i];
                }
            }
            if (buckrem != 0) {
                if (buckrem < rate) {
                    sent = buckrem;
                    buckrem = 0;
                } else {
                    sent = rate;
                    buckrem -= rate;
                }
            } else sent = 0;
            if (recv == -1)
                System.out.println((i + 1) + "\t" + a[i] + "\t" + "D\t" + sent + "\t" + buckrem);
            else
                System.out.println((i + 1) + "\t" + a[i] + "\t" + a[i] + "\t" + sent + "\t" + buckrem);
        }
    }
}