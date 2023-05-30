package leetcode.dynamic;

/**
 * 01背包问题
 * 给定一组物品，每个物品有自己的重量和价值。现有一个容量为bagSize的背包，
 * 需要在不超过背包容量的前提下，选择一些物品放入背包中，使得放入的物品总价值最大化。
 * 限制条件：
 * 每个物品要么完全放入背包，要么不放入。
 * 每个物品只有一个副本可用。
 * 背包只能装下一定重量的物品，超过背包容量的物品无法放入。
 */
public class BagProblem {
    public static void main(String[] args) {
        // 物品的重量
        int[] weights = new int[]{1, 3, 4};
        // 物品的价值
        int[] values = new int[]{15, 20, 30};
        // 背包的最大容量
        int bagSize = 4;
        // 动态规划方法
        testBagProblem(weights, values, bagSize);
    }

    private static void testBagProblem(int[] weights, int[] values, int bagSize) {
        // 创建dp数组 dp[i][j] 表示从下标为[0-i]的物品里任意取，放进容量为j的背包，价值总和最大是多少

        int[][] result = new int[weights.length][bagSize + 1];
        // 初始化第一行，表示只考虑第一个物品时，背包容量从1到bagSize的情况下的最大价值
        for (int i = weights[0]; i < result[0].length; i++) {
            result[0][i] = values[0];
        }
        // 动态规划 填充dp数组 计算背包容量从1到bagSize，考虑不同物品的情况下的最大价值
        for (int i = 1; i < result.length; i++) {
            for (int j = 1; j < result[0].length; j++) {
                // 当前物品的重量大于背包容量，无法放入背包，继承上一行的最大价值
                if (weights[i] > j) {
                    result[i][j] = result[i - 1][j];
                } else {
                    // 当前物品的重量小于等于背包容量，可以选择放入或不放入背包，取两种情况下的最大价值
                    result[i][j] = Math.max(result[i - 1][j], (result[i - 1][j - weights[i]] + values[i]));
                }
            }
        }
        // 打印结果数组
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
