package leetcode.dynamic;

/**
 * 72.编辑距离
 * 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数
 * 你可以对一个单词进行如下三种操作：
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 */
public class Leetcode_72 {
    /**
     * 计算将 word1 转换为 word2 所需的最小操作次数（方法一）
     *
     * @param word1 第一个字符串
     * @param word2 第二个字符串
     * @return 最小操作次数
     */
    public int minDistance(String word1, String word2) {
        // 创建一个二维数组，用于存储最小操作次数
        // result[i][j] 表示将 word1 的前 i 个字符转换为 word2 的前 j 个字符所需的最小操作次数
        int[][] result = new int[word1.length() + 1][word2.length() + 1];
        // 初始化第一行和第一列，表示将空字符串转换为 word1 和 word2 所需的操作次数
        for (int i = 0; i < result.length; i++) {
            result[i][0] = i;
        }
        for (int i = 0; i < result[0].length; i++) {
            result[0][i] = i;
        }
        // 逐步计算最小操作次数
        for (int i = 1; i < result.length; i++) {
            for (int j = 1; j < result[0].length; j++) {
                // 如果当前字符相等，无需操作，取左上角的值
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    result[i][j] = result[i - 1][j - 1];
                } else {
                    // 如果当前字符不相等，取三种操作方式的最小值：
                    // 情况一：替换操作，将 word1 的第 i 个字符替换为 word2 的第 j 个字符，操作次数为 result[i - 1][j - 1] + 1
                    // 情况二：插入操作，将 word2 的第 j 个字符插入到 word1 的第 i 个字符之前，操作次数为 result[i][j - 1] + 1
                    // 情况三：删除操作，将 word1 的第 i 个字符删除，操作次数为 result[i - 1][j] + 1
                    // 取这三种操作方式的最小值作为当前位置的最小操作次数
                    result[i][j] = Math.min(result[i - 1][j - 1] + 1, Math.min(result[i][j - 1] + 1, result[i - 1][j] + 1));
                }
            }
        }
        // 返回最后一个位置的最小操作次数，即最终的结果
        return result[result.length - 1][result[0].length - 1];
    }
}
