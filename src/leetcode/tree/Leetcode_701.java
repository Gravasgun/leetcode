package leetcode.tree;

public class Leetcode_701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (root.val > val) {
            TreeNode left = insertIntoBST(root.left, val);
            root.left = left;
        }
        if (root.val < val) {
            TreeNode right = insertIntoBST(root.right, val);
            root.right = right;
        }
        return root;
    }
}
