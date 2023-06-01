package leetcode.dynamic;

/**
 * 474.一和零
 * 给你一个二进制字符串数组 strs 和两个整数 m 和 n
 * 请你找出并返回 strs 的最大子集的长度，该子集中 最多 有 m 个 0 和 n 个 1
 * 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集
 */
public class Leetcode_474 {
    public int findMaxForm(String[] strs, int m, int n) {
        // 创建dp数组 最多有i个0和j个1的strs的最大子集的长度为dp[i][j]
        int[][] result = new int[m + 1][n + 1];
        // 遍历字符串数组中的每个字符串，一个字符串就相当于一个物品
        for (String s : strs) {
            // 记录字符串中零的数量，相当于重量
            int zeroNum = 0;
            // 记录字符串中一的数量，相当于重量
            int oneNum = 0;
            // 统计字符串中零和一的数量
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') {
                    zeroNum++;
                } else {
                    oneNum++;
                }
            }
            // 使用动态规划填充结果数组
            // m和n相当于两个背包
            // zeroNum和oneNum相当于一个物品的两个维度的重量
            for (int j = m; j >= zeroNum; j--) {
                for (int k = n; k >= oneNum; k--) {
                    // 选择当前字符串或不选择当前字符串，取较大值
                    // result[j - zeroNum][k - oneNum] + 1表示当前字符串的长度加上剩余容量为[j - zeroNum][k - oneNum]时的最大长度
                    result[j][k] = Math.max(result[j][k], result[j - zeroNum][k - oneNum] + 1);
                }
            }
        }
        // 返回结果数组中最右下角的元素，即能形成的最大字符串数量
        return result[m][n];
    }
}
