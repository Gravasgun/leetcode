package leetcode.tree;

/**
 * 236.二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：
 * “对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 */
public class Leetcode_236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 如果根节点为空，或者根节点就是p或q节点，则返回根节点
        if (root == null || root == p || root == q) {
            return root;
        }
        // 递归找出左子树中p和q的最近公共祖先节点
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        // 递归找出右子树中p和q的最近公共祖先节点
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 如果左子树和右子树都没有找到p和q的最近公共祖先节点，返回null
        if (left == null && right == null) {
            return null;
            // 如果左子树没有找到p和q的最近公共祖先节点，但右子树找到了，则返回右子树的结果
        } else if (left == null && right != null) {
            return right;
            // 如果右子树没有找到p和q的最近公共祖先节点，但左子树找到了，则返回左子树的结果
        } else if (left != null && right == null) {
            return left;
            // 如果左右子树都找到了p和q的最近公共祖先节点，则返回根节点
        } else {
            return root;
        }
    }
}
