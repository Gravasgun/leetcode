package leetcode.tree;

/**
 * 701.二叉搜索树中的插入操作
 * 给定二叉搜索树（BST）的根节点 root 和要插入树中的值 value ，将值插入二叉搜索树。
 * 返回插入后二叉搜索树的根节点。 输入数据 保证 ，新值和原始二叉搜索树中的任意节点值都不同。
 */
public class Leetcode_701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        // 如果根节点为空，说明该树为空，直接创建一个新的节点作为根节点
        if (root == null) {
            return new TreeNode(val);
        }
        // 如果待插入的值小于根节点的值，说明待插入的节点应该在左子树中
        if (root.val > val) {
            // 递归调用该函数，传入根节点的左子节点作为新的根节点
            TreeNode left = insertIntoBST(root.left, val);
            // 将返回的左子树插入到根节点的左子节点中
            root.left = left;
        }
        // 如果待插入的值大于根节点的值，说明待插入的节点应该在右子树中
        if (root.val < val) {
            // 递归调用该函数，传入根节点的右子节点作为新的根节点
            TreeNode right = insertIntoBST(root.right, val);
            // 将返回的右子树插入到根节点的右子节点中
            root.right = right;
        }
        // 返回根节点
        return root;
    }
}
