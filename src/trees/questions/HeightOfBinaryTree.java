package trees.questions;

//Maximum Depth of Binary Tree: GFG
class HeightOfBinaryTree {
    private static class Node {
        private int value;
        private Node right;
        private Node left;

        public Node(int value) {
            this.value = value;
        }
    }

    public static int height(Node root) {
        if (root == null)
            return -1;

        // compute the height of left and right subtrees
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        // Representation of the input tree:
        //     12
        //    /  \
        //   8   18
        //  / \
        // 5   11
        Node root = new Node(12);
        root.left = new Node(8);
        root.right = new Node(18);
        root.left.left = new Node(5);
        root.left.right = new Node(11);

        System.out.println(height(root));
    }
}
