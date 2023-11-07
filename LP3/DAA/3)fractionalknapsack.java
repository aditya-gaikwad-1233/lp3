#Write a program to solve a fractional Knapsack problem using a greedy method.
import java.io.IOException;
import java.util.Scanner;

class Fractional_Knapsack
{
public static void main(String args[]) throws IOException
{
int i,j=0,max_qty,m,n;
float sum=0,max;
Scanner sc = new Scanner(System.in);
int array[][]=new int[2][20];
System.out.println(&quot;Enter no of items&quot;);
n=sc.nextInt();

System.out.println(&quot;Enter the weights of each items&quot;);
for(i=0;i&lt;n;i++)
array[0][i]=sc.nextInt();

System.out.println(&quot;Enter the values of each items&quot;);
for(i=0;i&lt;n;i++)
array[1][i]=sc.nextInt();

System.out.println(&quot;Enter maximum volume of knapsack :&quot;);
max_qty=sc.nextInt();

m=max_qty;
while(m&gt;=0)
{
max=0;
for(i=0;i&lt;n;i++)
{
if(((float)array[1][i])/((float)array[0][i])&gt;max)
{
max=((float)array[1][i])/((float)array[0][i]);
j=i;
}
}
if(array[0][j]&gt;m)
{
System.out.println(&quot;Quantity of item number: &quot; + (j+1) + &quot; added is &quot; +m);
sum+=m*max;
m=-1;
}
else
{
System.out.println(&quot;Quantity of item number: &quot; + (j+1) + &quot; added is &quot; + array[0][j]);
m-=array[0][j];
sum+=(float)array[1][j];
array[1][j]=0;
}
}
System.out.println(&quot;The total profit is &quot; + sum);

sc.close();
}
}
