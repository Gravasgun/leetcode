package leetcode.greedy;

/**
 * 738.单调递增的数字
 * 当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。
 * 给定一个整数 n ，返回小于或等于 n 的最大数字，且数字呈单调递增。
 */
public class Leetcode_738 {
    public int monotoneIncreasingDigits(int n) {
        String str = String.valueOf(n);  // 将整数转换为字符串
        char[] chars = str.toCharArray();  // 将字符串转换为字符数组
        int start = str.length();  // 记录需要修改的起始位置，默认为字符串的长度
        // 从右往左遍历字符数组
        for (int i = chars.length - 1; i > 0; i--) {
            if (chars[i - 1] > chars[i]) {
                chars[i - 1]--;  // 将当前位的前一位数字减1
                start = i;  // 记录减1操作位置的索引
            }
        }
        // 将从索引start开始的所有数字都修改为9，以满足单调递增的要求
        for (int i = start; i < chars.length; i++) {
            chars[i] = '9';
        }
        return Integer.parseInt(String.valueOf(chars));  // 将字符数组转换为整数并返回
    }
}