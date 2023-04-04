package leetcode.stack_queue;

import java.util.Stack;

/**
 * 150.逆波兰表达式求值
 * 给你一个字符串数组 tokens ，表示一个根据 逆波兰表示法 表示的算术表达式。
 * 请你计算该表达式。返回一个表示表达式值的整数。
 * 注意：
 * 有效的算符为 '+'、'-'、'*' 和 '/' 。
 * 每个操作数（运算对象）都可以是一个整数或者另一个表达式。
 * 两个整数之间的除法总是 向零截断 。
 * 表达式中不含除零运算。
 * 输入是一个根据逆波兰表示法表示的算术表达式。
 * 答案及所有中间计算结果可以用 32 位 整数表示。
 */
public class Leetcode_150 {
    public int evalRPN(String[] tokens) {
        // 创建一个栈来存储操作数和运算结果
        Stack<String> stack = new Stack<>();

        // 遍历逆波兰表达式
        for (String s : tokens) {
            // 如果当前字符串是操作符，弹出栈顶的两个元素进行运算
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                // 弹出栈顶的两个元素
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());

                // 判断操作符类型，进行相应的运算，并将结果压入栈中
                if (s.equals("+")) {
                    int num3 = num1 + num2;
                    stack.push(String.valueOf(num3));
                    continue; // 跳过后续的代码，进入下一轮循环
                }
                if (s.equals("-")) {
                    int num3 = num2 - num1;
                    stack.push(String.valueOf(num3));
                    continue;
                }
                if (s.equals("*")) {
                    int num3 = num1 * num2;
                    stack.push(String.valueOf(num3));
                    continue;
                }
                if (s.equals("/")) {
                    int num3 = num2 / num1;
                    stack.push(String.valueOf(num3));
                    continue;
                }
            } else {
                // 如果当前字符串是操作数，将其压入栈中
                stack.push(s);
            }
        }
        // 最后，栈顶元素就是逆波兰表达式的值，将其转换为整数并返回
        return Integer.parseInt(stack.pop());
    }
}