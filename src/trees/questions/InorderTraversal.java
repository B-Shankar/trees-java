package trees.questions;

import java.util.ArrayList;
import java.util.List;

//94. Binary Tree Inorder Traversal
public class InorderTraversal {
    
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
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            inorder(root, result);
            return result;
        }

        private void inorder(TreeNode node, List<Integer> result) {
            if (node == null) return;
            inorder(node.left, result);
            result.add(node.val);
            inorder(node.right, result);
        }
    }

    public static void main(String[] args) {
        InorderTraversal it = new InorderTraversal();
        Solution solution = it.new Solution();

        // Build tree: 1 -> null, 2 -> 3
        TreeNode root = it.new TreeNode(1);
        root.right = it.new TreeNode(2);
        root.right.left = it.new TreeNode(3);

        List<Integer> result = solution.inorderTraversal(root);
        System.out.println(result); // [1, 3, 2]
    }
}
