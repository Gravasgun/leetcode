package leetcode.stack_queue;

import java.util.Stack;

/**
 * 232.用栈实现队列
 * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
 * 实现 MyQueue 类：
 * void push(int x) 将元素 x 推到队列的末尾
 * int pop() 从队列的开头移除并返回元素
 * int peek() 返回队列开头的元素
 * boolean empty() 如果队列为空，返回 true ；否则，返回 false
 * 说明：
 * 你 只能 使用标准的栈操作 —— 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
 * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 */
public class Leetcode_232 {
    Stack<Integer> inStack;  // 定义一个进栈，用于存储进入队列的元素
    Stack<Integer> outStack; // 定义一个出栈，用于存储弹出队列的元素

    public Leetcode_232() {  // 构造函数，初始化进栈和出栈
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    public void push(int x) {  // 将元素推入队列的方法
        inStack.push(x);  // 直接将元素推入进栈
    }

    public int pop() {  // 从队列中弹出元素的方法
        if (outStack.isEmpty()) {  // 如果出栈为空
            while (!inStack.isEmpty()) {  // 将进栈中的元素全部倒入出栈
                outStack.push(inStack.pop());
            }
        }
        return outStack.pop();  // 从出栈中弹出队列中的元素
    }

    public int peek() {  // 查看队列中下一个元素的方法
        if (outStack.isEmpty()) {  // 如果出栈为空
            while (!inStack.isEmpty()) {  // 将进栈中的元素全部倒入出栈
                outStack.push(inStack.pop());
            }
        }
        return outStack.peek();  // 返回出栈顶部的元素，即队列中的下一个元素
    }

    public boolean empty() {  // 检查队列是否为空的方法
        return outStack.isEmpty() && inStack.isEmpty();  // 只有当进栈和出栈均为空时，队列才为空
    }
}