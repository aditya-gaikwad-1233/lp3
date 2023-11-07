#Write a program to calculate Fibonacci numbers and find its step count.
import java.util.Scanner;

public class FibonacciWithStepCount {
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
System.out.print(&quot;Enter the number of Fibonacci numbers to calculate: &quot;);
int n = scanner.nextInt();

long[] fibonacciSeries = new long[n];
long stepCount = 0;

if (n &gt;= 1) {
fibonacciSeries[0] = 0;
stepCount++;
}
if (n &gt;= 2) {
fibonacciSeries[1] = 1;
stepCount++;
}

for (int i = 2; i &lt; n; i++) {
fibonacciSeries[i] = fibonacciSeries[i - 1] + fibonacciSeries[i - 2];
stepCount += 3; // Each iteration includes 3 steps: addition, access previous two values, and
assignment.
}

System.out.println(&quot;Fibonacci Series:&quot;);
for (int i = 0; i &lt; n; i++) {
System.out.print(fibonacciSeries[i] + &quot; &quot;);
}

System.out.println(&quot;\nTotal steps taken to calculate the Fibonacci series: &quot; + stepCount);
}
}
