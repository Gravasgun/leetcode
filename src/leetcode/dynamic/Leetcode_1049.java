package leetcode.dynamic;

import java.util.Arrays;

public class Leetcode_1049 {
    public int lastStoneWeightII(int[] stones) {
        // 求和
        int sum = Arrays.stream(stones).sum();
        // 求背包容量
        int size = sum / 2;
        // 定义dp数组
        int[] result = new int[size + 1];
        // 填充dp数组 先遍历物品 再遍历背包 背包倒序遍历
        for (int i = 0; i < stones.length; i++) {
            for (int j = result.length - 1; j >= stones[i]; j--) {
                result[j] = Math.max(result[j], result[j - stones[i]] + stones[i]);
            }
        }
        // 求所剩石头最小 就是求背包容量一定的情况下最多能装多少
        return sum - 2 * result[result.length - 1];
    }
}
