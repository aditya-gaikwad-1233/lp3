public class NQueens {
    private int[][] board;
    private int N;

    public NQueens(int N) {
        this.N = N;
        this.board = new int[N][N];
    }

    public void solveNQueens() {
        if (solve(0)) {
            printSolution();
        } else {
            System.out.println("No solution exists.");
        }
    }

    private boolean solve(int col) {
        if (col >= N) {
            return true; // All queens are placed
        }

        for (int i = 0; i < N; i++) {
            if (isSafe(i, col)) {
                board[i][col] = 1; // Place queen
                if (solve(col + 1)) {
                    return true;
                }
                board[i][col] = 0; // Backtrack
            }
        }
        return false;
    }

    private boolean isSafe(int row, int col) {
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 1) {
                return false; // Check row
            }
        }

        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false; // Check upper left diagonal
            }
        }

        for (int i = row, j = col; i < N && j >= 0; i++, j--) {
            if (board[i][j] == 1) {
                return false; // Check lower left diagonal
            }
        }

        return true;
    }

    private void printSolution() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int N = 8; // Change N to the desired board size
        NQueens nQueens = new NQueens(N);
        nQueens.solveNQueens();
    }
}
