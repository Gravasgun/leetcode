package leetcode.string;

public class LeetCode_28 {
    /**
     * 28.找出字符串中第一个匹配项的下标
     * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。
     * 如果 needle 不是 haystack 的一部分，则返回  -1 。
     *
     * @param haystack 要搜索的字符串
     * @param needle 要匹配的字符串
     * @return 匹配项的下标（如果找到）；-1（如果未找到）
     */
    public int strStr(String haystack, String needle) {
        // 获取haystack和needle的长度
        int haystackLen = haystack.length();
        int needleLen = needle.length();

        // 边界条件：如果needle为空字符串，则返回0
        if (needleLen == 0) {
            return 0;
        }

        // 如果haystack的长度小于needle的长度，则不可能匹配成功
        if (haystackLen < needleLen) {
            return -1;
        }

        // 遍历haystack中的每个字符，直到剩下的字符数不足以匹配needle
        // haystackLen - i >= needleLen 才能保证剩下的字符串匹配needle
        for (int i = 0; i <= haystackLen - needleLen; i++) {
            // 在haystack中寻找needle的匹配项
            boolean found = true;
            // 遍历needle中的每个字符，依次与haystack中对应的字符比较
            for (int j = 0; j < needleLen; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    // 如果有一个字符不匹配，则说明这个位置不是匹配项
                    found = false;
                    break;
                }
            }
            if (found) {
                // 如果找到了匹配项，则返回其下标
                return i;
            }
        }
        // 如果循环结束还没有找到匹配项，则返回-1
        return -1;
    }
}