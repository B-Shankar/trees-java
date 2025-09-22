package trees;

//Binary Search Tree: BTS
class BinarySearchTree {

    public class Node {
        private int value;
        private int height;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    private Node root;

    public BinarySearchTree() {}

    public int height(Node node) {
        if (node == null) {
            return -1;
        }
        return node.height;
    }

    public boolean isEmpty () {
        return root == null;
    }

    public void display() {
        display(root, "Root Node: ");
    }

    public void display(Node node, String details) {
        if (node == null) {
            return;
        }

        System.out.println(details + node.value);

        display(node.left, "Left child of " + node.value + ": ");
        display(node.right, "Right child of " + node.value + ": ");
    }

    private void insert(int value) {
        root = insert(value, root);
    }

    private Node insert (int value, Node node) {
        if (node == null) {
            node = new Node(value);
            return node;
        }

        if (value < node.value) {
            node.left = insert(value, node.left);
        }

        if (value > node.value) {
            node.right = insert(value, node.right);
        }

        node.height = 1 + Math.max(height(node.left), height(node.right));
        return node;
    }

    public boolean balanced() {
        return balanced(root);
    }

    public boolean balanced(Node node) {
        if (node == null) {
            return true;
        }

        int balanceFactor = height(node.left) - height(node.right);
        if (Math.abs(balanceFactor) > 1) {
            return false;
        }

        return balanced(node.left) && balanced(node.right);
        //return Math.abs(height(node.left) - height(node.right)) <= 1 && balanced(node.left) && balanced(node.right);
    }

    public void populate (int[] values) {
        for (int i = 0; i < values.length ; i++) {
            this.insert(values[i]);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        int[] values = {15, 10, 20, 5, 12, 8};
        bst.populate(values);

        bst.display();

        System.out.println("Is the tree balanced? " + bst.balanced());
    }
}
