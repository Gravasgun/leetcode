package leetcode.tree;

public class Leetcode_530 {
    TreeNode pre;
    int result = Integer.MAX_VALUE;

    // 找到二叉搜索树中任意两个节点之间的最小差值
    public int getMinimumDifferenceMethodTwo(TreeNode root) {
        if (root == null) {
            return 0;
        }
        traversal(root);
        return result;
    }

    // 递归遍历二叉搜索树
    private void traversal(TreeNode temp) {
        if (temp == null) {
            return;
        }
        traversal(temp.left);
        if (pre != null) {
            result = Math.min(result, temp.val - pre.val);
        }
        pre = temp;
        traversal(temp.right);
    }
}
