package leetcode.string;

public class LeetCode_459 {
    /**
     * 459. 重复的子字符串
     * 给定一个非空的字符串 s ，检查是否可以通过由它的一个子串重复多次构成。
     * @param s
     * @return
     */
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length(); // 字符串长度
        // 从字符串的中间位置开始，逐渐缩小子串的长度
        for (int i = n / 2; i >= 1; i--) {
            // 如果能够被整除，则说明可能存在重复子串
            if (n % i == 0) {
                // 子串的数量
                int m = n / i;
                // 取出子串
                String sub = s.substring(0, i);
                StringBuilder sb = new StringBuilder();
                // 将子串重复 m 次，得到一个新的字符串
                for (int j = 0; j < m; j++) {
                    sb.append(sub);
                }
                // 如果新字符串和原字符串相同，则说明原字符串可以由这个子串重复多次构成
                if (sb.toString().equals(s)) {
                    return true;
                }
            }
        }
        return false; // 无法由子串重复构成
    }
}
