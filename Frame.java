import java.util.*;

public class Frame {
    static class frame {
        int seq;
        String data;

        frame(int a, String b) {
            seq = a;
            data = b;
        }
    }

    public static void printFrame(frame[] f) {
        for (int i = 0; i < f.length; i++) {
            System.out.println("Frame-" + f[i].seq + " | " + "\tData : " + f[i].data);
        }
    }

    public static void ssort(frame[] f, int n) {
        frame t;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (f[i].seq > f[j].seq) {
                    t = f[i];
                    f[i] = f[j];
                    f[j] = t;
                }
            }
        }
    }

    public static void main(String[] args) {
        int n;
        Random r = new Random();
        System.out.print("Enter the number of frames : ");
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        frame[] f = new frame[n];
        System.out.println("Enter the details for each frame :");
        for (int i = 0; i < n; i++) {
            int seq = r.nextInt(100);
            System.out.print("Frame-" + seq + "\tData : ");
            String data = in.next();
            f[i] = new frame(seq, data);
        }

        System.out.println("Frames before sorting : ");
        printFrame(f);
        System.out.println("Frames after sorting : ");
        ssort(f, n);
        printFrame(f);
    }
}