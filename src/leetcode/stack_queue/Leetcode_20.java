package leetcode.stack_queue;

import java.util.Stack;

/**
 * 20.有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 */
public class Leetcode_20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>(); // 创建一个栈用于存储左括号
        for (char c : s.toCharArray()) { // 遍历字符串中的每个字符
            if (c == '(' || c == '[' || c == '{') { // 如果字符是左括号，则将其推入栈中
                stack.push(c);
            } else if (c == ')' && !stack.isEmpty() && stack.peek() == '(') { // 如果字符是右括号，则检查栈顶元素是否是相应的左括号
                stack.pop(); // 如果是，则将其弹出栈
            } else if (c == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            } else if (c == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            } else {
                return false; // 如果字符不是括号或者与栈顶元素不匹配，则字符串无效，返回false
            }
        }
        return stack.isEmpty(); // 遍历完字符串后，检查栈是否为空，如果为空，则字符串有效，返回true；否则，返回false
    }
}
