package leetcode.tree;

/**
 * 543.二叉树的直径
 * 给你一棵二叉树的根节点，返回该树的 直径 。
 * 二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。
 * 这条路径可能经过也可能不经过根节点 root 。
 * 两节点之间路径的 长度 由它们之间边数表示。
 */
public class Leetcode_543 {
    // 初始化最大直径为最小值
    int max = Integer.MIN_VALUE;

    /**
     * 计算二叉树的直径
     *
     * @param root 根节点
     * @return 二叉树的直径
     */
    public int diameterOfBinaryTree(TreeNode root) {
        // 如果根节点为空，直径为 0
        if (root == null) {
            return 0;
        }
        // 进行后序遍历计算直径
        // 没有返回值是因为 只需要在遍历这棵二叉树的时候记录每一个节点的最大直径
        postOrder(root);
        // 返回最大直径
        return max;
    }

    /**
     * 后序遍历计算节点的深度，并更新最大直径
     *
     * @param temp 当前节点
     * @return 当前节点的深度
     */
    private int postOrder(TreeNode temp) {
        // 如果当前节点为空，深度为 0
        if (temp == null) {
            return 0;
        }
        // 递归计算左子树的深度
        int left = postOrder(temp.left);
        // 递归计算右子树的深度
        int right = postOrder(temp.right);
        // 更新最大直径（取每一个节点的最大直径）
        // 包括经过根节点和不经过根节点两种情况
        max = Math.max(max, left + right);
        // 返回当前节点的深度（左子树和右子树中深度较大的值加一）
        return Math.max(left, right) + 1;
    }
}