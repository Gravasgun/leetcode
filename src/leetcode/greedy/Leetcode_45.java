package leetcode.greedy;

/**
 * 45.跳跃游戏II
 * 给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
 * 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
 * 0 <= j <= nums[i]
 * i + j < n
 * 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
 */
public class Leetcode_45 {
    public int jump(int[] nums) {
        // 如果数组只有一个元素，则不需要跳跃，步数为0
        if (nums.length == 1) {
            return 0;
        }
        // 步数计数器
        int result = 0;
        // 当前能够跳跃的最大范围
        int maxRange = 0;
        // 当前步数内能够达到的最远位置
        int tempRange = 0;
        // 遍历当前能够跳跃的最大范围
        for (int i = 0; i <= tempRange; i++) {
            // 更新每个位置能够跳跃的最大范围
            maxRange = Math.max(maxRange, i + nums[i]);
            // 如果有一个的最大范围大于等于数组的最后一个索引，则已经到达最后一个位置，增加步数并结束循环
            if (maxRange >= nums.length - 1) {
                result++;
                break;
            }
            // 当遍历到当前步数内的最远位置时，需要进行下一步跳跃
            if (i == tempRange && tempRange < nums.length - 1) {
                result++;
                // 更新下一步的当前步数内能够达到的最远位置
                tempRange = maxRange;
            }
        }
        // 返回最少步数
        return result;
    }
}