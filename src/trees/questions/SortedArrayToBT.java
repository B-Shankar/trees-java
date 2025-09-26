package trees.questions;

//Sorted Array to Balanced BST: GFG
public class SortedArrayToBT {
    class Node {
        private int value;
        private Node left;
        private Node right;

        Node(int value) {
            this.value = value;
        }
    }

    // Recursive function to construct BST
    private Node sortedArrayToBalancedBT(int[] arr, int start, int end) {
        if (start > end) return null;

        // Find the middle element
        int mid = start + (end - start) / 2;

        // Create root node
        Node root = new Node(arr[mid]);

        // Create left subtree
        root.left = sortedArrayToBalancedBT(arr, start, mid - 1);

        // Create right subtree
        root.right = sortedArrayToBalancedBT(arr, mid + 1, end);

        return root;
    }

    public Node sortedArrayToBST(int[] arr) {
        return sortedArrayToBalancedBT(arr, 0, arr.length - 1);
    }

    static void preOrder(Node root) {
        if (root == null) return;
        System.out.print(root.value + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {
        SortedArrayToBT tree = new SortedArrayToBT();
        int[] arr = {1,2,3,4};

        Node root = tree.sortedArrayToBST(arr);
        preOrder(root);
    }
}
