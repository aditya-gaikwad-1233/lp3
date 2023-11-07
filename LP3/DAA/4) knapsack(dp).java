#Write a program to solve a 0-1 Knapsack problem using dynamic programming strategy.
import java.util.Scanner;

public class Zero_One_Knapsack
{
public void solve(int[] wt, int[] val, int W, int N)
{
int NEGATIVE_INFINITY = Integer.MIN_VALUE;
int[][] m = new int[N + 1][W + 1];
int[][] sol = new int[N + 1][W + 1];
for (int i = 1; i &lt;= N; i++)
{
for (int j = 0; j &lt;= W; j++)
{
int m1 = m[i - 1][j];
int m2 = NEGATIVE_INFINITY;
if (j &gt;= wt[i])
m2 = m[i - 1][j - wt[i]] + val[i];
m[i][j] = Math.max(m1, m2);
sol[i][j] = m2 &gt; m1 ? 1 : 0;
}
}
int[] selected = new int[N + 1];
for (int n = N, w = W; n &gt; 0; n--)
{
if (sol[n][w] != 0)

{
selected[n] = 1;
w = w - wt[n];
}
else
selected[n] = 0;
}
System.out.print(&quot;\nItems with weight &quot;);
for (int i = 1; i &lt; N + 1; i++)
if (selected[i] == 1)
System.out.print(val[i] +&quot; &quot;);
System.out.println(&quot;are selected by knapsack algorithm.&quot;);
}
public static void main (String[] args)
{
Scanner scan = new Scanner(System.in);
Zero_One_Knapsack ks = new Zero_One_Knapsack();

System.out.println(&quot;Enter number of elements &quot;);
int n = scan.nextInt();

int[] wt = new int[n + 1];
int[] val = new int[n + 1];

System.out.println(&quot;Enter weight for &quot;+ n +&quot; elements&quot;);
for (int i = 1; i &lt;= n; i++)
wt[i] = scan.nextInt();

System.out.println(&quot;Enter value for &quot;+ n +&quot; elements&quot;);
for (int i = 1; i &lt;= n; i++)
val[i] = scan.nextInt();

System.out.println(&quot;Enter knapsack weight &quot;);
int W = scan.nextInt();

ks.solve(wt, val, W, n);
scan.close();
}
}
