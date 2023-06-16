package leetcode.dynamic;

/**
 * 392.判断子序列
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。
 * （例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 */
public class Leetcode_392 {
    /**
     * 判断字符串 s 是否是字符串 t 的子序列
     *
     * @param s 字符串 s
     * @param t 字符串 t
     * @return 如果 s 是 t 的子序列，则返回 true，否则返回 false
     */
    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) {
            return false;
        }
        // 创建一个二维数组用于存储状态转移结果
        int[][] result = new int[s.length() + 1][t.length() + 1];
        // 进行状态转移计算
        for (int i = 1; i < result.length; i++) {
            for (int j = 1; j < result[0].length; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    // 如果当前字符相等，则在之前的状态基础上加一
                    result[i][j] = result[i - 1][j - 1] + 1;
                } else {
                    // 如果当前字符不相等，则继承之前的状态
                    result[i][j] = result[i][j - 1];
                }
            }
        }
        // 判断最后一个状态是否等于 s 的长度
        return result[result.length - 1][result[0].length - 1] == s.length();
    }
}
