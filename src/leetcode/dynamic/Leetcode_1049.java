package leetcode.dynamic;

import java.util.Arrays;

/**
 * 1049.最后一块石头的重量II
 * 有一堆石头，用整数数组 stones 表示。其中 stones[i] 表示第 i 块石头的重量。
 * 每一回合，从中选出任意两块石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下
 * 如果 x == y，那么两块石头都会被完全粉碎；
 * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 * 最后，最多只会剩下一块 石头。返回此石头 最小的可能重量 。如果没有石头剩下，就返回 0。
 */
public class Leetcode_1049 {
    /**
     * 让石头分成重量相同的两堆，相撞之后剩下的石头最小，这样就化解成01背包问题了
     *
     * @param stones
     * @return
     */
    public int lastStoneWeightII(int[] stones) {
        // 如果数组为空或者数组中没元素 直接返回0
        if (stones == null || stones.length == 0) {
            return 0;
        }
        // 计算石头数组的总和
        int sum = Arrays.stream(stones).sum();
        // 目标值为总和的一半
        int target = sum / 2;
        // 用于保存中间结果的数组
        int[] result = new int[target + 1];
        for (int i = 0; i < stones.length; i++) {
            for (int j = result.length - 1; j >= stones[i]; j--) {
                // 动态规划更新结果数组
                // 当前石头的重量 stones[i] <= j，可以选择放入或不放入背包
                // Math.max(result[j], result[j - stones[i]] + stones[i]) 表示在放入或不放入当前石头的两种选择中选择较大的值
                result[j] = Math.max(result[j], result[j - stones[i]] + stones[i]);
            }
        }
        // 返回两堆石头的重量差的最小值
        // 总和减去两倍最大的两堆石头的重量之和即为结果
        return sum - 2 * result[result.length - 1];
    }
}
