package leetcode.dynamic;

/**
 * 213.打家劫舍II
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，
 * 这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
 */
public class Leetcode_213 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        // 返回两种情况下的较大值：
        // 1. 从第一间房屋到倒数第二间房屋进行抢劫
        // 2. 从第二间房屋到最后一间房屋进行抢劫
        return Math.max(robHelper(nums, 0, nums.length - 2), robHelper(nums, 1, nums.length - 1));
    }

    public int robHelper(int[] nums, int startIndex, int endIndex) {
        // 创建一个数组来保存计算结果
        int[] result = new int[endIndex - startIndex + 1];
        // 初始化数组的前两个元素
        result[0] = nums[startIndex];
        if (endIndex - startIndex >= 1) {
            result[1] = Math.max(nums[startIndex], nums[startIndex + 1]);
        }
        // 从第三个元素开始遍历数组
        for (int i = 2; i < result.length; i++) {
            // 每个房屋可以选择抢劫或不抢劫，选择抢劫金额最大的方案
            // 若抢劫第i个房屋，则最大金额为result[i-2] + nums[i+startIndex]
            // 若不抢劫第i个房屋，则最大金额为result[i-1]
            // 取两者中的较大值作为当前房屋的最大抢劫金额
            result[i] = Math.max(result[i - 1], (result[i - 2] + nums[i + startIndex]));
        }
        // 返回最后一个房屋的最大抢劫金额
        return result[result.length - 1];
    }
}