package leetcode.stack_queue;

/**
 * 239.滑动窗口最大值
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回 滑动窗口中的最大值 。
 */
public class Leetcode_239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1]; // 存储结果的数组
        int index = 0; // 结果数组的下标
        for (int i = 0; i <= n - k; i++) { // 遍历每个滑动窗口
            int max = Integer.MIN_VALUE; // 当前窗口的最大值，初始值为负无穷大
            for (int j = i; j < i + k; j++) { // 遍历窗口内的元素
                max = Math.max(max, nums[j]); // 找出当前窗口内的最大值
            }
            result[index++] = max; // 将当前窗口的最大值加入到结果数组中
        }
        return result;
    }
}