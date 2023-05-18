package leetcode.greedy;

/**
 * 134.加油站
 * 在一条环路上有 n 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
 * 给定两个整数数组 gas 和 cost ，如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1 。如果存在解，则 保证 它是 唯一 的。
 */
public class Leetcode_134 {
    /**
     * 解法一：暴力法
     *
     * @param gas  每个加油站的汽油量数组
     * @param cost 到达下一个加油站所需的花费数组
     * @return 能够绕行一圈的起始加油站的索引，如果不存在返回-1
     */
    public int canCompleteCircuitMethodOne(int[] gas, int[] cost) {
        for (int i = 0; i < gas.length; i++) {
            int rest = gas[i] - cost[i]; // 计算当前加油站的剩余汽油量
            int index = (i + 1) % gas.length; // 下一个加油站的索引

            // 当剩余汽油量大于零且还未回到起始加油站时继续循环
            while (rest > 0 && i != index) {
                rest += gas[index] - cost[index]; // 更新剩余汽油量
                index = (index + 1) % gas.length; // 更新下一个加油站的索引
            }

            // 如果剩余汽油量大于等于零且回到起始加油站，说明可以完成一圈行驶
            if (rest >= 0 && index == i) {
                return index; // 返回起始加油站的索引
            }
        }

        return -1; // 没有找到满足条件的起始加油站，返回-1
    }

    /**
     * 解法二：贪心法
     * 局部最优：当前累加rest[i]的和curSum一旦小于0，起始位置至少要是i+1，因为从i之前开始一定不行
     * 全局最优：找到可以跑一圈的起始位置
     *
     * @param gas  每个加油站的汽油量数组
     * @param cost 到达下一个加油站所需的花费数组
     * @return 能够绕行一圈的起始加油站的索引，如果不存在返回-1
     */
    public int canCompleteCircuitMethodTwo(int[] gas, int[] cost) {
        int totalSum = 0; // 总剩余汽油量
        int tempSum = 0; // 当前连续加油站剩余汽油量的累积和
        int startIndex = 0; // 起始加油站的索引
        for (int i = 0; i < gas.length; i++) {
            tempSum += (gas[i] - cost[i]); // 计算当前加油站的剩余汽油量并累加到tempSum
            totalSum += (gas[i] - cost[i]); // 更新总剩余汽油量
            // 只要当前加油站的剩余汽油量小于0，说明前面的都不能作为起点，只能选择当前位置的下一个位置作为起点
            // 如果当前位置的下一个位置还是负数，那么循环还是会继续寻找当前加油站的剩余汽油量大于0的起始下标
            if (tempSum < 0) {
                tempSum = 0; // 重置tempSum，重新选择起始加油站
                startIndex = i + 1; // 更新起始加油站的索引为下一个加油站
            }
        }
        if (totalSum < 0) {
            return -1; // 如果总剩余汽油量小于0，无法绕行一圈，返回-1
        }
        return startIndex; // 返回起始加油站的索引
    }
}
