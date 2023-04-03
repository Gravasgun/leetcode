package leetcode.stack_queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 225.用队列实现栈
 * 请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。
 * 实现 MyStack 类：
 * void push(int x) 将元素 x 压入栈顶。
 * int pop() 移除并返回栈顶元素。
 * int top() 返回栈顶元素。
 * boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。
 * 注意：
 * 你只能使用队列的基本操作 —— 也就是 push to back、peek/pop from front、size 和 is empty 这些操作。
 * 你所使用的语言也许不支持队列。 你可以使用 list （列表）或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
 */
public class Leetcode_225 {
    // 两个队列实现栈
    Queue<Integer> queue1;
    Queue<Integer> queue2;

    // 构造函数，初始化两个队列
    public Leetcode_225() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    // 压入一个元素
    public void push(int x) {
        // 将元素添加到第二个队列的末尾
        queue2.offer(x);
        // 将第一个队列中的所有元素都移动到第二个队列之后，它们的顺序会被交换，第二个队列就成为了栈的顶部
        while (!queue1.isEmpty()) {
            queue2.offer(queue1.poll());
        }
        // 交换两个队列，使第二个队列变为第一个队列
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    // 弹出栈顶元素
    public int pop() {
        return queue1.poll();
    }

    // 获取栈顶元素
    public int top() {
        return queue1.peek();
    }

    // 判断栈是否为空
    public boolean empty() {
        return queue1.isEmpty();
    }
}
