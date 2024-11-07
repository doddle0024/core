import java.util.Scanner;
public class FCFS2{
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
System.out.print("Enter the number of processes: ");
int n = sc.nextInt();
int[] burstTime = new int[n];
int[] waitingTime = new int[n];
int[] turnaroundTime = new int[n];
for (int i = 0; i < n; i++) {
System.out.print("Enter burst time for process " + (i + 1) + ": ");
burstTime[i] = sc.nextInt();
}
// Calculate waiting time
waitingTime[0] = 0;
for (int i = 1; i < n; i++) {
waitingTime[i] = waitingTime[i - 1] + burstTime[i - 1];
}
// Calculate turnaround time
for (int i = 0; i < n; i++) {
turnaroundTime[i] = waitingTime[i] + burstTime[i];
}
// Display results
System.out.println("\nProcess\tBurst Time\tWaiting Time\tTurnaround Time");
for (int i = 0; i < n; i++) {
System.out.println((i + 1) + "\t" + burstTime[i] + "\t\t" + waitingTime[i] + "\t\t" +
turnaroundTime[i]);
}
sc.close();
}
}

