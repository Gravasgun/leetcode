package leetcode.tree;

import java.util.Stack;

public class Leetcode_404 {
    /**
     * 404.左叶子之和
     * 给定二叉树的根节点root，返回所有左叶子之和。
     *
     * @param root
     * @return
     */
    public int sumOfLeftLeavesMethodOne(TreeNode root) {
        // 如果当前节点为空，则返回0
        if (root == null) {
            return 0;
        }
        // 递归计算左子树中所有左叶子节点的和，存储在leftSum变量中
        int leftSum = sumOfLeftLeavesMethodOne(root.left);
        // 递归计算右子树中所有左叶子节点的和，存储在rightSum变量中
        int rightSum = sumOfLeftLeavesMethodOne(root.right);
        // 定义一个变量midValue表示当前节点的值，默认为0
        int midValue = 0;
        // 如果当前节点有左孩子，且左孩子是叶子节点，将其值赋给midValue变量
        if (root.left != null && root.left.left == null && root.left.right == null) {
            midValue = root.left.val;
        }
        // 返回所有左叶子节点的和，即midValue与leftSum、rightSum相加的结果
        return midValue + leftSum + rightSum;
    }

    /**
     * 方法二：迭代
     * @param root
     * @return
     */
    public int sumOfLeftLeavesMethodTwo(TreeNode root) {
        // 如果当前节点为空，则返回0
        if (root == null) {
            return 0;
        }
        // 定义变量result来保存左叶子节点的和
        int result = 0;
        // 创建一个堆栈来存储需要遍历的节点
        Stack<TreeNode> stack = new Stack<>();
        // 将根节点加入堆栈中
        stack.push(root);
        // 开始迭代遍历二叉树
        while (!stack.isEmpty()) {
            // 取出堆栈中的最后一个节点，并从堆栈中移除
            TreeNode temp = stack.pop();
            // 判断当前节点的左子节点是否为叶子节点，如果是，则将左叶子节点的值加到结果中
            if (temp.left != null && temp.left.left == null && temp.left.right == null) {
                result += temp.left.val;
            }
            // 将当前节点的右子节点加入堆栈中
            if (temp.right != null) {
                stack.push(temp.right);
            }
            // 将当前节点的左子节点加入堆栈中
            if (temp.left != null) {
                stack.push(temp.left);
            }
        }
        // 返回结果
        return result;
    }
}
