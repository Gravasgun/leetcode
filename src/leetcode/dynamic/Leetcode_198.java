package leetcode.dynamic;

/**
 * 198.打家劫舍
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
 * 影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 */
public class Leetcode_198 {
    public int rob(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        // 创建dp数组来保存计算结果 dp[i]:[0,i]范围内的最大金额
        int[] result = new int[nums.length];
        // 初始化dp数组的前两个元素
        result[0] = nums[0];
        result[1] = Math.max(nums[0], nums[1]);
        // 从第三个元素开始遍历数组
        for (int i = 2; i < result.length; i++) {
            // 每个房屋可以选择抢劫或不抢劫，选择抢劫金额最大的方案
            // 若抢劫第i个房屋，则最大金额为result[i-2] + nums[i]
            // 若不抢劫第i个房屋，则最大金额为result[i-1]
            // 取两者中的较大值作为当前房屋的最大抢劫金额
            result[i] = Math.max(result[i - 1], (result[i - 2] + nums[i]));
        }
        // 返回最后一个房屋的最大抢劫金额
        return result[result.length - 1];
    }
}