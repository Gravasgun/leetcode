package leetcode.dynamic;

import java.util.Arrays;

public class Leetcode_494 {
    public int findTargetSumWays(int[] nums, int target) {
        // 求和
        int sum = Arrays.stream(nums).sum();
        if ((sum + target) % 2 == 1) {
            return 0;
        }
        if (target < 0 && -target > sum) {
            return 0;
        }
        // left(正数)、right(负数)、sum(数组和)、target(目标和)
        // left + right = sum
        // left - right = target
        // left = (sum + target) / 2
        int size = (sum + target) / 2;
        // 定义dp数组 dp[j]:装满容量为j的背包有dp[j]种方式
        int[] result = new int[size + 1];
        // 初始化dp数组
        result[0] = 1;
        // 填充dp数组
        for (int i = 0; i < nums.length; i++) {
            for (int j = result.length - 1; j >= nums[i]; j--) {
                result[j] += result[j - nums[i]];
            }
        }
        return result[result.length - 1];
    }
}
