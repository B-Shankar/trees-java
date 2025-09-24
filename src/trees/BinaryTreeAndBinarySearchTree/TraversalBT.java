package trees.BinaryTreeAndBinarySearchTree;

import java.util.Scanner;

public class TraversalBT {

    private BinaryTrees.Node root;

    public TraversalBT(BinaryTrees.Node root) {
        this.root = root;
    }

    // 1. Pre-Order Traversal: Root -> Left -> Right
    //Note: Pre-order traversal is often used to create a copy of the tree.
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(BinaryTrees.Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    // 2. In-Order Traversal: Left -> Root -> Right
    //Note: In a binary search tree, in-order traversal yields values in ascending order.
    //That is why it is used to get sorted output from a BST.
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(BinaryTrees.Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.value + " ");
        inOrder(node.right);
    }

    // 3. Post-Order Traversal: Left -> Right -> Root
    //Note: Post-Order traversal is often used to delete the tree or free up memory.
    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(BinaryTrees.Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value + " ");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTrees binaryTrees = new BinaryTrees();
        binaryTrees.populate(scanner);

        // Prettier display
        //binaryTrees.prettierDisplay();

        // Traversal
        TraversalBT traversal = new TraversalBT(binaryTrees.getRoot());
        System.out.print("Pre-order Traversal: ");
        traversal.preOrder();

        System.out.println();

        System.out.print("In-order Traversal: ");
        traversal.inOrder();

        System.out.println();

        System.out.print("Post-order Traversal: ");
        traversal.postOrder();

        scanner.close();
    }
}
