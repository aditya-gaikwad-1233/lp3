import java.util.*;

class Node {
    Node left;
    Node right;
    Character value;
    int frequency;

    public Node(Character value, int frequency) {
        this.value = value;
        this.frequency = frequency;
    }

    public Node(Node left, Node right, int frequency) {
        this.left = left;
        this.right = right;
        this.frequency = frequency;
    }

    public boolean isLeaf() {
        return this.left == null && this.right == null;
    }
}

class HuffmanEncoding {
    private PriorityQueue<Node> q;
    private String inputString;
    private Map<Character, String> encoding;

    public HuffmanEncoding(String inputString) {
        this.inputString = inputString;
        this.encoding = new HashMap<>();
        this.q = new PriorityQueue<>(Comparator.comparingInt(node -> node.frequency));
    }

    private void charFrequency() {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : inputString.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            q.add(new Node(entry.getKey(), entry.getValue()));
        }
    }

    private void buildTree() {
        while (q.size() > 1) {
            Node n1 = q.poll();
            Node n2 = q.poll();
            Node newNode = new Node(n1, n2, n1.frequency + n2.frequency);
            q.add(newNode);
        }
    }

    private void helper(Node node, String binaryStr) {
        if (node == null) return;
        if (node.isLeaf()) {
            encoding.put(node.value, binaryStr);
            return;
        }
        helper(node.left, binaryStr + "0");
        helper(node.right, binaryStr + "1");
    }

    public void huffmanEncoding() {
        if (q.isEmpty()) return;
        Node root = q.peek();
        helper(root, "");
    }

    public void printEncoding() {
        System.out.println(" Char | Huffman Code ");
        for (Map.Entry<Character, String> entry : encoding.entrySet()) {
            System.out.println(entry.getKey() +  " | " + entry.getValue());
        }
    }

    public void encode() {
        charFrequency();
        buildTree();
        huffmanEncoding();
        printEncoding();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter string to be encoded: ");
        String inputString = scanner.nextLine();

        HuffmanEncoding encode = new HuffmanEncoding(inputString);
        encode.encode();
        scanner.close();
    }
}
