#Write a program to implement Huffman Encoding using a greedy strategy.
import java.util.*;
public class job
{
public static void main(String args[])
{
Scanner sc=new Scanner(System.in);
System.out.println(&quot;Enter the number of Jobs&quot;);
int n=sc.nextInt();
String a[]=new String[n];
int b[]=new int[n];
int c[]=new int[n];
for(int i=0;i&lt;n;i++)
{
System.out.println(&quot;Enter the Jobs&quot;);
a[i]=sc.next();
System.out.println(&quot;Enter the Profit&quot;);
b[i]=sc.nextInt();
System.out.println(&quot;Enter the DeadLine&quot;);
c[i]=sc.nextInt();
}
System.out.println(&quot;--Arranged Order--&quot;);
System.out.print(&quot;Jobs: &quot;);
for(int i=0;i&lt;n;i++)
{
System.out.print(a[i]+&quot; &quot;);
}
System.out.println();
System.out.print(&quot;Profit: &quot;);
for(int i=0;i&lt;n;i++)
{
System.out.print(b[i]+&quot; &quot;);
}
System.out.println();
System.out.print(&quot;DeadLine:&quot;);
for(int i=0;i&lt;n;i++)
{
System.out.print(c[i]+&quot; &quot;);
}
for(int i=0;i&lt;n-1;i++)
{
for(int j=i+1;j&lt;n;j++)
{
if(b[i]&lt;b[j])
{
int temp=b[i];
b[i]=b[j];
b[j]=temp;
temp=c[i];
c[i]=c[j];
c[j]=temp;
String temp1=a[i];
a[i]=a[j];
a[j]=temp1;
}

}
}
System.out.println();
System.out.println(&quot;--Sorted Order--&quot;);
System.out.print(&quot;Jobs: &quot;);
for(int i=0;i&lt;n;i++)
{
System.out.print(a[i]+&quot; &quot;);
}
System.out.println();
System.out.print(&quot;Profit: &quot;);
for(int i=0;i&lt;n;i++)
{
System.out.print(b[i]+&quot; &quot;);
}
System.out.println();
System.out.print(&quot;DeadLine:&quot;);
for(int i=0;i&lt;n;i++)
{
System.out.print(c[i]+&quot; &quot;);
}
System.out.println();
int max=c[0];
for(int i=0;i&lt;n;i++)
{
if(c[i]&gt;max)
{
max=c[i];
}
}
String x[]=new String[max];
int xx[]=new int[max];
int profit=0;
for(int i=0;i&lt;n;i++)
{
int pp=c[i];
pp=pp-1;
if(x[pp]==null )
{
x[pp]=a[i];
profit+=b[i];
}
else
{
while(pp!=-1)
{
if(x[pp]==null)
{
x[pp]=a[i];
profit+=b[i];
break;
}
pp=pp-1;
}
}
}
for(int i=0;i&lt;max;i++)
{
System.out.print(&quot;--&gt;&quot;+x[i]);
}
System.out.println();

System.out.print(&quot;Profit Earned&quot;+profit);
}
}
