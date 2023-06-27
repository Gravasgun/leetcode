package leetcode.dynamic;

public class CompletedBagProblem {
    public static void main(String[] args) {
        // 物品的重量
        int[] weights = new int[]{1, 3, 4};
        // 物品的价值
        int[] values = new int[]{15, 20, 30};
        // 背包的最大容量
        int bagSize = 4;
        // 一维数组
        testCompletedBagProblem(weights, values, bagSize);
        // 二维数组
        testCompletedBagProblem2(weights, values, bagSize);
    }

    private static void testCompletedBagProblem2(int[] weights, int[] values, int bagSize) {
        // 创建dp数组 dp[i][j]:容量为i的背包装[0,i]的物品的最大价值为dp[i][j]
        int[][] result = new int[weights.length][bagSize + 1];
        // 初始化dp数组的第一行
        for (int i = weights[0]; i < result[0].length; i++) {
            result[0][i] = values[0];
        }
        // 填充dp数组 先遍历物品 再遍历背包
        for (int i = 1; i < weights.length; i++) {
            for (int j = weights[i]; j < result[0].length; j++) {
                result[i][j] = Math.max(result[i - 1][j], result[i - 1][j - weights[i]] + values[i]);
            }
        }

        //遍历dp数组
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void testCompletedBagProblem(int[] weights, int[] values, int bagSize) {
        // 创建dp数组 dp[i]:容量为i的背包所装物品的最大价值为dp[i]
        int[] result = new int[bagSize + 1];
        // 先遍历物品 再遍历背包(可颠倒)
        for (int i = 0; i < weights.length; i++) {
            for (int j = weights[i]; j < result.length; j++) {
                result[j] = Math.max(result[j], result[j - weights[i]] + values[i]);
            }
        }
        System.out.println("一维数组------------------------");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();
        System.out.println("二维数组------------------------");
    }
}
