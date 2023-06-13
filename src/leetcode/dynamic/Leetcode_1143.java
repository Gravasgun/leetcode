package leetcode.dynamic;

/**
 * 1143.最长公共子序列
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
 */
public class Leetcode_1143 {
    /**
     * 最长公共子序列
     *
     * @param text1 第一个字符串
     * @param text2 第二个字符串
     * @return 最长公共子序列的长度
     */
    public int longestCommonSubsequence(String text1, String text2) {
        // 创建二维数组result，用于记录最长公共子序列的长度
        int[][] result = new int[text1.length() + 1][text2.length() + 1];
        // 遍历text1和text2的每个字符，填充result数组
        for (int i = 1; i < result.length; i++) {
            for (int j = 1; j < result[0].length; j++) {
                // 当前字符相等，可以构成公共子序列
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    // 在前一个状态的基础上加1，表示当前字符被包含在最长公共子序列中
                    result[i][j] = result[i - 1][j - 1] + 1;
                } else {
                    // 当前字符不相等，无法构成公共子序列
                    // 选择前一个状态中的两种选择中的较大值
                    // 1. 去掉text1的当前字符，保持text2不变
                    // 2. 去掉text2的当前字符，保持text1不变
                    result[i][j] = Math.max(result[i - 1][j], result[i][j - 1]);
                }
            }
        }
        // 返回最终结果，即result数组右下角的值，表示最长公共子序列的长度
        return result[result.length - 1][result[0].length - 1];
    }
}