package leetcode.tree;

public class Leetcode_450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            if (root.left == null && root.right != null) {
                return root.right;
            } else if (root.left != null && root.right == null) {
                return root.left;
            } else if (root.left == null && root.right == null) {
                return null;
            } else {
                TreeNode temp = root;
                temp = temp.right;
                while (temp.left != null) {
                    temp = temp.left;
                }
                temp.left = root.left;
                return root.right;
            }
        }
        TreeNode left = deleteNode(root.left, key);
        TreeNode right = deleteNode(root.right, key);
        root.left = left;
        root.right = right;
        return root;
    }
}
