import java.io.*;

class OptimalPageReplacement {
    public static void main(String[] args) throws IOException {
        BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));

        // Input number of frames
        System.out.print("Enter the number of frames: ");
        int frameCount = Integer.parseInt(obj.readLine());
        int[] frame = new int[frameCount];
        for (int i = 0; i < frameCount; i++) frame[i] = -1; // Initialize frames to empty

        // Input number of pages
        System.out.print("Enter the number of pages: ");
        int pageCount = Integer.parseInt(obj.readLine());
        int[] pages = new int[pageCount];

        System.out.println("Enter the page numbers: ");
        for (int i = 0; i < pageCount; i++) pages[i] = Integer.parseInt(obj.readLine());

        int pageFaults = 0, pageHits = 0;

        // Process each page request
        for (int i = 0; i < pageCount; i++) {
            int page = pages[i];
            boolean hit = false;

            // Check for a page hit
            for (int j = 0; j < frameCount; j++) {
                if (frame[j] == page) {
                    hit = true;
                    pageHits++;
                    break;
                }
            }

            if (!hit) { // If page fault
                int replaceIndex = findReplacementIndex(frame, pages, i, pageCount);
                frame[replaceIndex] = page; // Replace with the new page
                pageFaults++;
            }

            // Display current frame state
            System.out.print("Frame: ");
            for (int f : frame) System.out.print(f + "\t");
            System.out.println();
        }

        System.out.println("Total page faults: " + pageFaults);
        System.out.println("Total page hits: " + pageHits);
    }

    // Finds the optimal replacement index
    private static int findReplacementIndex(int[] frame, int[] pages, int currentIndex, int pageCount) {
        int replaceIndex = -1, farthest = currentIndex;

        for (int i = 0; i < frame.length; i++) {
            int j;
            for (j = currentIndex + 1; j < pageCount; j++) {
                if (frame[i] == pages[j]) break;
            }

            if (j > farthest) {
                farthest = j;
                replaceIndex = i;
            }
            if (j == pageCount) return i; // Page not found in future, replace immediately
        }
        return replaceIndex;
    }
}
