package leetcode.dynamic;

/**
 * 583.两个字符串的删除操作
 * 给定两个单词 word1 和 word2 ，返回使得 word1 和  word2 相同所需的最小步数。
 * 每步 可以删除任意一个字符串中的一个字符。
 */
public class Leetcode_583 {
    /**
     * 计算两个字符串之间的最小删除操作次数，使得两个字符串相等（方法一）
     *
     * @param word1 第一个字符串
     * @param word2 第二个字符串
     * @return 最小删除操作次数
     */
    public int minDistanceMethodOne(String word1, String word2) {
        // dp[i][j]：以i-1为结尾的字符串word1，和以j-1位结尾的字符串word2，想要达到相等，所需要删除元素的最少次数
        int[][] result = new int[word1.length() + 1][word2.length() + 1];
        // 初始化第一行和第一列，表示将空字符串转换为word1和word2所需的操作次数
        for (int i = 0; i < result.length; i++) {
            result[i][0] = i;
        }
        for (int i = 0; i < result[0].length; i++) {
            result[0][i] = i;
        }
        // 逐步计算最小编辑距离
        for (int i = 1; i < result.length; i++) {
            for (int j = 1; j < result[0].length; j++) {
                // 当前字符相等，无需操作，取左上角的值
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    result[i][j] = result[i - 1][j - 1];
                } else {
                    // 当前字符不相等，取三种操作方式的最小值：
                    // 情况一：删word1[i - 1]，最少操作次数为dp[i - 1][j] + 1
                    // 情况二：删word2[j - 1]，最少操作次数为dp[i][j - 1] + 1
                    // 同时删word1[i - 1]和word2[j - 1]，操作的最少次数为dp[i - 1][j - 1] + 2
                    result[i][j] = Math.min(result[i - 1][j] + 1, Math.min(result[i][j - 1] + 1, result[i - 1][j - 1] + 2));
                }
            }
        }
        // 返回最小删除操作次数，即最后的结果
        return result[result.length - 1][result[0].length - 1];
    }

    /**
     * 计算两个字符串之间的最小删除操作次数，使得两个字符串相等
     * 先求最长公共子序列的长度
     * 最终返回word1与word2的length之和减去2倍的最长子序列的长度
     * 就是题目中所求的最少的删除次数
     *
     * @param word1 第一个字符串
     * @param word2 第二个字符串
     * @return 最小删除操作次数
     */
    public int minDistanceMethodTwo(String word1, String word2) {
        int[][] result = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 1; i < result.length; i++) {
            for (int j = 1; j < result[0].length; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    // 当前字符相等，说明不需要删除，可以继承前面的公共子序列长度
                    result[i][j] = result[i - 1][j - 1] + 1;
                } else {
                    // 当前字符不相等，需要考虑删除哪个字符可以使得公共子序列长度最大
                    result[i][j] = Math.max(result[i][j - 1], result[i - 1][j]);
                }
            }
        }
        // 最小删除操作次数 = word1长度 + word2长度 - 2 * 最长公共子序列长度
        return word1.length() + word2.length() - 2 * result[result.length - 1][result[0].length - 1];
    }
}
