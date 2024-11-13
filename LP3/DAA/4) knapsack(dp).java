import java.util.ArrayList;
import java.util.List;

class Main {

    public static int knapsack0_1(int[] values, int[] weights, int capacity) {
        int n = values.length;
        int[][] dp = new int[n + 1][capacity + 1];

        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= capacity; w++) {
                if (i == 0 || w == 0) {
                    dp[i][w] = 0;
                } else if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(values[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        List<Integer> selectedItems = new ArrayList<>();
        int i = n, j = capacity;
        while (i > 0 && j > 0) {
            if (dp[i][j] != dp[i - 1][j]) {
                selectedItems.add(i - 1);
                j -= weights[i - 1];
            }
            i--;
        }

        System.out.println("Maximum value: " + dp[n][capacity]);
        System.out.print("Selected items: ");
        for (int item : selectedItems) {
            System.out.print(item + " ");
        }
        System.out.println();

        return dp[n][capacity];
    }

    public static void main(String[] args) {
        int[] values = {60, 100, 120};
        int[] weights = {10, 20, 30};
        int capacity = 50;
        knapsack0_1(values, weights, capacity);
    }
}
