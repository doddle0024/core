import java.io.*;

public class FIFO {
    public static void main(String[] args) throws IOException {
        BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter number of frames: ");
        int f = Integer.parseInt(obj.readLine());
        int[] frame = new int[f];
        for (int i = 0; i < f; i++) frame[i] = -1;  // Initialize frames with -1

        System.out.print("Enter number of pages: ");
        int n = Integer.parseInt(obj.readLine());
        int[] pages = new int[n];
        System.out.println("Enter page numbers: ");
        for (int i = 0; i < n; i++) pages[i] = Integer.parseInt(obj.readLine());

        int pgf = 0, pt = 0;

        for (int page : pages) {
            boolean hit = false;

            // Check for a hit
            for (int j = 0; j < f; j++) {
                if (frame[j] == page) {
                    hit = true;
                    break;
                }
            }

            // Page fault handling
            if (!hit) {
                frame[pt] = page;
                pt = (pt + 1) % f;  // Move pointer in a circular fashion
                pgf++;
            }

            // Display the frame status with -1 in empty positions
            System.out.print("Frame: ");
            for (int j = 0; j < f; j++) System.out.print(frame[j] + "   ");
            System.out.println();
        }

        int phit = n - pgf;  // Page hits are total pages minus page faults
        System.out.println("Page fault: " + pgf);
        System.out.println("Page hit: " + phit);
    }
}
