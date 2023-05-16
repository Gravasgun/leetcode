package leetcode.greedy;

import java.util.Arrays;

/**
 * 455.分发饼干
 * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干
 * 对每个孩子 i，都有一个胃口值 g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j，都有一个尺寸 s[j]
 * 如果 s[j] >= g[i]，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足
 * 你的目标是尽可能满足越多数量的孩子，并输出这个最大数值
 */
public class Leetcode_455 {
    public int findContentChildren(int[] g, int[] s) {
        // 局部最优:小饼干喂给胃口小的，充分利用饼干尺寸喂饱一个
        // 全局最优:喂饱尽可能多的小孩
        Arrays.sort(g); // 对孩子的胃口数组进行排序
        Arrays.sort(s); // 对饼干尺寸数组进行排序
        int count = 0; // 记录满足的孩子数量
        // 遍历饼干尺寸数组，并保证满足孩子数量不超过孩子胃口数组的长度
        for (int i = 0; i < s.length && count < g.length; i++) {
            // 如果当前孩子的胃口小于等于当前饼干的尺寸，则可以满足该孩子
            if (g[count] <= s[i]) {
                count++; // 满足的孩子数量加1
            }
            // 不满足的情况，直接让下一块饼干与当前孩子的食量进行比较(i++)
        }
        return count; // 返回满足的孩子数量
    }
}