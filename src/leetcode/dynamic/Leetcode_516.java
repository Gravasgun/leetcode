package leetcode.dynamic;

/**
 * 516.最长回文子序列
 *给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。
 * 子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。
 */
public class Leetcode_516 {
    public int longestPalindromeSubseq(String s) {
        // // dp[i][j]:表示区间范围[i,j]（左闭右闭）的回文子串的最大长度
        int[][] result = new int[s.length()][s.length()];
        // 初始化对角线上的元素，表示单个字符的回文子序列长度为1
        for (int i = 0; i < result.length; i++) {
            result[i][i] = 1;
        }
        // 从下往上，从左往右遍历矩阵
        for (int i = result.length - 1; i >= 0; i--) {
            for (int j = i + 1; j < result[0].length; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    // 当前字符相等，可以将两个字符都加入回文子序列，长度加2
                    result[i][j] = result[i + 1][j - 1] + 2;
                } else {
                    // 当前字符不相等，取左侧或下侧的最大回文子序列长度
                    result[i][j] = Math.max(result[i][j - 1], result[i + 1][j]);
                }
            }
        }
        // 返回矩阵的右上角元素，即整个字符串的最长回文子序列长度
        return result[0][result[0].length - 1];
    }
}
