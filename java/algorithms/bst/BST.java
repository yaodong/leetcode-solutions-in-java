package algorithms.bst;

public class BST {

    private class Node {
        private Character key;
        private Integer value;
        private Node left, right;
        private int N;
        public Node(Character key, Integer value, int n) {
            this.key = key;
            this.value = value;
            N = n;
        }
    }

    private Node root;
}
