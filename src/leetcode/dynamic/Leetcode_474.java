package leetcode.dynamic;

public class Leetcode_474 {
    public int findMaxForm(String[] strs, int m, int n) {
        // 创建dp数组 最多有i个0和j个1的strs的最大子集的长度为dp[i][j]
        int[][] result = new int[m + 1][n + 1];
        // 遍历物品
        for (String s : strs) {
            int zeroNum = 0;
            int oneNum = 0;
            // 统计重量
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') {
                    zeroNum++;
                } else {
                    oneNum++;
                }
            }
            //遍历背包 本题有两个维度的重量 对应两个维度的背包
            for (int i = result.length - 1; i >= zeroNum; i--) {
                for (int j = result[0].length - 1; j >= oneNum; j--) {
                    result[i][j] = Math.max(result[i][j], result[i - zeroNum][j - oneNum] + 1);
                }
            }
        }
        return result[result.length - 1][result[0].length - 1];
    }
}
