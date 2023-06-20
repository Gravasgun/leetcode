package leetcode.dynamic;

/**
 * 115.不同的子序列
 * 给你两个字符串 s 和 t ，统计并返回在 s 的 子序列 中 t 出现的个数。
 */
public class Leetcode_115 {
    public int numDistinct(String s, String t) {
        // 创建一个二维数组用于存储状态转移结果
        // dp[i][j]：以i-1为结尾的s子序列中出现以j-1为结尾的t的个数为dp[i][j]
        int[][] result = new int[s.length() + 1][t.length() + 1];
        // 初始化第一列，表示从字符串 s 中取空字符串，可以得到一个空字符串，因此结果为 1
        for (int i = 0; i < result.length; i++) {
            result[i][0] = 1;
        }
        // 进行状态转移计算
        for (int i = 1; i < result.length; i++) {
            for (int j = 1; j < result[0].length; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    // 如果当前字符相等，则有两种选择：
                    // 1. 选择当前字符，表示将该字符匹配到 t 的当前位置，然后继续匹配前面的字符
                    // 2. 不选择当前字符，表示将该字符舍弃，继续匹配前面的字符
                    result[i][j] = result[i - 1][j - 1] + result[i - 1][j];
                } else {
                    // 如果当前字符不相等，则只能将该字符舍弃，继续匹配前面的字符
                    result[i][j] = result[i - 1][j];
                }
            }
        }
        // 返回最后一个状态，表示从字符串 s 中匹配到字符串 t 的方法数
        return result[result.length - 1][result[0].length - 1];
    }
}
