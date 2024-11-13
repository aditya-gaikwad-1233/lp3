// https://takeuforward.org/data-structure/fractional-knapsack-problem-greedy-approach/
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Item {
    int weight;
    int value;

    Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }

    double valuePerWeight() {
        return (double) value / weight;
    }
}

class Main {

    public static void fractionalKnapsack() {
        int[] weights = {10, 20, 30};
        int[] values = {60, 100, 120};
        int capacity = 50;
        double res = 0.0;

        List<Item> items = new ArrayList<>();
        for (int i = 0; i < weights.length; i++) {
            items.add(new Item(weights[i], values[i]));
        }

        items.sort(Comparator.comparingDouble(Item::valuePerWeight).reversed());

        for (Item item : items) {
            if (capacity <= 0) {
                break;
            }
            if (item.weight > capacity) {
                res += capacity * item.valuePerWeight();
                capacity = 0;
            } else {
                res += item.value;
                capacity -= item.weight;
            }
        }

        System.out.println((int) res);
    }

    public static void main(String[] args) {
        fractionalKnapsack();
    }
}
