package trees.questions;

//100. Same Tree
public class SameTree {

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;   // ✅ reference to itself
        TreeNode right;  // ✅ reference to itself
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        // both are null → same
        if (p == null && q == null) return true;
        // one null, one not → not same
        if (p == null || q == null) return false;
        // values differ → not same
        if (p.val != q.val) return false;

        // check left and right subtrees
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        SameTree st = new SameTree();
        TreeNode t1 = st.new TreeNode(1, st.new TreeNode(2), st.new TreeNode(3));
        TreeNode t2 = st.new TreeNode(1, st.new TreeNode(2), st.new TreeNode(3));

        System.out.println(st.isSameTree(t1, t2)); // ✅ true
    }
}
