package leetcode.tree;

public class Leetcode_404 {
    /**
     * 404.左叶子之和
     * 给定二叉树的根节点root，返回所有左叶子之和。
     *
     * @param root
     * @return
     */
    public int sumOfLeftLeaves(TreeNode root) {
        // 如果当前节点为空，则返回0
        if (root == null) {
            return 0;
        }
        // 递归计算左子树中所有左叶子节点的和，存储在leftSum变量中
        int leftSum = sumOfLeftLeaves(root.left);
        // 递归计算右子树中所有左叶子节点的和，存储在rightSum变量中
        int rightSum = sumOfLeftLeaves(root.right);
        // 定义一个变量midValue表示当前节点的值，默认为0
        int midValue = 0;
        // 如果当前节点有左孩子，且左孩子是叶子节点，将其值赋给midValue变量
        if (root.left != null && root.left.left == null && root.left.right == null) {
            midValue = root.left.val;
        }
        // 返回所有左叶子节点的和，即midValue与leftSum、rightSum相加的结果
        return midValue + leftSum + rightSum;
    }
}
