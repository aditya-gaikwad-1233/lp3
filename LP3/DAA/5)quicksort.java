import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

class Main {
    
    // Function to perform deterministic Quick Sort
    public static int deterministicPartition(ArrayList<Integer> arr, int low, int high) {
        int pivot = arr.get(low); // Pivot is the first element
        int left = low + 1;
        int right = high;

        while (true) {
            while (left <= right && arr.get(left) <= pivot) {
                left++;
            }
            while (left <= right && arr.get(right) >= pivot) {
                right--;
            }
            if (left > right) {
                break;
            }
            Collections.swap(arr, left, right);
        }
        Collections.swap(arr, low, right);
        return right;
    }

    public static void deterministicQuickSort(ArrayList<Integer> arr, int low, int high, int[] comparisons, int[] swaps) {
        if (low < high) {
            int pivotIndex = deterministicPartition(arr, low, high);
            comparisons[0] += (high - low); // Count comparisons made during partition
            swaps[0] += 2;                  // Count the swaps made during partition

            deterministicQuickSort(arr, low, pivotIndex - 1, comparisons, swaps);
            deterministicQuickSort(arr, pivotIndex + 1, high, comparisons, swaps);
        }
    }

    // Function to perform randomized Quick Sort
    public static int randomizedPartition(ArrayList<Integer> arr, int low, int high) {
        int pivotIndex = low + new Random().nextInt(high - low + 1);
        Collections.swap(arr, low, pivotIndex); // Swap pivot with the first element
        int pivot = arr.get(low);
        int left = low + 1;
        int right = high;

        while (true) {
            while (left <= right && arr.get(left) <= pivot) {
                left++;
            }
            while (left <= right && arr.get(right) >= pivot) {
                right--;
            }
            if (left > right) {
                break;
            }
            Collections.swap(arr, left, right);
        }
        Collections.swap(arr, low, right);
        return right;
    }

    public static void randomizedQuickSort(ArrayList<Integer> arr, int low, int high, int[] comparisons, int[] swaps) {
        if (low < high) {
            int pivotIndex = randomizedPartition(arr, low, high);
            comparisons[0] += (high - low); // Count comparisons made during partition
            swaps[0] += 2;                  // Count the swaps made during partition

            randomizedQuickSort(arr, low, pivotIndex - 1, comparisons, swaps);
            randomizedQuickSort(arr, pivotIndex + 1, high, comparisons, swaps);
        }
    }

    // Function to print the array
    public static void printArray(ArrayList<Integer> arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        ArrayList<Integer> arr1 = new ArrayList<>();
        
        System.out.println("Enter elements: ");
        for (int i = 0; i < n; i++) {
            arr1.add(scanner.nextInt());
        }
        ArrayList<Integer> arr2 = new ArrayList<>(arr1);

        int ch;
        while (true) {
            int[] comparisonsDet = {0}, swapsDet = {0};
            int[] comparisonsRand = {0}, swapsRand = {0};

            System.out.println("1.Deterministic Quick Sort\n2.Randomized Quick Sort\n3.Exit");
            System.out.print("Enter your choice: ");
            ch = scanner.nextInt();
            
            if (ch == 1) {
                System.out.println("Original array for deterministic quick sort:");
                printArray(arr1);

                deterministicQuickSort(arr1, 0, arr1.size() - 1, comparisonsDet, swapsDet);

                System.out.println("Sorted array (Deterministic):");
                printArray(arr1);
                System.out.println("Deterministic Quick Sort Comparisons: " + comparisonsDet[0]);
                System.out.println("Deterministic Quick Sort Swaps: " + swapsDet[0]);
            } 
            else if (ch == 2) {
                System.out.println("\nOriginal array for randomized quick sort:");
                printArray(arr2);

                randomizedQuickSort(arr2, 0, arr2.size() - 1, comparisonsRand, swapsRand);

                System.out.println("Sorted array (Randomized):");
                printArray(arr2);
                System.out.println("Randomized Quick Sort Comparisons: " + comparisonsRand[0]);
                System.out.println("Randomized Quick Sort Swaps: " + swapsRand[0]);
            } 
            else if (ch == 3) {
                break;
            }
        }

        scanner.close();
    }
}
