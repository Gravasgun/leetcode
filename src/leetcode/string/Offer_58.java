package leetcode.string;

public class Offer_58 {
    /**
     * 剑指Offer58-II.左旋转字符串
     * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
     * 请定义一个函数实现字符串左旋转操作的功能。
     * 比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
     *
     * @param s
     * @param n
     * @return
     */
    public String reverseLeftWords(String s, int n) {
        char[] chars = s.toCharArray();
        char[] newChars = new char[chars.length];
        int index = n;
        int start = 0;
        //将不变的元素挨个赋值给新的char数组
        for (int i = 0; i < chars.length - n; i++) {
            newChars[i] = chars[index++];
        }
        //将变化的元素继续挨个赋值给新的char数组
        for (int i = chars.length - n; i < chars.length; i++) {
            newChars[i] = chars[start++];
        }
        return new String(newChars);
    }
}
