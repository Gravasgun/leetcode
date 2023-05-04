package leetcode.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 530.二叉搜索树的最小绝对差
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值。
 * 差值是一个正数，其数值等于两值之差的绝对值。
 */
public class Leetcode_530 {
    /**
     * 方法一：暴力解法
     *
     * @param root
     * @return
     */
    public int getMinimumDifferenceMethodOne(TreeNode root) {
        List<Integer> list = new ArrayList<>();   // 创建一个存储二叉树节点值的列表
        List<Integer> nums = preOrder(root, list);  // 调用 preOrder 方法来遍历二叉树并将其节点值存储到列表中
        Collections.sort(nums);  // 将节点值列表排序
        int minNum = Integer.MAX_VALUE;  // 创建一个变量用来存储最小差值，初始化为整型最大值
        for (int i = 0; i < nums.size() - 1; i++) {  // 遍历排序后的节点值列表
            if (Math.abs(nums.get(i) - nums.get(i + 1)) < minNum) {  // 计算相邻节点值之间的差值，并判断是否小于当前最小差值
                minNum = Math.abs(nums.get(i) - nums.get(i + 1));  // 更新最小差值
            }
        }
        return minNum;  // 返回最小差值
    }

    private List<Integer> preOrder(TreeNode root, List<Integer> list) {
        if (root == null) {  // 如果二叉树为空，直接返回列表
            return list;
        }
        list.add(root.val);  // 将当前节点值加入列表中
        preOrder(root.left, list);  // 递归遍历左子树
        preOrder(root.right, list);  // 递归遍历右子树
        return list;  // 返回存储节点值的列表
    }


    /**
     * 方法二：递归
     *
     * @param root
     * @return
     */
    // pre 存储当前遍历节点的前一个节点，result 存储最小差值的初始值为最大整数
    TreeNode pre;
    int result = Integer.MAX_VALUE;

    // 找到二叉搜索树中任意两个节点之间的最小差值
    public int getMinimumDifferenceMethodTwo(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 遍历整个二叉搜索树，找到最小差值
        traversal(root);
        // 返回最小差值
        return result;
    }

    // 递归遍历二叉搜索树
    private void traversal(TreeNode temp) {
        if (temp == null) {
            return;
        }
        // 先遍历左子树
        traversal(temp.left);
        // 如果 pre 不为空，则更新 result，即比较当前节点和前一个节点之间的差值是否更小
        if (pre != null) {
            result = Math.min(result, temp.val - pre.val);
        }
        // 更新 pre 为当前节点，继续遍历右子树
        pre = temp;
        traversal(temp.right);
    }
}
