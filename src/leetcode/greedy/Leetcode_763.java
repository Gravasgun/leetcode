package leetcode.greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * 763.划分字母区间
 * 给你一个字符串 s 。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。
 * 注意，划分结果需要满足：将所有划分结果按顺序连接，得到的字符串仍然是 s。
 * 返回一个表示每个字符串片段的长度的列表。
 */
public class Leetcode_763 {
    public List<Integer> partitionLabels(String s) {
        // 用于存储结果的列表
        List<Integer> result = new ArrayList<>();
        // 将字符串转换为字符数组
        char[] chars = s.toCharArray();
        // 当前片段的最右边界
        int right = Integer.MIN_VALUE;
        // 临时变量，记录上一个片段的结束位置
        int temp = 0;
        for (int i = 0; i < chars.length; i++) {
            // 更新最右边界
            right = Math.max(right, findMaxIndex(chars[i], chars));
            // 如果当前位置是当前片段的最右边界
            if (i == right) {
                // 将片段长度加入结果列表
                result.add(right + 1 - temp);
                // 更新临时变量为下一个片段的起始位置
                temp = right + 1;
            }
        }
        // 返回结果列表
        return result;
    }

    private int findMaxIndex(char c, char[] chars) {
        // 从后向前遍历字符数组
        for (int i = chars.length - 1; i >= 0; i--) {
            // 找到字符 c 的最大索引位置
            if (c == chars[i]) {
                // 返回最大索引位置
                return i;
            }
        }
        // 如果未找到字符 c，则返回 -1
        return -1;
    }
}
