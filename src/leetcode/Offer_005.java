package leetcode;

public class Offer_005 {
    /**
     * 剑指offer005.替换空格
     * 请实现一个函数，把字符串s中的每个空格替换成"%20"。
     * @param s
     * @return
     */
    public String replaceSpace(String s) {
        //Java中，字符串都被设计成不可变的类型，即无法直接修改字符串的某一位字符，需要新建一个字符串实现。
        StringBuilder str = new StringBuilder();
        //遍历s中的每个字符c：
        for (Character c : s.toCharArray()) {
            //当c为空格时：向res后添加字符串"%20"；
            if (c == ' ') {
                str.append("%20");
            } else {
                //当c不为空格时：向res后添加字符c；
                str.append(c);
            }
        }
        return str.toString();
    }
}
