package trees.questions;

import java.util.ArrayList;
import java.util.List;

//94. Binary Tree Inorder Traversal
public class postOrderTraversal {
    
    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            postorder(root, result);
            return result;
        }

        private void postorder(TreeNode node, List<Integer> result) {
            if (node == null) return;
            postorder(node.left, result);
            postorder(node.right, result);
            result.add(node.val);
        }
    }

    public static void main(String[] args) {
        postOrderTraversal it = new postOrderTraversal();
        Solution solution = it.new Solution();

        // Build tree: 1 -> null, 2 -> 3
        TreeNode root = it.new TreeNode(1);
        root.right = it.new TreeNode(2);
        root.right.left = it.new TreeNode(3);

        List<Integer> result = solution.postorderTraversal(root);
        System.out.println(result); // [1, 3, 2]
    }
}
