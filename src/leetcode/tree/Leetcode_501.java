package leetcode.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Leetcode_501 {
    /**
     * 查找二叉搜索树中出现次数最多的节点值
     *
     * @param root 二叉搜索树的根节点
     * @return 出现次数最多的节点值组成的数组
     */
    public int[] findMode(TreeNode root) {
        // 用于存储节点值及其出现次数的映射关系
        Map<Integer, Integer> map = new HashMap<>();
        // 先序遍历二叉搜索树，统计节点值的出现次数
        preorder(root, map);
        // 将映射关系按照出现次数降序排序，并转换为列表
        List<Map.Entry<Integer, Integer>> list = map.entrySet().stream()
                .sorted((c1, c2) -> c2.getValue() - c1.getValue())
                .collect(Collectors.toList());
        // 用于存储出现次数最多的节点值
        List<Integer> result = new ArrayList<>();
        // 将出现次数最多的节点值添加到结果列表中
        result.add(list.get(0).getKey());
        for (int i = 1; i < list.size(); i++) {
            // 如果当前节点值的出现次数与前一个节点值的出现次数相等，则将该节点值添加到结果列表中
            if (list.get(i - 1).getValue() == list.get(i).getValue()) {
                result.add(list.get(i).getKey());
            } else {
                // 否则跳出循环
                break;
            }
        }
        // 将结果列表转换为数组并返回
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * 先序遍历二叉搜索树，统计节点值的出现次数
     *
     * @param root 二叉搜索树的根节点
     * @param map  用于存储节点值及其出现次数的映射关系
     */
    private void preorder(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) {
            return;
        }
        // 统计节点值的出现次数
        if (map.containsKey(root.val)) {
            map.put(root.val, map.get(root.val) + 1);
        } else {
            map.put(root.val, 1);
        }
        // 递归处理左子树
        preorder(root.left, map);
        // 递归处理右子树
        preorder(root.right, map);
    }
}