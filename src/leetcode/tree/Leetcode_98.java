package leetcode.tree;

public class Leetcode_98 {
    public boolean isValidBST(TreeNode root) {
        // 初始调用，上下限都为null
        return isValidBST(root, null, null);
    }

    // 递归函数，判断以temp为根节点的二叉树是否为一棵合法的BST，lower和upper表示上下限
    private boolean isValidBST(TreeNode temp, Integer lower, Integer upper) {
        if (temp == null) {
            return true;
        }
        if (lower != null && temp.val <= lower) {
            return false;
        }
        if (upper != null && temp.val >= upper) {
            return false;
        }
        return isValidBST(temp.left, lower, temp.val) && isValidBST(temp.right, temp.val, upper);
    }
}
