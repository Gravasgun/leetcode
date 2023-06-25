package leetcode.dynamic;

public class Leetcode_63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // dp[i][j]:到达(i,j)有dp[i][j]种不同路径
        int[][] result = new int[obstacleGrid.length][obstacleGrid[0].length];
        // 初始化第一行
        for (int i = 0; i < result[0].length; i++) {
            if (obstacleGrid[0][i] == 0) {
                result[0][i] = 1;
            } else {
                break;
            }
        }
        // 初始化第一列
        for (int i = 0; i < result.length; i++) {
            if (obstacleGrid[i][0] == 0) {
                result[i][0] = 1;
            } else {
                break;
            }
        }
        // 填充dp数组
        for (int i = 1; i < result.length; i++) {
            for (int j = 1; j < result[0].length; j++) {
                // 如果当前位置有障碍物
                if (obstacleGrid[i][j] == 1) {
                    result[i][j] = 0;
                    // 如果上方有障碍物
                } else if (obstacleGrid[i - 1][j] == 1) {
                    result[i][j] = result[i][j - 1];
                    // 如果左方有障碍物
                } else if (obstacleGrid[i][j - 1] == 1) {
                    result[i][j] = result[i - 1][j];
                    // 如果上方和左方都有障碍物
                } else if (obstacleGrid[i][j - 1] == 1 && obstacleGrid[i - 1][j] == 1) {
                    result[i][j] = 0;
                    // 上方和左方都没障碍物
                } else {
                    result[i][j] = result[i][j - 1] + result[i - 1][j];
                }
            }
        }
        // 返回到达(i,j)的不同路径数
        return result[result.length - 1][result[0].length - 1];
    }
}
