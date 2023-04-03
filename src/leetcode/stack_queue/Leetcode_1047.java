package leetcode.stack_queue;

import java.util.Stack;

/**
 * 1047.删除字符串中的所有相邻重复项
 * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 */
public class Leetcode_1047 {
    public String removeDuplicates(String s) {
        char[] chars = s.toCharArray(); // 将给定字符串转为字符数组
        Stack<Character> stack = new Stack<>(); // 创建一个栈来存储字符
        for (int i = 0; i < chars.length; i++) { // 遍历字符数组
            if (stack.isEmpty()) { // 如果栈为空，将当前字符压入栈中
                stack.push(chars[i]);
                continue;
            }
            if (stack.peek() != chars[i]) { // 如果栈顶字符与当前字符不同，将当前字符压入栈中
                stack.push(chars[i]);
                continue;
            }
            if (stack.peek() == chars[i]) { // 如果栈顶字符与当前字符相同，弹出栈顶字符
                stack.pop();
            }
        }
        StringBuilder stringBuilder = new StringBuilder(); // 创建一个StringBuilder对象
        int size = stack.size(); // 获取栈的大小
        for (int i = 0; i < size; i++) { // 依次从栈顶开始取出栈中的字符
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.reverse().toString(); // 将StringBuilder反转后返回字符串
    }
}
