package leetcode.string;

public class LeetCode_151 {
    /**
     * 151.反转字符串中的单词
     * 给你一个字符串s，请你反转字符串中单词的顺序。
     * 单词是由非空格字符组成的字符串。s中使用至少一个空格将字符串中的单词分隔开。
     * 返回单词顺序颠倒且单词之间用单个空格连接的结果字符串。
     * 输入字符串s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
     *
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        //1.去除首尾以及中间多余空格
        chars = removeExtraSpaces(chars);
        //2.整个字符串反转
        reverse(chars, 0, chars.length - 1);
        //3.单词反转
        reverseEachWord(chars);
        return new String(chars);
    }

    //单词反转
    public void reverseEachWord(char[] chars) {
        int startIndex = 0;
        //这里的=，是为了让endIndex永远指向单词末的尾后一个位置，这样 reverse 的实参更好设置
        for (int endIndex = 0; endIndex <= chars.length; endIndex++) {
            if (endIndex == chars.length || chars[endIndex] == ' ') {
                reverse(chars, startIndex, endIndex - 1);
                startIndex = endIndex + 1;
            }
        }
    }

    //反转字符串
    public void reverse(char[] chars, int i, int j) {
        if (j >= chars.length) {
            System.out.println("set a wrong right");
            return;
        }
        while (i < j) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
    }

    //用快慢指针去除首尾以及中间多余空格
    public char[] removeExtraSpaces(char[] chars) {
        int slow = 0;
        for (int fast = 0; fast < chars.length; fast++) {
            //先用fast移除所有空格
            if (chars[fast] != ' ') {
                //用slow加空格,除第一个单词外，单词末尾要加空格
                if (slow != 0) {
                    chars[slow++] = ' ';
                }
                //fast遇到空格或遍历到字符串末尾，就证明遍历完一个单词了
                while (fast < chars.length && chars[fast] != ' ') {
                    chars[slow++] = chars[fast++];
                }
            }
        }
        char[] newChars = new char[slow];
        //复制数组中的元素
        for (int i = 0; i < slow; i++) {
            newChars[i] = chars[i];
        }
        return newChars;
    }
}
