package leetcode.hashTable;

public class LeetCode_242 {
    /**
     * 242.有效的字母异位词
     * 给定两个字符串s和t，编写一个函数来判断t是否是s的字母异位词。
     * 若s和t中每个字符出现的次数都相同，则称s和t互为字母异位词。
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        //判断两个字符串长度是否相等，不相等则直接返回false
        if (s.length() != t.length()) {
            return false;
        }
        //定义一个数组，来记录字符串s里字符出现的次数。
        int[] arr = new int[26];
        //0~25对应字母a~z
        //假设第一个字母是a，那么s.charAt(i) - 'a'=0，arr[0]++,就记录了a在字符串中出现的次数
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
            arr[t.charAt(i) - 'a']--;
        }
        //遍历这个数组，只要数组中出现一个元素不为0，这两个字符串就不是有效的字母异位词
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                return false;
            }
        }
        //数组所有元素都为零0，说明字符串s和t是字母异位词
        return true;
    }
}
