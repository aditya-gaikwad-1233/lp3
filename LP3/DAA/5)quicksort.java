#Write a program for analysis of quick sort by using deterministic and randomized variant
import java.util.Arrays;
import java.util.Random;

public class QuickSortAnalysis {
    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 3, 6, 8, 1, 7};

        // Analyze the deterministic variant
        long startTimeDeterministic = System.nanoTime();
        deterministicQuickSort(arr.clone());
        long endTimeDeterministic = System.nanoTime();
        long executionTimeDeterministic = endTimeDeterministic - startTimeDeterministic;

        System.out.println("Deterministic Variant Sorted Array: " + Arrays.toString(arr));
        System.out.println("Deterministic Variant Execution Time: " + executionTimeDeterministic + " nanoseconds");

        // Analyze the randomized variant
        long startTimeRandomized = System.nanoTime();
        randomizedQuickSort(arr.clone());
        long endTimeRandomized = System.nanoTime();
        long executionTimeRandomized = endTimeRandomized - startTimeRandomized;

        System.out.println("Randomized Variant Sorted Array: " + Arrays.toString(arr));
        System.out.println("Randomized Variant Execution Time: " + executionTimeRandomized + " nanoseconds");
    }

    public static void deterministicQuickSort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }

        int pivot = arr[arr.length / 2];
        int[] left = Arrays.stream(arr).filter(x -> x < pivot).toArray();
        int[] middle = Arrays.stream(arr).filter(x -> x == pivot).toArray();
        int[] right = Arrays.stream(arr).filter(x -> x > pivot).toArray();

        deterministicQuickSort(left);
        deterministicQuickSort(right);

        System.arraycopy(left, 0, arr, 0, left.length);
        System.arraycopy(middle, 0, arr, left.length, middle.length);
        System.arraycopy(right, 0, arr, left.length + middle.length, right.length);
    }

    public static void randomizedQuickSort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }

        int pivotIndex = new Random().nextInt(arr.length);
        int pivot = arr[pivotIndex];

        int[] left = Arrays.stream(arr).filter(x -> x < pivot).toArray();
        int[] middle = Arrays.stream(arr).filter(x -> x == pivot).toArray();
        int[] right = Arrays.stream(arr).filter(x -> x > pivot).toArray();

        randomizedQuickSort(left);
        randomizedQuickSort(right);

        System.arraycopy(left, 0, arr, 0, left.length);
        System.arraycopy(middle, 0, arr, left.length, middle.length);
        System.arraycopy(right, 0, arr, left.length + middle.length, right.length);
    }
}
