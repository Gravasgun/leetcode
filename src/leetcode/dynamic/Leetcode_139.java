package leetcode.dynamic;

import java.util.List;

/**
 * 139.单词拆分
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 */
public class Leetcode_139 {
    /**
     * 本题可以理解为完全背包问题 字符串的长度为背包容量 字典中的单词为物品(子串)
     * 求：不同物品的排列，能否装满这个背包
     *
     * @param s 字符串(长度为背包容量)
     * @param wordDict 字典(字典中的每个元素为物品)
     * @return 如果能由字典中的单词排列成字符串s，返回true
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        // 创建dp数组，表示长度为i时，如果能由字典中的单词组成，那么dp[i]=true
        boolean[] result = new boolean[s.length() + 1];
        // 将result[0]初始化为true，为了递推出后面的元素
        result[0] = true;
        // 外层循环遍历背包，内层循环遍历物品(子串)
        // 本题是排列 因为要求字典中元素的顺序 所以先遍历背包，再遍历物品
        for (int i = 1; i < result.length; i++) {
            for (int j = 0; j < i; j++) {
                // 判断 字符串s从位置j到i的子串是否在单词字典中 并且 位置j之前的子串已经可以被拆分为单词字典中的单词
                if (wordDict.contains(s.substring(j, i)) && result[j]) {
                    // 如果满足条件，则将result[i]设置为true，
                    // 表示字符串s从位置0到i可以被拆分为单词字典中的单词
                    result[i] = true;
                }
            }
        }
        // 返回result数组的最后一个元素，表示字符串s是否可以被拆分为单词字典中的单词
        return result[result.length - 1];
    }
}
