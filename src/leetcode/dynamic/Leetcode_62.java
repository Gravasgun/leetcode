package leetcode.dynamic;

public class Leetcode_62 {
    public int uniquePaths(int m, int n) {
        // result[i][j]:到达坐标为(i,j)有result[i][j]种不同的路径
        int[][] result = new int[m][n];
        // 初始化第一列
        for (int i = 0; i < result.length; i++) {
            result[i][0] = 1;
        }
        // 初始化第一行
        for (int i = 0; i < result[0].length; i++) {
            result[0][i] = 1;
        }
        // 填充dp数组 因为dp[i][j]是由dp[i][j-1]和dp[i-1][j]推导出来的
        // 所以应该 从前往后 从上往下遍历
        for (int i = 1; i < result.length; i++) {
            for (int j = 1; j < result[0].length; j++) {
                result[i][j] = result[i][j - 1] + result[i - 1][j];
            }
        }
        // 返回到达(m,n)的路径数量
        return result[result.length - 1][result[0].length - 1];
    }
}
