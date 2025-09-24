package trees.AVL;

class AVL {

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

    public AVL() {}

    public int height() {
        return height(root);
    }

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

    public void insert(int value) {
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
        return rotate(node);
    }

    private Node rotate(Node node) {
        if (height(node.left) - height(node.right) > 1) {
            //Left Heavy
            if (height(node.left.left) - height(node.left.right) > 0) {
                //Left-Left Case
                return rightRotate(node);
            }

            if (height(node.left.left) - height(node.left.right) < 0) {
                //Left-Right Case
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }

        if (height(node.left) - height(node.right) < -1) {
            //Right Heavy
            if (height(node.right.left) - height(node.right.right) < 0) {
                //Right-Right Case
                return leftRotate(node);
            }

            if (height(node.right.left) - height(node.right.right) > 0) {
                //Right-Left Case
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }

        return node;
    }

    private Node rightRotate(Node p) {
        Node c = p.left;
        Node t = c.right;

        c.right = p;
        p.left = t;

        p.height = 1 + Math.max(height(p.left), height(p.right));
        c.height = 1 + Math.max(height(c.left), height(c.right));
        return c;
    }

    private Node leftRotate(Node c) {
        Node p = c.right;
        Node t = p.left;

        p.left = c;
        c.right = t;

        c.height = 1 + Math.max(height(c.left), height(c.right));
        p.height = 1 + Math.max(height(p.left), height(p.right));

        return p;
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

    public void populateSorted(int[] values) {
        populateSorted(values, 0, values.length - 1);
    }

    // Helper method to populate a balanced BST from a sorted array
    //Steps:
    //1. Find the middle element of the array and make it the root.
    //2. Recursively do the same for the left half and right half of the array
    private void populateSorted(int[] values, int start, int end) {
        if (start > end) {
            return;
        }

        int mid = (start + end) / 2;
        this.insert(values[mid]);
        populateSorted(values, start, mid - 1);
        populateSorted(values, mid + 1, end);
    }
}
