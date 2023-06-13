package leetcode.greedy;

/**
 * 53.最大子数组和
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 子数组 是数组中的一个连续部分。
 */
public class Leetcode_53 {
    /**
     * 方法一：贪心
     *
     * @param nums 整数数组
     * @return 最大子数组和
     */
    public int maxSubArrayMethodOne(int[] nums) {
        // 检查数组是否为空或长度为零
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // 用于记录当前的最大和，初始值设置为整数的最小值
        int result = Integer.MIN_VALUE;
        // 用于记录当前连续子数组的和
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            // 将当前元素加到 sum 上
            sum += nums[i];
            // 更新最大和 result，取 sum 和 result 中较大的值作为新的 result
            result = Math.max(sum, result);
            // 如果 sum 小于等于 0，则将 sum 重置为 0，因为负数对后续子数组的和只会产生负面影响，将其舍弃
            if (sum <= 0) {
                sum = 0;
            }
        }
        return result; // 返回最大子序和
    }

    /**
     * 方法二：暴力解法
     *
     * @param nums 整数数组
     * @return 最大子数组和
     */
    public int maxSubArrayMethodTwo(int[] nums) {
        // 检查数组是否为空或长度为零
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // 初始化最大和为整型最小值
        int result = Integer.MIN_VALUE;
        // 外部循环遍历数组元素
        for (int i = 0; i < nums.length; i++) {
            int temp = 0; // 临时变量用于计算当前子数组的和

            // 内部循环遍历从当前位置到数组末尾的子数组
            for (int j = i; j < nums.length; j++) {
                // 累加当前子数组的元素到临时变量
                temp += nums[j];
                // 更新最大和为临时变量和当前已知的最大和中的较大值
                result = Math.max(temp, result);
            }
        }
        // 返回最大和
        return result;
    }

    /**
     * 方法三：动态规划
     *
     * @param nums 整数数组
     * @return 最大子数组和
     */
    public int maxSubArrayMethodThree(int[] nums) {
        // 检查数组是否为空或长度为零
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // 用于记录以当前元素为结尾的子数组的最大和
        int[] result = new int[nums.length];
        // 初始化第一个元素的最大和为自身
        result[0] = nums[0];
        // 用于记录最大子数组和，初始值为第一个元素
        int max = nums[0];
        for (int i = 1; i < result.length; i++) {
            // 状态转移方程：取当前元素和当前元素加上前一个元素结尾的子数组的最大和中的较大值
            result[i] = Math.max(nums[i], result[i - 1] + nums[i]);
            max = Math.max(max, result[i]); // 更新最大子数组和
        }
        // 返回最大子数组和
        return max;
    }
}