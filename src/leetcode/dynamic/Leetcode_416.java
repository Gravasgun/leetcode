package leetcode.dynamic;

import java.util.Arrays;

/**
 * 416.分割等和子集
 * 给你一个 只包含正整数 的 非空 数组 nums 。
 * 请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 */
public class Leetcode_416 {
    /**
     * 本题可以抽象为01背包问题：
     * 1.背包的体积为target
     * 2.背包要放入的商品（集合里的元素）重量为 元素的数值，价值也为元素的数值
     * 3.背包如果正好装满，说明找到了总和为 sum / 2 的子集
     * 4.背包中每一个元素是不可重复放入
     *
     * @param nums
     * @return
     */
    public static boolean canPartition(int[] nums) {
        // 检查输入数组是否为空或长度为零
        if (nums == null || nums.length == 0) {
            return false;
        }
        // 计算数组中所有元素的总和
        int sum = Arrays.stream(nums).sum();
        // 如果总和不是偶数，则无法将数组划分为和相等的两个子集
        if (sum % 2 != 0) {
            return false;
        }
        // 计算目标值，即总和的一半
        int target = sum / 2;
        // 创建数组用于记录达到目标值时的最大子集和
        int[] result = new int[target + 1];
        // 动态规划求解
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                // 更新result[j]的值为result[j]和result[j - nums[i]] + nums[i]的较大值
                result[j] = Math.max(result[j], result[j - nums[i]] + nums[i]);
            }
        }
        // 如果目标值等于result[target]，表示可以将数组划分为和相等的两个子集
        return target == result[target];
    }
}