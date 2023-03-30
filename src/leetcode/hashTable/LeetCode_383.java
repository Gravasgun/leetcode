package leetcode.hashTable;

public class LeetCode_383 {
    /**
     * 383.赎金信
     * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
     * 如果可以，返回 true ；否则返回 false 。
     * magazine中的每个字符只能在 ransomNote 中使用一次。
     * @param ransomNote 赎金信字符串
     * @param magazine 杂志字符串
     * @return 如果 magazine 可以用来构成 ransomNote，返回 true，否则返回 false
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        // 初始化长度为 26 的整型数组，用于记录 magazine 中每个字符出现的次数
        int[] list = new int[26];
        // 遍历 magazine 中的每个字符，更新字符出现的次数
        for (char c : magazine.toCharArray()) {
            list[c - 'a']++; // 将出现过的字符的计数加 1
        }
        // 遍历 ransomNote 中的每个字符，更新数组中对应字符的计数
        for (char c : ransomNote.toCharArray()) {
            list[c - 'a']--; // 将对应字符的计数减 1
        }
        // 遍历数组，如果有任何一个字符的计数小于零，说明无法构成 ransomNote，返回 false
        for (int i : list) {
            if (i < 0) {
                return false;
            }
        }
        // 遍历完数组后仍没有返回 false，则说明可以用 magazine 构成 ransomNote，返回 true
        return true;
    }
}
