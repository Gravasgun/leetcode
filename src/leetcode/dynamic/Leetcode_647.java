package leetcode.dynamic;

/**
 * 647.回文子串
 * 给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
 * 回文字符串 是正着读和倒过来读一样的字符串。
 * 子字符串 是字符串中的由连续字符组成的一个序列。
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 */
public class Leetcode_647 {
    /**
     * 方法一：暴力
     * 计算字符串中回文子串的个数
     *
     * @param s 给定的字符串
     * @return 回文子串的个数
     */
    public int countSubstringsMethodOne(String s) {
        int length = s.length();
        int count = 0;
        // 遍历字符串的所有子串，并判断是否是回文串
        // 第一个for循环控制起始位置 第二个for循环控制终止位置
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                // 如果当前子串是回文串，则计数器加一
                if (isPalindromeSubstring(s.substring(i, j + 1))) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 判断给定的字符串是否是回文串
     *
     * @param s 给定的字符串
     * @return 是否是回文串
     */
    public boolean isPalindromeSubstring(String s) {
        int left = 0;
        int right = s.length() - 1;
        // 从字符串的两端开始向中间遍历，并判断对应字符是否相等
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 方法二：动态规划
     * @param s 给定的字符串
     * @return 回文子串的个数
     */
    public int countSubstringsMethodTwo(String s) {
        int result = 0;
        // dp[i][j]:表示区间范围[i,j]（左闭右闭）的子串是否是回文子串，如果是 dp[i][j]为true，否则为false
        boolean[][] dp = new boolean[s.length()][s.length()];
        // 从下到上 从左到右遍历
        // 因为当字符串长度大于2时，需要判断中间的字符串是否是回文子串
        // 中间是否是回文子串就是dp[i+1][j-1]
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                // 当前字符相等
                if (s.charAt(i) == s.charAt(j)) {
                    // 当子串长度为1或2时，一定是回文子串，结果加1
                    if (j - i <= 1) {
                        dp[i][j] = true;
                        result++;
                    }
                    // 当子串长度大于2时，判断去掉两端字符的子串是否为回文子串
                    else if (dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                        result++;
                    }
                }
            }
        }
        return result;
    }

}
