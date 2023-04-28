package leetcode.tree;

/**
 * 98.验证二叉搜索树
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * 有效 二叉搜索树定义如下：
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 */
public class Leetcode_98 {
    public boolean isValidBST(TreeNode root) {
        // 初始调用，上下限都为null
        return isValidBST(root, null, null);
    }

    // 递归函数，判断以temp为根节点的二叉树是否为一棵合法的BST，lower和upper表示上下限
    private boolean isValidBST(TreeNode temp, Integer lower, Integer upper) {
        // 如果节点为空，返回true
        if (temp == null) {
            return true;
        }
        // 如果节点值小于等于lower或大于等于upper，则不满足BST的性质，返回false
        if (lower != null && temp.val <= lower) {
            return false;
        }
        if (upper != null && temp.val >= upper) {
            return false;
        }
        // 递归检查左右子树是否都是合法的BST，对于左子树，将temp.val作为上限，对于右子树，将temp.val作为下限
        return isValidBST(temp.left, lower, temp.val) && isValidBST(temp.right, temp.val, upper);
    }
}
