package trees;

import java.util.Scanner;

public class TraversalBT {

    private BinaryTrees.Node root;

    public TraversalBT(BinaryTrees.Node root) {
        this.root = root;
    }

    // 1. Pre-Order Traversal: Root -> Left -> Right
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

        scanner.close();
    }
}
