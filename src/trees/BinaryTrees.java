package trees;

import java.util.Scanner;

public class BinaryTrees {

    private Node root;

    public BinaryTrees() {
    }

    public class Node {
        int value;
        Node right;
        Node left;

        Node(int value) {
            this.value = value;
        }
    }

    //insert element
    public void populate(Scanner scanner) {
        System.out.print("Enter the root node: " );
        int value = scanner.nextInt();
        root = new Node(value);
        populate(scanner, root);
    }

    private void populate(Scanner scanner, Node node) {
        System.out.println("Do you want to add a left child to " + node.value + "? (true/false)");
        boolean left = scanner.nextBoolean();
        if (left) {
            System.out.print("Enter the left to " + node.value + " child value: ");
            int leftValue = scanner.nextInt();
            node.left = new Node(leftValue);
            populate(scanner, node.left);
        }

        System.out.println("Do you want to add a right child to " + node.value + "? (true/false)");
        boolean right = scanner.nextBoolean();
        if (right) {
            System.out.print("Enter the right to " + node.value + " child value: ");
            int rightValue = scanner.nextInt();
            node.right = new Node(rightValue);
            populate(scanner, node.right);
        }
    }

    public Node getRoot() {
        return root;
    }

    public void display() {
        display(root, "");
    }

    private void display(Node node, String indent) {
        if (node == null) {
            return;
        }
        System.out.println(indent + node.value);
        display(node.left, indent + "\t");
        display(node.right, indent + "\t");
    }
    /* INPUT:
              15
            /    \
           6      9
         /   \
        8     14
         \
          10
    */
    /* OUTPUT:
        15
            6
                8
                    10
                14
            9
    */


    public void prettierDisplay() {
        prettierDisplay(root, 0);
    }

    private void prettierDisplay(Node node, int level) {
        if (node == null) {
            return;
        }

        prettierDisplay(node.right, level + 1);

        if (level != 0) {
            for (int i = 0; i < level - 1; i++) {
                System.out.print("|\t\t");
            }
            System.out.println("|------->" + node.value);
        } else {
            System.out.println(node.value);
        }
        prettierDisplay(node.left, level + 1);
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTrees binaryTrees = new BinaryTrees();
        binaryTrees.populate(scanner);
//        binaryTrees.display();
        binaryTrees.prettierDisplay();
        scanner.close();
    }
}
