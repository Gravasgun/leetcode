package leetcode.tree;

/**
 * 700.二叉搜索树中的搜索
 * 给定二叉搜索树（BST）的根节点 root 和一个整数值 val。
 * 你需要在 BST 中找到节点值等于 val 的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 null 。
 */
public class Leetcode_700 {
    public TreeNode searchBST(TreeNode root, int val) {
        // 如果根节点为空，返回null
        if (root == null) {
            return null;
        }
        // 如果根节点的值等于给定值，返回该节点
        if (root.val == val) {
            return root;
        }
        // 在左子树中递归搜索
        TreeNode leftNode = searchBST(root.left, val);
        // 在右子树中递归搜索
        TreeNode rightNode = searchBST(root.right, val);
        // 如果左子树中找到了节点，返回该节点
        if (leftNode != null) {
            return leftNode;
        }
        // 如果右子树中找到了节点，返回该节点
        if (rightNode != null) {
            return rightNode;
        }
        // 如果左右子树都没有找到节点，返回null
        return null;
    }
}
