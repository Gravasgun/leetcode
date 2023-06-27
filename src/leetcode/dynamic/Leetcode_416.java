package leetcode.dynamic;

import java.util.Arrays;

public class Leetcode_416 {
    public boolean canPartition(int[] nums) {
        // 数组求和
        int sum = Arrays.stream(nums).sum();
        // 如果sum不是2的倍数 直接返回false
        if (sum % 2 != 0) {
            return false;
        }
        // 求背包容量
        int size = sum / 2;
        // 创建dp数组
        int[] result = new int[size + 1];
        // 本题可以抽象为 求背包容量为j的最大价值是否也为j
        for (int i = 0; i < nums.length; i++) {
            for (int j = result.length - 1; j >= nums[i]; j--) {
                result[j] = Math.max(result[j], result[j - nums[i]] + nums[i]);
            }
        }
        return result[result.length - 1] == size;
    }
}
