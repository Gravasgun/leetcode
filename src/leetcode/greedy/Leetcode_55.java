package leetcode.greedy;

/**
 * 55.跳跃游戏
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标。
 */
public class Leetcode_55 {
    // 局部最优：每次取最大跳跃步数（取最大覆盖范围）
    // 整体最优：最后得到整体最大覆盖范围，看是否能到终点
    public boolean canJump(int[] nums) {
        // 如果数组只有一个元素，则可以直接跳到最后一个元素
        if (nums.length == 1) {
            return true;
        }
        // 记录当前能够跳跃的最大范围
        int maxRange = 0;
        // 遍历数组中的每个位置
        for (int i = 0; i <= maxRange; i++) {
            // 计算当前位置能够跳跃的最大范围
            int temp = i + nums[i];
            // 更新最大范围
            maxRange = Math.max(maxRange, temp);
            // 如果最大范围大于等于数组的最后一个索引，则可以跳跃到最后一个元素
            if (maxRange >= nums.length - 1) {
                return true;
            }
        }
        // 无法跳跃到最后一个元素
        return false;
    }
}