package leetcode.dynamic;

import java.util.List;

public class Leetcode_139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        // 创建dp数组，表示长度为i时，如果能由字典中的单词组成，那么dp[i]=true
        boolean[] result = new boolean[s.length() + 1];
        result[0] = true;
        // i代表总长度(结束下标) j代表起始下标
        // 求排列数 先遍历背包(s.length) 再遍历物品(s.substring(j, i))
        for (int i = 1; i < result.length; i++) {
            // 判断 字符串s从位置j到i的子串是否在单词字典中 并且 位置j之前的子串已经可以被拆分为单词字典中的单词
            for (int j = 0; j < i; j++) {
                if (wordDict.contains(s.substring(j, i)) && result[j]) {
                    result[i] = true;
                }
            }
        }
        return result[result.length - 1];
    }
}
