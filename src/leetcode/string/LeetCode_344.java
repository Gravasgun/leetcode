package leetcode.string;

import java.util.Stack;

public class LeetCode_344 {
    /**
     * 344.反转字符串
     * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组s的形式给出。
     * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用O(1)的额外空间解决这一问题。
     *
     * @param s
     */

    //方法一：双指针
    public void reverseStringMethodOne(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

    //方法二：栈
    public void reverseString(char[] s) {
        Stack<Character> stack = new Stack<>();
        //入栈
        for (char c : s) {
            stack.push(c);
        }
        //出栈
        for (int i = 0; i < s.length; i++) {
            s[i] = stack.pop();
        }
    }
}
