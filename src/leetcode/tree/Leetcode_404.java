package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_404 {
    List<Integer> list = new ArrayList<>();
    // 计算二叉树中所有左叶子节点的值的和
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 如果当前节点的左子节点存在且为叶子节点，则将其值添加到列表中
        if (root.left != null && root.left.left == null && root.left.right == null) {
            list.add(root.left.val);
        }
        // 递归处理左子树
        sumOfLeftLeaves(root.left);
        // 递归处理右子树
        sumOfLeftLeaves(root.right);
        // 计算左叶子节点的值的和并返回
        return list.stream().mapToInt(Integer::intValue).sum();
    }
}
