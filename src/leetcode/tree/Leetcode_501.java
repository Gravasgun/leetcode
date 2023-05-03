package leetcode.tree;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 501.二叉搜索树中的众数
 * 给你一个含重复值的二叉搜索树（BST）的根节点 root ，找出并返回 BST 中的所有 众数（即，出现频率最高的元素）。
 * 如果树中有不止一个众数，可以按 任意顺序 返回。
 * 假定 BST 满足如下定义：
 * 结点左子树中所含节点的值 小于等于 当前节点的值
 * 结点右子树中所含节点的值 大于等于 当前节点的值
 * 左子树和右子树都是二叉搜索树
 */
public class Leetcode_501 {
    /**
     * 方法一：暴力
     * @param root
     * @return
     */
    public int[] findModeMethodOne(TreeNode root) {
        // 定义一个 List 存放二叉树的中序遍历结果
        List<Integer> list = new ArrayList<>();
        // 对二叉树进行中序遍历，并将遍历结果存放到 list 中
        List<Integer> inorderList = inorder(root, list);
        // 定义一个 List 存放众数结果
        List<Integer> result = new ArrayList<>();
        // 定义一个 Map 存放二叉树中节点出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        // 遍历二叉树中序遍历结果，统计每个节点出现的次数
        for (int i : inorderList) {
            if (map.containsKey(i)) {
                Integer value = map.get(i);
                map.put(i, ++value);
            } else {
                map.put(i, 1);
            }
        }
        // 对 map 中的键值对按照键（节点的值）排序，存放到 sortedMap 中
        Map<Integer, Integer> sortedMap = new TreeMap<>();
        sortedMap.putAll(map);
        // 将 sortedMap 中的键值对存放到 sortedList 中，并按照值（节点出现的次数）从大到小排序
        List<Map.Entry<Integer, Integer>> sortedList = sortedMap.entrySet().stream().sorted((c1, c2) -> c2.getValue().compareTo(c1.getValue())).collect(Collectors.toList());
        // 将 sortedList 中出现次数最多的节点的值存放到 result 中
        result.add(sortedList.get(0).getKey());
        // 如果后面的节点出现的次数与最大出现次数相同，则也加入到 result 中
        for (int i = 1; i < sortedList.size(); i++) {
            if (sortedList.get(i).getValue() == sortedList.get(i - 1).getValue()) {
                result.add(sortedList.get(i).getKey());
            } else {
                break;
            }
        }
        // 将 result 转换成 int[] 类型并返回
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * 中序遍历二叉树
     *
     * @param root 二叉树的根节点
     * @param list 存放遍历结果的 List
     * @return 返回遍历结果
     */
    public List<Integer> inorder(TreeNode root, List list) {
        if (root == null) {
            return list;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
        return list;
    }

    /**
     * 方法二：递归
     */
    List<Integer> resultList; // 存储众数的列表
    int count; // 当前数字的出现次数
    int maxCount; // 出现次数最大值
    TreeNode pre; // 上一个遍历到的节点

    public int[] findModeMethodTwo(TreeNode root) { // 查找二叉搜索树的众数
        resultList = new ArrayList<>();
        count = 0;
        maxCount = 0;
        inorder(root); // 中序遍历二叉树
        int[] resultNums = new int[resultList.size()];
        for (int i = 0; i < resultNums.length; i++) { // 将众数转化为数组返回
            resultNums[i] = resultList.get(i);
        }
        return resultNums;
    }

    private void inorder(TreeNode temp) { // 中序遍历
        if (temp == null) { // 如果节点为空，返回
            return;
        }
        inorder(temp.left); // 遍历左子树
        if (pre == null || pre.val != temp.val) { // 当前节点值与前一个节点值不同
            count = 1; // 重置计数器
        } else { // 当前节点值与前一个节点值相同
            count++; // 计数器加一
        }
        if (count > maxCount) { // 当前数字出现次数超过了历史最大值
            resultList.clear(); // 清空列表
            resultList.add(temp.val); // 添加当前数字到列表中
            maxCount = count; // 更新历史最大值
        } else if (count == maxCount) { // 当前数字出现次数等于历史最大值
            resultList.add(temp.val); // 添加当前数字到列表中
        }
        pre = temp; // 更新上一个遍历到的节点
        inorder(temp.right); // 遍历右子树
    }
}
