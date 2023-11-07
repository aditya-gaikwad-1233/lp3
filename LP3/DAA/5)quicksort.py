Write a program for analysis of quick sort by using deterministic and randomized variant.
import random
import time

def deterministic_quick_sort(arr):
    if len(arr) <= 1:
        return arr

    pivot = arr[len(arr) // 2]
    left = [x for x in arr if x < pivot]
    middle = [x for x in arr if x == pivot]
    right = [x for x in arr if x > pivot]

    return deterministic_quick_sort(left) + middle + deterministic_quick_sort(right)

def randomized_quick_sort(arr):
    if len(arr) <= 1:
        return arr

    pivot = random.choice(arr)
    left = [x for x in arr if x < pivot]
    middle = [x for x in arr if x == pivot]
    right = [x for x in arr if x > pivot]

    return randomized_quick_sort(left) + middle + randomized_quick_sort(right)

def analyze_quick_sort(arr, variant):
    start_time = time.time()
    if variant == "deterministic":
        sorted_arr = deterministic_quick_sort(arr)
    elif variant == "randomized":
        sorted_arr = randomized_quick_sort(arr)
    end_time = time.time()

    execution_time = end_time - start_time

    return sorted_arr, execution_time

if __name__ == "__main__":
    arr = [5, 2, 9, 3, 6, 8, 1, 7]

    # Analyze the deterministic variant
    sorted_arr_deterministic, time_deterministic = analyze_quick_sort(arr.copy(), "deterministic")
    print(f"Deterministic Variant Sorted Array: {sorted_arr_deterministic}")
    print(f"Deterministic Variant Execution Time: {time_deterministic} seconds")

    # Analyze the randomized variant
    sorted_arr_randomized, time_randomized = analyze_quick_sort(arr.copy(), "randomized")
    print(f"Randomized Variant Sorted Array: {sorted_arr_randomized}")
    print(f"Randomized Variant Execution Time: {time_randomized} seconds")
