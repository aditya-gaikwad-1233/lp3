#Write a program for analysis of quick sort by using deterministic and randomized variant
package com.JournalDev;
public class Main {
static final int N = 4;

// print the final solution matrix
static void printSolution(int board[][])
{
for (int i = 0; i &lt; N; i++) {
for (int j = 0; j &lt; N; j++)
System.out.print(&quot; &quot; + board[i][j]
+ &quot; &quot;);
System.out.println();
}
}

// function to check whether the position is safe or not
static boolean isSafe(int board[][], int row, int col)
{
int i, j;
for (i = 0; i &lt; col; i++)
if (board[row][i] == 1)
return false;

for (i = row, j = col; i &gt;= 0 &amp;&amp; j &gt;= 0; i--, j--)

if (board[i][j] == 1)
return false;

for (i = row, j = col; j &gt;= 0 &amp;&amp; i &lt; N; i++, j--)
if (board[i][j] == 1)
return false;

return true;
}

// The function that solves the problem using backtracking
public static boolean solveNQueen(int board[][], int col)
{
if (col &gt;= N)
return true;

for (int i = 0; i &lt; N; i++) {
//if it is safe to place the queen at position i,col -&gt; place it
if (isSafe(board, i, col)) {
board[i][col] = 1;

if (solveNQueen(board, col + 1))
return true;

//backtrack if the above condition is false
board[i][col] = 0;
}

}
return false;
}

public static void main(String args[])
{
int board[][] = { { 0, 0, 0, 0 },
{ 0, 0, 0, 0 },
{ 0, 0, 0, 0 },
{ 0, 0, 0, 0 } };

if (!solveNQueen(board, 0)) {
System.out.print(&quot;Solution does not exist&quot;);
return;
}

printSolution(board);

}
}
