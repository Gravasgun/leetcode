package leetcode.tree;

public class Leetcode_543 {
    int max = Integer.MIN_VALUE;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        postorder(root);
        return max;
    }

    private int postorder(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = postorder(root.left);
        int right = postorder(root.right);
        max = Math.max(max, left + right);
        return Math.max(left, right) + 1;
    }
}
