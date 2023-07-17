package leetcode.tree;

public class Leetcode_538 {
    int pre;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        convert(root);
        return root;
    }

    private void convert(TreeNode root) {
        if (root == null) {
            return;
        }
        convertBST(root.right);
        root.val += pre;
        pre = root.val;
        convertBST(root.left);
    }
}
