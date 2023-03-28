package leetcode.string;

public class LeetCode_541 {
    /**
     * 541.反转字符串II
     * 给定一个字符串s和一个整数k，从字符串开头算起，每计数至2k个字符，就反转这2k字符中的前k个字符。
     * 如果剩余字符少于k个，则将剩余字符全部反转。
     * 如果剩余字符小于2k但大于或等于k个，则反转前k个字符，其余字符保持原样。
     * @param s
     * @param k
     * @return
     */
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i += 2 * k) {
            // 1.每隔2k个字符,将前k个字符进行反转
            // 2.剩余字符小于2k但大于或等于k个，则反转前k个字符
            if (i + k <= chars.length) {
                //左闭右开
                reverse(chars, i, i + k - 1);
                //直接进入下一次循环，不执行第三种情况
                continue;
            }
            // 3.剩余字符少于k个，则将剩余字符全部反转。
            reverse(chars, i, chars.length - 1);
        }
        return new String(chars);
    }

    public void reverse(char[] c, int i, int j) {
        for (; i < j; i++) {
            char temp = c[i];
            c[i] = c[j];
            c[j] = temp;
            j--;
        }
    }
}
