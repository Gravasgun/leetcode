package leetcode.tree;

/**
 * 669.修剪二叉搜索树
 * 给你二叉搜索树的根节点 root ，同时给定最小边界low 和最大边界 high。通过修剪二叉搜索树，使得所有节点的值在[low, high]中。
 * 修剪树 不应该 改变保留在树中的元素的相对结构 (即，如果没有被移除，原有的父代子代关系都应当保留)。 可以证明，存在 唯一的答案 。
 * 所以结果应当返回修剪好的二叉搜索树的新的根节点。注意，根节点可能会根据给定的边界发生改变。
 */
public class Leetcode_669 {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        // 如果根节点为空，返回null
        if (root == null) {
            return null;
        }
        // 如果根节点的值不在[low, high]范围内
        // 如果根节点的值小于low，说明根节点及其左子树都不在[low, high]范围内，递归修剪右子树
        if (root.val < low) {
            return trimBST(root.right, low, high);
        }
        // 如果根节点的值大于high，说明根节点及其右子树都不在[low, high]范围内，递归修剪左子树
        if (root.val > high) {
            return trimBST(root.left, low, high);
        }
        // 如果根节点的值在[low, high]范围内，递归修剪左子树和右子树
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        // 返回修剪后的根节点
        return root;
    }
}
